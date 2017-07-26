package com.puzhen.greedy.assignment;

import java.util.Set;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import com.puzhen.greedy.*;
import com.puzhen.greedy.utility.MyGraphs;

public class Question3 {

	public static void main(String[] args) {
		System.out.print("Sum of the MST is: ");
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("edges.txt");
		MSTAlgo mst = new Prims();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		System.out.println((new SumGetter()).computeMSTSum(edges, graph));
	}
}
