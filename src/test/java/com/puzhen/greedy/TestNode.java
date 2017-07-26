package com.puzhen.greedy;

import junit.framework.TestCase;

public class TestNode extends TestCase {

	public TestNode(String name) {
		super(name);
	}
	
	public void test0() {
		Node node = new Node();
		assertTrue( node != null);
	}
	
	public void test1() {
		Node node = new Node("1");
		assertEquals("1", node.getVertex());
	}
	
	public void testEquals() {
		Node node1 = new Node("1");
		Node node2 = new Node("1");
		assertTrue(node1.equals(node2));
	}
}
