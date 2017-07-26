package com.puzhen.greedy.assignment;

import com.puzhen.greedy.SumGetter;
import com.puzhen.greedy.comparator.RatioComparator;
import com.puzhen.greedy.utility.Jobs;

public class Question2 {

	public static void main(String[] args) {
		System.out.print("Weighted sum using ratio method is: ");
		System.out.println((new SumGetter()).computeSum(Jobs.getListFromFile("jobs.txt"), new RatioComparator()));
	}
}
