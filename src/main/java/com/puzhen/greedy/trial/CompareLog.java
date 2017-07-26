package com.puzhen.greedy.trial;

import java.io.*;

public class CompareLog {

	public static void main(String[] args) throws IOException {
		BufferedReader rdHeap = new BufferedReader(new FileReader(new File("logs/log-heaps.log")));
		BufferedReader rdNonHeap = new BufferedReader(new FileReader(new File("logs/log-nonheaps.log")));
		
		String line1 = "", line2 = "";
		int i = 1;
		while ((line1 = rdHeap.readLine()) != null) {
			line1 = line1.substring(40);
			line2 = rdNonHeap.readLine();
			line2 = line2.substring(40);
			if (!line1.equals(line2)) {
				System.err.println("Error lies in line " + i);
				System.out.println(line1);
				System.out.println(line2);
				System.exit(-1);
			}
			i++;
		}
	}
}
