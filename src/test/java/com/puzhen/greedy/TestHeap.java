package com.puzhen.greedy;

import java.io.File;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import com.puzhen.greedy.utility.MyGraphs;

import junit.framework.TestCase;

public class TestHeap extends TestCase{

	public TestHeap(String name) {
		super(name);
	}
	
	public void test0() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph");
		Heap heap = new Heap();
		heap.add("1");
		DefaultWeightedEdge e = graph.getEdge("1", "2");
		Pair<DefaultWeightedEdge, Double> pair = new ImmutablePair<DefaultWeightedEdge, Double>(e, graph.getEdgeWeight(e));
		heap.setKey("1", pair);
		Pair<DefaultWeightedEdge, Double> pair2 = heap.getKey("1");
		assertEquals(1, pair2.getRight(), 1e-8);
	}
}
