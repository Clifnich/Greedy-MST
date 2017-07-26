package com.puzhen.greedy.trial;

import java.util.PriorityQueue;
import java.util.Queue;

import com.puzhen.greedy.Node;

public class TryDeleteFromHeap {

	public static void main(String[] args) {
		Queue<Node> heap = new PriorityQueue<Node>();
		Node n1 = new Node("1");
		n1.setEdgeLength(100);
		heap.add(n1);
		
		Node n2 = new Node("1");
		heap.remove(n2);
		System.out.println(heap.size());
	}
}
