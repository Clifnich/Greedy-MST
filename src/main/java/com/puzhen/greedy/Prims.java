package com.puzhen.greedy;

import java.util.*;

import org.apache.log4j.Logger;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Prims implements MSTAlgo{

	final static Logger logger = Logger.getLogger(Prims.class);
	
	public Set<DefaultWeightedEdge> computeMST(WeightedGraph<String, DefaultWeightedEdge> graph) {
		Set<DefaultWeightedEdge> t = new HashSet<DefaultWeightedEdge>();
		Set<String> x = new HashSet<String>(); x.add("1");
		Set<String> vertexSet = graph.vertexSet();
		int verticesNum = vertexSet.size();
		while (x.size() != verticesNum) {
			double cheapest = 9999999;
			DefaultWeightedEdge cheapestEdge = null;
			String targetV = null;
			for (String u : x) {
				for (String v : vertexSet) {
					if (!x.contains(v)) {
						// u in x, v not in x
						DefaultWeightedEdge e = graph.getEdge(u, v);
						if (e == null) continue;
						double weight = graph.getEdgeWeight(e);
						if (weight < cheapest) {
							cheapest = weight;
							cheapestEdge = e;
							targetV = v;
						}
					}
				}
			}
			t.add(cheapestEdge);
			x.add(targetV);
			logger.info(t);
		}
		return t;
	}

}
