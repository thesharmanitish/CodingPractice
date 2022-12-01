package com.interview.hybrid;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
 * 
 * 1235. Maximum Profit in Job Scheduling Hard 4.4K 52 company DoorDash company
 * Airbnb company Google
 * 
 * We have n jobs, where every job is scheduled to be done from startTime[i] to
 * endTime[i], obtaining a profit of profit[i].
 * 
 * You're given the startTime, endTime and profit arrays, return the maximum
 * profit you can take such that there are no two jobs in the subset with
 * overlapping time range.
 * 
 * If you choose a job that ends at time X you will be able to start another job
 * that starts at time X.
 * 
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120 Explanation: The subset chosen is the first and fourth job. Time
 * range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * 
 * 
 * @author nisharma
 *
 */
public class MaxProfitJobScheduling {
	private int findMaxProfit(int[][] jobs) {
		int n = jobs.length, maxProfit = 0;
		// min heap having {endTime, profit}
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int i = 0; i < n; i++) {
			while (!pq.isEmpty() && pq.peek()[0] <= jobs[i][0]) {
				maxProfit = Math.max(maxProfit, pq.poll()[1]);
			}
			pq.offer(new Integer[] { jobs[i][1], jobs[i][2] + maxProfit });

		}
		while (!pq.isEmpty()) {
			maxProfit = Math.max(maxProfit, pq.poll()[1]);
		}
		return maxProfit;
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][3];

		// storing job's details into one list
		// this will help in sorting the jobs while maintaining the other parameters
		int length = profit.length;
		for (int i = 0; i < length; i++) {
			jobs[i][0] = startTime[i];
			jobs[i][1] = endTime[i];
			jobs[i][2] = profit[i];
		}

		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
		return findMaxProfit(jobs);
	}
}