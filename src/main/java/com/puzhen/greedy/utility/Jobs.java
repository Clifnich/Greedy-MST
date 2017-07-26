package com.puzhen.greedy.utility;

import java.util.*;

import org.apache.log4j.Logger;

import com.puzhen.greedy.Job;

import java.io.*;

public class Jobs {

	final static Logger logger = Logger.getLogger(Jobs.class);
	
	public static List<Job> getListFromFile(String filepath) {
		List<Job> list = null;
		try {
			BufferedReader rd = new BufferedReader(new FileReader(new File(filepath)));
			boolean firstLine = true;
			String line = "";
			while ((line = rd.readLine()) != null) {
				if (firstLine) {
					list = new ArrayList<Job>(Integer.valueOf(line));
					firstLine = false;
				} else {
					String[] elements = line.split(" ");
					list.add(new Job(Integer.valueOf(elements[0]), Integer.valueOf(elements[1])));
				}
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("IOException from Jobs, returning an empty list.");
			return new ArrayList<Job>(0);
		}
		
		return list;
	}
}
