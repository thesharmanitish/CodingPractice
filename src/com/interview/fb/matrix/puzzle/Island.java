package com.interview.fb.matrix.puzzle;

import java.util.Deque;
import java.util.LinkedList;


/**
 * Facebook Interview Question
 * 1.) given a 2-D matrix of all points find all the points  which have distance from 
 * origin less than k 
 * 
 * 2. find all Island with size > k size is number of points.
 * 
 *  
 * Below programs is to find all the islands
 *  
 * @author nisharma
 *
 */
class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Island {
	public int numIslands(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Deque<Pair> q = new LinkedList<>();
		int[] arr = { -1, 0, 1, 0 }, brr = { 0, -1, 0, 1 };
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0')
					continue;
				if (visited[i][j])
					continue;

				count++;
				q.offer(new Pair(i, j));
				while (!q.isEmpty()) {
					Pair p = q.poll();
					visited[p.x][p.y] = true;
					for (int k = 0; k < arr.length; k++) {
							if (p.x + arr[k] >= 0 && p.x + arr[k] < grid.length && p.y + brr[k] >= 0 && p.y + brr[k] < grid[0].length
									&& grid[p.x + arr[k]][p.y + brr[k]] == '1' && !visited[p.x + arr[k]][p.y + brr[k]]) {
								q.offer(new Pair(p.x + arr[k], p.y + brr[k]));
								visited[p.x + arr[k]][p.y + brr[k]] = true;
							}
						
					}

				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		char[][] mat = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(new Island().numIslands(mat));
	}

}