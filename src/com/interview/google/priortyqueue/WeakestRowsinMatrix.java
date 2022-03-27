package com.interview.google.priortyqueue;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/submissions/
 * 
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and
 * 0's (representing civilians). The soldiers are positioned in front of the
 * civilians. That is, all the 1's will appear to the left of all the 0's in
 * each row.
 * 
 * A row i is weaker than a row j if one of the following is true:
 * 
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * 
 * @author nisharma
 *
 */
public class WeakestRowsinMatrix {

	class Pair {
		int count;
		int row;

		public Pair() {
		}

		public Pair(int count, int row) {
			this.count = count;
			this.row = row;
		}

	}

	public int[] kWeakestRows(int[][] mat, int k) {

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1, o2) -> {
			return o1.count == o2.count ? o1.row - o2.row : o1.count - o2.count;
		});

		for (int i = 0; i < mat.length; i++) {
			int count = 0;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1)
					count++;
			}
			pq.offer(new Pair(count, i));
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll().row;
		}
		return res;
	}
}
