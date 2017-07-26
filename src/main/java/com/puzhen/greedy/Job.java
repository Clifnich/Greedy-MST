package com.puzhen.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Job {

	private int weight;

	private int length;
	
	private int completionTime;

	public Job() {}
	
	public Job(int weight, int length) {
		this.weight = weight;
		this.length = length;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(int completionTime) {
		this.completionTime = completionTime;
	}
	
	/**
	 * Compute the completion time for each Job
	 * in the list.
	 */
	public static void computeCj(List<Job> list, Comparator<Job> comparator) {
		Collections.sort(list, comparator);
		for (int i = 0; i < list.size(); i++) {
			Job current = list.get(i);
			if (i == 0)
				current.setCompletionTime(current.getLength());
			else
				current.setCompletionTime(current.getLength() + list.get(i-1).getCompletionTime());
		}
	}
}
