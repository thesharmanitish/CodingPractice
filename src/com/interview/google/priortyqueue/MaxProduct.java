package com.interview.google.priortyqueue;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/contest/weekly-contest-288
 * 
 * @author nisharma
 *
 */
public class MaxProduct {
	public static int maximumProduct(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return o1 - o2;
		});

		for (int i : nums)
			pq.offer(i);

		for (int i = 0; i < k; i++) {
			int t = pq.poll();
			t += 1;
			pq.offer(t);
		}
		int M = 1000000007;
		long res = 1;
		while (!pq.isEmpty()) {
			res = (res*pq.poll())%M;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		int[] al = {24,5,64,53,26,38};
		System.out.println(maximumProduct(al, 54));
	}
}
