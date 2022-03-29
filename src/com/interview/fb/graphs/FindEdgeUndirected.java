package com.interview.fb.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindEdgeUndirected {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		boolean[] visited = new boolean[n];
		HashSet<Integer>[] graph = new HashSet[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new HashSet<Integer>();
		}
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		if (graph[source].contains(destination)) { // direct connection exists
			return true;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(source);
		visited[source] = true;

		while (!queue.isEmpty()) {
			int N = queue.size();
			for (int i = 0; i < N; i++) {
				int current = queue.poll();
				if (current == destination) {
					return true;
				}
				for (Integer h : graph[current]) {
					if(!visited[h]) {
						queue.offer(h);
						visited[h] = true;
					}
				}
			}
		}
		return false;
	}
}
