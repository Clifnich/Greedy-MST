package com.puzhen.greedy;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Node {

	private String vertex;

	private DefaultWeightedEdge key;
	
	private double edgeLength;
	
	public String getVertex() {
		return vertex;
	}

	public void setVertex(String vertex) {
		this.vertex = vertex;
	}

	public DefaultWeightedEdge getKey() {
		return key;
	}

	public void setKey(DefaultWeightedEdge key) {
		this.key = key;
	}

	public double getEdgeLength() {
		return edgeLength;
	}

	public void setEdgeLength(double edgeLength) {
		this.edgeLength = edgeLength;
	}
	
	public Node() {}
	
	public Node(String vertex) {
		this.vertex = vertex;
	}
	
	@Override
	public boolean equals(Object node) {
		if (vertex == null) return false;
		return vertex.equals(((Node) node).getVertex());
	}
}
