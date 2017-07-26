package com.puzhen.greedy;

import java.util.*;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.log4j.Logger;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import com.puzhen.greedy.comparator.NodeComparator;

public class Heaps implements MSTAlgo {

	final static Logger logger = Logger.getLogger(Heaps.class);
	
	public Set<DefaultWeightedEdge> computeMST(WeightedGraph<String, DefaultWeightedEdge> graph) {
		Set<DefaultWeightedEdge> t = new HashSet<DefaultWeightedEdge>();
		String initV = "1";
		Set<String> vertexSet = graph.vertexSet();
		Set<String> x = new HashSet<String>(); x.add(initV);
		// init the heap
		Heap heap = new Heap(new NodeComparator());
		for (String v : vertexSet) {
			if (!x.contains(v)) {
				Node node = new Node(v);
				DefaultWeightedEdge e = graph.getEdge(initV, v);
				double weight = 9999999;
				if (e != null) {
					weight = graph.getEdgeWeight(e);
				}
				node.setKey(e);
				node.setEdgeLength(weight);
				heap.add(node);
				heap.setKey(v, new ImmutablePair<DefaultWeightedEdge, Double>(e, weight));
			}
		}
		
		while (x.size() != vertexSet.size()) {
			Node node = heap.poll();
			t.add(node.getKey());
			logger.info(t);
			String v = node.getVertex();
			x.add(v);
			for (String w : graph.vertexSet()) {
				DefaultWeightedEdge e = graph.getEdge(v, w);
				if (e == null) continue;
				if (x.contains(w)) continue;
				double l_vw = graph.getEdgeWeight(e);
				//double least = Math.min(heap.getKey(w).getRight(), l_vw);
				if (heap.getKey(w).getRight() > l_vw) {
					Node newNode = new Node(w);
					heap.remove(newNode);
					newNode.setKey(e);
					newNode.setEdgeLength(l_vw);
					heap.add(newNode);
				}
			}
		}
		// maintain invariant during while-loop
		return t;
	}

}
