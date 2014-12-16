package com.bio4j.titan.model.uniprot_go.tests;

import com.bio4j.model.uniprot_go.UniProtGoGraph;
import com.bio4j.titan.model.go.TitanGoGraph;
import com.bio4j.titan.model.uniprot.TitanUniProtGraph;
import com.bio4j.titan.model.uniprot_go.TitanUniProtGoGraph;
import com.bio4j.titan.util.DefaultTitanGraph;
import com.ohnosequences.util.Executable;
import com.thinkaurelius.titan.core.*;
import com.thinkaurelius.titan.core.schema.*;
import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import com.bio4j.model.uniprot_go.tests.ImportUniProtGoTest;

import java.util.ArrayList;

/**
 * Created by ppareja on 11/5/2014.
 */
public class ImportUniProtGoTestTitan extends ImportUniProtGoTest<DefaultTitanGraph, TitanVertex, VertexLabelMaker, TitanEdge, EdgeLabelMaker> implements Executable {

	@Override
	protected TitanUniProtGoGraph config(String dbFolder) {
		//----------DB configuration------------------
		Configuration conf = new BaseConfiguration();
		conf.setProperty("storage.directory", dbFolder);
		conf.setProperty("storage.backend", "local");
		conf.setProperty("autotype", "none");
		//-------creating graph handlers---------------------
		TitanGraph graph = TitanFactory.open(conf);
		DefaultTitanGraph defGraph = new DefaultTitanGraph(graph);
		return new TitanUniProtGoGraph(defGraph, new TitanUniProtGraph(defGraph), new TitanGoGraph(defGraph));
	}

	@Override
	public void execute(ArrayList<String> array) {
		String[] args = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			args[i] = array.get(i);
		}
		importUniProtGoTest(args);
	}

}
