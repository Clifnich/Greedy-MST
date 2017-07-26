package com.puzhen.greedy.utility;

import java.io.File;
import java.util.List;

import com.puzhen.greedy.Job;

import junit.framework.TestCase;

public class TestJobs extends TestCase{

	public TestJobs(String name) {
		super(name);
	}
	
	/**
	 * J1=(1, 2)
	 * J2=(1, 3)
	 * J3=(1, 4)
	 */
	public void test0() {
		List<Job> list = Jobs.getListFromFile("fortesting" + File.separator + "tiny");
		assertEquals(3, list.size());
		assertEquals(2, list.get(0).getLength());
		assertEquals(3, list.get(1).getLength());
		assertEquals(4, list.get(2).getLength());
	}
	
	/**
	 * J1=(1, 1)
	 * J2=(1, 3)
	 * J3=(1, 4)
	 */
	public void test1() {
		List<Job> list = Jobs.getListFromFile("fortesting" + File.separator + "tiny1");
		assertEquals(3, list.size());
		assertEquals(1, list.get(0).getLength());
		assertEquals(3, list.get(1).getLength());
		assertEquals(4, list.get(2).getLength());
	}
}
