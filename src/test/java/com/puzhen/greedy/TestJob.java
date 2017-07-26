package com.puzhen.greedy;

import java.util.Arrays;
import java.util.List;

import com.puzhen.greedy.comparator.DiffComparator;

import junit.framework.TestCase;

public class TestJob extends TestCase {

	public TestJob(String name) {
		super(name);
	}
	
	public void test0() {
		Job j = new Job();
		assertTrue( j != null);
	}
	
	public void testConstructor() {
		Job j = new Job(1, 2);
		assertEquals(1, j.getWeight());
		assertEquals(2, j.getLength());
	}
	
	/**
	 * J1=(1, 1)
	 * J2=(1, 2)
	 * J3=(1, 3)
	 */
	public void testComputeCj() {
		List<Job> list = Arrays.asList(new Job(1,1), new Job(1,2), new Job(1,3));
		Job.computeCj(list, new DiffComparator());
		assertEquals(1, list.get(0).getCompletionTime());
		assertEquals(3, list.get(1).getCompletionTime());
		assertEquals(6, list.get(2).getCompletionTime());
	}
	
	/**
	 * J1=(1, 2)
	 * J2=(1, 3)
	 * J3=(1, 4)
	 */
	public void testComputeCj1() {
		List<Job> list = Arrays.asList(new Job(1,2), new Job(1,3), new Job(1,4));
		Job.computeCj(list, new DiffComparator());
		assertEquals(2, list.get(0).getCompletionTime());
		assertEquals(5, list.get(1).getCompletionTime());
		assertEquals(9, list.get(2).getCompletionTime());
	}
}
