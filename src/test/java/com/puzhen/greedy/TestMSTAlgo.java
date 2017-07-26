package com.puzhen.greedy;

import java.io.File;
import java.util.Set;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import com.puzhen.greedy.utility.MyGraphs;

import junit.framework.TestCase;

public class TestMSTAlgo extends TestCase {

	public TestMSTAlgo(String name) {
		super(name);
	}
	
	public void test0() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph");
		MSTAlgo mst = new Prims();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		assertEquals(2, edges.size());
	}
	
	public void test1() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph1");
		MSTAlgo mst = new Prims();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		assertEquals(3, edges.size());
	}
	
	/**
	 * Test Heaps algorithm
	 */
	public void test2() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph1");
		MSTAlgo mst = new Heaps();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		assertEquals(3, edges.size());
	}
}
