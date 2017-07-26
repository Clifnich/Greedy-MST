package com.puzhen.greedy;

import java.util.*;
import java.util.List;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

public class SumGetter {

	public long computeSum(List<Job> list, Comparator<Job> comparator) {
		Job.computeCj(list, comparator);
		long sum = 0;
		for (Job j : list)
			sum += j.getCompletionTime() * j.getWeight();
		return sum;
	}
	
	public long computeMSTSum(Set<DefaultWeightedEdge> edges, 
			WeightedGraph<String, DefaultWeightedEdge> graph) {
		long sum = 0;
		for (DefaultWeightedEdge e : edges) {
			sum += graph.getEdgeWeight(e);
		}
		return sum;
	}
}
