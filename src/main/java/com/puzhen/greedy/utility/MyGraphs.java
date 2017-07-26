package com.puzhen.greedy.utility;

import org.apache.log4j.Logger;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.*;

public class MyGraphs {

	final static Logger logger = Logger.getLogger(MyGraphs.class);
	
	public static WeightedGraph<String, DefaultWeightedEdge>
		getWeightedGraphFromFile(String filepath) {
		WeightedGraph<String, DefaultWeightedEdge> graph
			 = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		try {
			BufferedReader rd = new BufferedReader(new FileReader(new File(filepath)));
			boolean firstLine = true;
			String line = "";
			while ((line = rd.readLine()) != null) {
				String[] elements = line.split(" ");
				if (firstLine) {
					int num_nodes = Integer.valueOf(elements[0]);
					for (int i = 1; i <= num_nodes; i++)
						graph.addVertex(String.valueOf(i));
					firstLine = false;
				} else {
					DefaultWeightedEdge e = graph.addEdge(elements[0], elements[1]);
					graph.setEdgeWeight(e, Double.valueOf(elements[2]));
				}
			}
			rd.close();
		} catch (IOException e) {
			logger.error("IOException when reading from file");
			e.printStackTrace();
			return graph;
		}
		
		return graph;
	}
}
