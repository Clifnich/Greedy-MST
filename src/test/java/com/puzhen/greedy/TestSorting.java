package com.puzhen.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.puzhen.greedy.comparator.DiffComparator;
import com.puzhen.greedy.comparator.NodeComparator;
import com.puzhen.greedy.comparator.RatioComparator;

import junit.framework.TestCase;

public class TestSorting extends TestCase {

	public TestSorting(String name) {
		super(name);
	}
	
	/**
	 * JOB=(W,L)
	 * J1=(2,2)
	 * J2=(2,1)
	 * Expected order should be: J2, J1
	 */
	public void test0() {
		Comparator<Job> diffComparator = new DiffComparator();
		List<Job> list = Arrays.asList(new Job(2,2), new Job(2,1));
		Collections.sort(list, diffComparator);
		assertEquals(1, list.get(0).getLength());
		assertEquals(2, list.get(1).getLength());
	}
	
	/**
	 * J1=(2,1)
	 * J2=(2,2)
	 * Expected order should be: J1, J2
	 */
	public void test1() {
		Comparator<Job> diffComparator = new DiffComparator();
		List<Job> list = Arrays.asList(new Job(2,1), new Job(2,2));
		Collections.sort(list, diffComparator);
		assertEquals(1, list.get(0).getLength());
		assertEquals(2, list.get(1).getLength());
	}
	
	/**
	 *  if two jobs have equal difference (weight - length), 
	 *  you should schedule the job with higher weight first
	 *  J1=(2,1)
	 *  J2=(3,2)
	 *  Expected order should be: J2, J1
	 */
	public void testEqualDiff() {
		Comparator<Job> diffComparator = new DiffComparator();
		List<Job> list = Arrays.asList(new Job(2,1), new Job(3,2));
		Collections.sort(list, diffComparator);
		assertEquals(2, list.get(0).getLength());
		assertEquals(1, list.get(1).getLength());
	}
	
	/**
	 * Test ratio based sorting
	 * JOB=(W,L)
	 * J1=(2,2)
	 * J2=(2,1)
	 * Expected order should be: J2, J1
	 */
	public void testRatio0() {
		Comparator<Job> diffComparator = new RatioComparator();
		List<Job> list = Arrays.asList(new Job(2,2), new Job(2,1));
		Collections.sort(list, diffComparator);
		assertEquals(1, list.get(0).getLength());
		assertEquals(2, list.get(1).getLength());
	}
	
	/**
	 * Test ratio based sorting
	 * JOB=(W,L)
	 * J1=(4,1)
	 * J2=(2,1)
	 * Expected order should be: J1, J2
	 */
	public void testRatio1() {
		Comparator<Job> diffComparator = new RatioComparator();
		List<Job> list = Arrays.asList(new Job(4,1), new Job(2,1));
		Collections.sort(list, diffComparator);
		assertEquals(4, list.get(0).getWeight());
		assertEquals(2, list.get(1).getWeight());
	}
	
	/**
	 * Test NodeComparator
	 */
	public void testNodeComparator() {
		Comparator<Node> nodeComparator = new NodeComparator();
		Queue<Node> heap = new PriorityQueue<Node>(nodeComparator);
		Node n1 = new Node("1"); n1.setEdgeLength(100);
		Node n2 = new Node("2"); n2.setEdgeLength(200);
		heap.add(n1); heap.add(n2);
		assertEquals(100, heap.peek().getEdgeLength(), 1e-8);
	}
	
	public void testNodeComparator1() {
		Comparator<Node> nodeComparator = new NodeComparator();
		Queue<Node> heap = new PriorityQueue<Node>(nodeComparator);
		Node n1 = new Node("1"); n1.setEdgeLength(100);
		Node n2 = new Node("2"); n2.setEdgeLength(200);
		heap.add(n2); heap.add(n1);
		assertEquals(100, heap.peek().getEdgeLength(), 1e-8);
	}
}

