package com.interview.google.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/submissions/
 * 
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * @author nisharma
 *
 */
public class PartitionEqualSubset {
	boolean[][] dp;

	public static boolean canPartitionOptimized(int[] nums) {

		int sum = Arrays.stream(nums).sum();
		if ((sum & 1) == 1) {
			return false;
		}
		sum /= 2;

		int n = nums.length;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int num : nums) {
			if (dp[sum])
				return true;
			if (num <= sum && dp[sum - num])
				return true;
			for (int i = sum; i >= num; i--) {
				dp[i] = dp[i] || dp[i - num];
			}
		}

		return dp[sum];
	}

	static boolean[][] dp1;

	public static boolean canPartition(int[] nums) {

		int sum = Arrays.stream(nums).sum();
		if ((sum & 1) == 1) {
			return false;
		}
		sum /= 2;

		int n = nums.length;
		dp1 = new boolean[nums.length][sum + 1];
		return subsetSum(nums, nums.length, sum);

	}

	static boolean subsetSum(int[] nums, int n, int sum) {

		// Arrays.fill(dp[0],false);
		// dp[0][0] = true;
		for (int i = 0; i <= n; i++)
			dp1[i][0] = true;
		for (int i = 1; i <= sum; i++)
			dp1[0][i] = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp1[i][j] = dp1[i - 1][j];
				if (nums[i - 1] <= j) {
					dp1[i][j] = dp1[i - 1][j - nums[i - 1]] || dp1[i - 1][j];
				}
			}
		}
		return dp1[n][sum];

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5 };
		System.out.println(canPartition(arr));
	}
}
