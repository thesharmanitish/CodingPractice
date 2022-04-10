package com.interview.google.dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * @author nisharma
 *
 */
public class BestStockTimeCoolPeriod {
	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][prices.length];
		int n = prices.length;
		for (int i = 0; i < n; i++)
			dp[n][i] = 
		for (int i = 0; i < n; i++) {
			for (int j = n - 2; j > i; j--) {
				dp[i][j] = Math.max(prices[j] - prices[i] + dp[j + 2][n - 1], dp[i][j]);

			}

		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] arr = { 1,2,3,0,2};
		new BestStockTimeCoolPeriod().maxProfit(arr);
	}
}
