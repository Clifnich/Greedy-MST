package com.puzhen.greedy.comparator;

import java.util.Comparator;

import com.puzhen.greedy.Job;

public class DiffComparator implements Comparator<Job> {

	public int compare(Job j1, Job j2) {
		int diff1 = j1.getWeight() - j1.getLength();
		int diff2 = j2.getWeight() - j2.getLength();
		if (diff1 > diff2)
			return -1;
		else if (diff1 == diff2)
			return j2.getWeight() - j1.getWeight();
		else 
			return 1;
	}

}
