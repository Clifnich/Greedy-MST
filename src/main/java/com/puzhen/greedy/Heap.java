package com.puzhen.greedy;

import java.util.*;

import org.apache.commons.lang3.tuple.Pair;
import org.jgrapht.graph.DefaultWeightedEdge;

public class Heap extends PriorityQueue<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Heap() {
		super();
		setUp();
	}
	
	public Heap(Comparator<String> comparator) {
		super(comparator);
		setUp();
	}
	
	private void setUp() {
		key = new HashMap<String, Pair<DefaultWeightedEdge, Double>>();
	}
	
	public void setKey(String vertex, Pair<DefaultWeightedEdge, Double> pair) {
		key.put(vertex, pair);
	}
	
	public Pair<DefaultWeightedEdge, Double> getKey(String vertex) {
		return key.get(vertex);
	}
	
	private Map<String, Pair<DefaultWeightedEdge, Double>> key;

}
