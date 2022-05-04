package com.interview.google.dp;

public class DiceRoll {
	public int numRollsToTarget(int n, int k, int target) {
		int[][] dp = new int[30][1000];

		for (int i = 0; i < k; i++)
			dp[0][i] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = i; j < target; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i][j - 1]) % 1000000007;
			}

		}
		return (int) dp[n - 1][k - 1];
	}
	public static void main(String[] args) {
		System.out.println(new DiceRoll().numRollsToTarget(1, 6, 9));
	}
}
