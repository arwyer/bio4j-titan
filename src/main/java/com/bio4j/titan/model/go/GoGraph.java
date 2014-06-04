package com.bio4j.titan.model.go;

import com.ohnosequences.typedGraphs.*;

/*
  This interface contains an example graph types declaration.
*/
public interface GoGraph {

    /*
      A gene ontology term
    */
    interface Term<
            N extends Term<N, NT>, NT extends TermType<N, NT>
            >
            extends Node<N, NT> {
        /*
          These two methods are completely optional, they just give you a way of retrieving a particular property at the level of this interface.
        */
        public default String name() {
            return this.get(type().Name());
        }

        public default String id() {
            return this.get(type().Id());
        }
    }

    /*
      The type of a Term. Nested here we can find the properties of this type. Again, they could be defined anywhere; they are nested just for convenience.
    */
    interface TermType<
            N extends Term<N, NT>, NT extends TermType<N, NT>
            >
            extends Node.Type<N, NT> {

        public <P extends id<N, NT, P>> P Id();

        // properties
        interface id<
                N extends Term<N, NT>,
                NT extends TermType<N, NT>,
                P extends id<N, NT, P>
                >
                extends Property<N, NT, P, String> {
            @Override
            public default String name() {
                return "id";
            }

            @Override
            public default Class<String> valueClass() {
                return String.class;
            }
        }

        public <P extends name<N, NT, P>> P Name();

        interface name<
                N extends Term<N, NT>,
                NT extends TermType<N, NT>,
                P extends name<N, NT, P>
                >
                extends Property<N, NT, P, String> {
            @Override
            public default String name() {
                return "name";
            }

            @Override
            public default Class<String> valueClass() {
                return String.class;
            }
        }
    }

    // TODO Review cardinality of Relationships

    /*
    The hasPartOf relationship; it goes from terms to terms.
    */
    interface HasPartOf<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends HasPartOf<S, ST, R, RT, T, TT>, RT extends HasPartOfType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship<S, ST, R, RT, T, TT> {
    }

    interface HasPartOfType<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends HasPartOf<S, ST, R, RT, T, TT>, RT extends HasPartOfType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship.Type.ManyToMany<S, ST, R, RT, T, TT> {
    }


    /*
    The partOf relationship; it goes from terms to terms.
    */
    interface PartOf<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends PartOf<S, ST, R, RT, T, TT>, RT extends PartOfType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship<S, ST, R, RT, T, TT> {
    }

    interface PartOfType<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends PartOf<S, ST, R, RT, T, TT>, RT extends PartOfType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship.Type.ManyToMany<S, ST, R, RT, T, TT> {
    }

    /*
    The isA relationship; it goes from terms to terms.
    */
    interface IsA<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends IsA<S, ST, R, RT, T, TT>, RT extends IsAType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship<S, ST, R, RT, T, TT> {
    }

    interface IsAType<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends IsA<S, ST, R, RT, T, TT>, RT extends IsAType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship.Type.OneToMany<S, ST, R, RT, T, TT> {
    }

    /*
    The regulates relationship; it goes from terms to terms.
    */
    interface Regulates<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends Regulates<S, ST, R, RT, T, TT>, RT extends RegulatesType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship<S, ST, R, RT, T, TT> {
    }

    interface RegulatesType<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends Regulates<S, ST, R, RT, T, TT>, RT extends RegulatesType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship.Type.ManyToMany<S, ST, R, RT, T, TT> {
    }


    /*
    The negativelyRegulates relationship; it goes from terms to terms.
    */
    interface NegativelyRegulates<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends NegativelyRegulates<S, ST, R, RT, T, TT>, RT extends NegativelyRegulatesType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship<S, ST, R, RT, T, TT> {
    }

    interface NegativelyRegulatesType<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends NegativelyRegulates<S, ST, R, RT, T, TT>, RT extends NegativelyRegulatesType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship.Type.ManyToMany<S, ST, R, RT, T, TT> {
    }

    /*
    The positivelyRegulates relationship; it goes from terms to terms.
    */
    interface PositivelyRegulates<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends PositivelyRegulates<S, ST, R, RT, T, TT>, RT extends PositivelyRegulatesType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship<S, ST, R, RT, T, TT> {
    }

    interface PositivelyRegulatesType<
            S extends Term<S, ST>, ST extends TermType<S, ST>,
            R extends PositivelyRegulates<S, ST, R, RT, T, TT>, RT extends PositivelyRegulatesType<S, ST, R, RT, T, TT>,
            T extends Term<T, TT>, TT extends TermType<T, TT>
            >
            extends Relationship.Type.ManyToMany<S, ST, R, RT, T, TT> {
    }


}