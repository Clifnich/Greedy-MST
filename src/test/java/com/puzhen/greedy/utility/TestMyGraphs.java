package com.puzhen.greedy.utility;

import java.io.File;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import junit.framework.TestCase;

public class TestMyGraphs extends TestCase {

	public TestMyGraphs(String name) {
		super(name);
	}
	
	public void test0() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph");
		assertEquals(3, graph.vertexSet().size());
		assertEquals(1, graph.getEdgeWeight(graph.getEdge("1", "2")), 1e-8);
	}
	
	public void test1() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph1");
		assertEquals(4, graph.vertexSet().size());
		assertEquals(1, graph.getEdgeWeight(graph.getEdge("1", "2")), 1e-8);
		assertEquals(2, graph.getEdgeWeight(graph.getEdge("1", "3")), 1e-8);
		assertEquals(3, graph.getEdgeWeight(graph.getEdge("1", "4")), 1e-8);
	}
}
