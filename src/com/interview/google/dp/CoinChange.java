package com.interview.google.dp;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[][] dp = new int[coins.length + 1][amount + 1];

		for (int i = 1; i <= amount; i++) 
			dp[0][i] = Integer.MAX_VALUE - 1;
		
		dp[0][0] = 0;

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[coins.length][amount] >= Integer.MAX_VALUE-1?-1:dp[coins.length][amount];
	}
	public static void main(String[] args) {
		int[] arr = {1,2,5};
		System.out.println(new CoinChange().coinChange(arr, 11));
	}
}
