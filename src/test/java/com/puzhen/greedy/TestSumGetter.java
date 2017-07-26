package com.puzhen.greedy;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import com.puzhen.greedy.comparator.DiffComparator;
import com.puzhen.greedy.comparator.RatioComparator;
import com.puzhen.greedy.utility.Jobs;
import com.puzhen.greedy.utility.MyGraphs;

import junit.framework.TestCase;

public class TestSumGetter extends TestCase {

	SumGetter sum = new SumGetter();
	
	public TestSumGetter(String name) {
		super(name);
	}
	
	/**
	 * J1=(1, 2)
	 * J2=(1, 3)
	 * J3=(1, 4)
	 */
	public void test0() {
		List<Job> list = Arrays.asList(new Job(1,2), new Job(1,3), new Job(1,4));
		assertEquals(16, (new SumGetter()).computeSum(list, new DiffComparator()));
	}
	
	public void test1() {
		assertEquals(32780, (new SumGetter()).computeSum(
				Jobs.getListFromFile("fortesting" + File.separator + "diff32780"), new DiffComparator()));
	}
	
	public void test2() {
		assertEquals(32104, (new SumGetter()).computeSum(
				Jobs.getListFromFile("fortesting" + File.separator + "diff32780"), new RatioComparator()));
	}
	
	/**
	 * Test MST Sum
	 */
	public void testMST() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph");
		MSTAlgo mst = new Prims();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		assertEquals(3, sum.computeMSTSum(edges, graph));
	}
	
	public void testMST1() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "tinygraph1");
		MSTAlgo mst = new Prims();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		assertEquals(6, sum.computeMSTSum(edges, graph));
	}
	
	public void testMST2() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "MST7");
		MSTAlgo mst = new Prims();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		assertEquals(7, sum.computeMSTSum(edges, graph));
	}
	
	public void testMST3() {
		WeightedGraph<String, DefaultWeightedEdge> graph = 
				MyGraphs.getWeightedGraphFromFile("fortesting" + File.separator + "MST14");
		MSTAlgo mst = new Prims();
		Set<DefaultWeightedEdge> edges = mst.computeMST(graph);
		assertEquals(14, sum.computeMSTSum(edges, graph));
	}
}
