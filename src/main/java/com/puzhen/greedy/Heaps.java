package com.puzhen.greedy;

import java.util.*;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import com.puzhen.greedy.comparator.NodeComparator;

public class Heaps implements MSTAlgo {

	public Set<DefaultWeightedEdge> computeMST(WeightedGraph<String, DefaultWeightedEdge> graph) {
		Set<DefaultWeightedEdge> t = new HashSet<DefaultWeightedEdge>();
		String initV = "1";
		Set<String> vertexSet = graph.vertexSet();
		Set<String> x = new HashSet<String>(); x.add(initV);
		// init the heap
		Queue<Node> heap = new PriorityQueue<Node>(new NodeComparator());
		for (String v : vertexSet) {
			if (!x.contains(v)) {
				Node node = new Node(v);
				DefaultWeightedEdge e = graph.getEdge(initV, v);
				node.setKey(e);
				node.setEdgeLength(graph.getEdgeWeight(e));
				heap.add(node);
			}
		}
		
		while (x.size() != vertexSet.size()) {
			Node node = heap.peek();
			t.add(node.getKey());
			String v = node.getVertex();
			x.add(v);
			for (String w : graph.vertexSet()) {
				DefaultWeightedEdge e = graph.getEdge(v, w);
				if (e == null) continue;
				if (x.contains(w)) continue;
				Node newNode = new Node(w);
				heap.remove(newNode);
				
			}
		}
		// maintain invariant during while-loop
		return t;
	}

}
