package com.bio4j.titan.model.go;

import com.thinkaurelius.titan.core.*;

public final class TitanGoGraphImpl extends TitanGoGraph {

    TitanGoGraphImpl(TitanGraph graph) {
        super(graph);
        initTypes();
    }

    private void initTypes() {


        // Term keyss
        termTkey = titanKeyForNodeType(termT.id);
        termIdKey = termTkey;
        termNameKey = titanKeyForNodeProperty(termT.name).make();
        // if you want to index the name just add the corresponding titan stuff before make, like
        // termNameKey = titanKeyForNodeProperty(termT.name).indexed(com.tinkerpop.blueprints.Edge.class).make();

        // partOf stuff
        partOfLabel = titanLabelForRelationshipType(partOfT).make();
        // hasPartOF stuff
        hasPartOfLabel = titanLabelForRelationshipType(hasPartOfT).make();
        // isA stuff
        isALabel = titanLabelForRelationshipType(isAT).make();
        // regulates stuff
        regulatesLabel = titanLabelForRelationshipType(regulatesT).make();
        // positivelyRegulates stuff
        positivelyRegulatesLabel = titanLabelForRelationshipType(positivelyRegulatesT).make();
        // negativelyRegulates stuff
        negativelyRegulatesLabel = titanLabelForRelationshipType(negativelyRegulatesT).make();

    }
}