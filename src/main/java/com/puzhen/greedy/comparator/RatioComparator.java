package com.puzhen.greedy.comparator;

import java.util.Comparator;

import com.puzhen.greedy.Job;

public class RatioComparator implements Comparator<Job>{

	public int compare(Job j1, Job j2) {
		double ratio1 = (double)j1.getWeight() / (double)j1.getLength();
		double ratio2 = (double)j2.getWeight() / (double)j2.getLength();
		if (ratio1 - ratio2 > 0)
			return -1;
		else if (ratio1 == ratio2)
			return 0;
		else 
			return 1;
	}

}
