package com.puzhen.greedy.assignment;

import com.puzhen.greedy.SumGetter;
import com.puzhen.greedy.comparator.DiffComparator;
import com.puzhen.greedy.utility.Jobs;

public class Question1 {

	public static void main(String[] args) {
		System.out.print("Weighted sum using difference method is: ");
		System.out.println((new SumGetter()).computeSum(Jobs.getListFromFile("jobs.txt"), new DiffComparator()));
	}
}
