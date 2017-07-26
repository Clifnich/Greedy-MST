package com.puzhen.greedy;

import java.util.Set;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public interface MSTAlgo {

	/**
	 * This method computes the MST for a given
	 * undirected weighted graph
	 */
	public Set<DefaultWeightedEdge> computeMST(WeightedGraph<String, DefaultWeightedEdge> graph);
}
