package com.puzhen.greedy.comparator;

import java.util.Comparator;

import com.puzhen.greedy.Node;

public class NodeComparator implements Comparator<Node> {

	public int compare(Node n1, Node n2) {
		double length1 = n1.getEdgeLength();
		double length2 = n2.getEdgeLength();
		if (length1 < length2)
			return -1;
		else if (length1 == length2)
			return 0;
		else 
			return 1;
	}

}
