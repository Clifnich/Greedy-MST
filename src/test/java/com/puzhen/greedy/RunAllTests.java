package com.puzhen.greedy;

import com.puzhen.greedy.utility.TestJobs;
import com.puzhen.greedy.utility.TestMyGraphs;

import junit.framework.Test;
import junit.framework.TestSuite;

/*
 * This class runs all tests.
 */
public class RunAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(RunAllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestJob.class);
		suite.addTestSuite(TestJobs.class);
		suite.addTestSuite(TestSorting.class);
		suite.addTestSuite(TestSumGetter.class);
		suite.addTestSuite(TestMyGraphs.class);
		suite.addTestSuite(TestNode.class);
		/* Add more tests here... */
		
		//$JUnit-END$
		return suite;
	}

}
