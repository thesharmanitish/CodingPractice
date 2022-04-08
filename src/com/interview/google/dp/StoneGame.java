package com.interview.google.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/stone-game/submissions/
 * 
 * @author nisharma
 *
 */
public class StoneGame {

	/**
	 * dp[i] is the biggest number of stones you can get more than opponent, picking
	 * piles in range piles[i] ~ piles[i + d - 1]. Key insight required to
	 * understand this approach is that d is increasing by 1 every time the outer
	 * loop finishes and before the return, it is equal to n (that is why when we
	 * return,dp[0] is equivalent of dp[0][n - 1] from 2D version. Loop:
	 * 
	 * for d = 1 - after inner loop finishes dp[i] contains the best score for for
	 * range p[i, i + 1], we filled dp[i:n - 1] for d = 2 - after inner loop
	 * finishes dp[i] contains the best score for for rangep[i, i + 2], we filled
	 * dp[i:n - 2] for d = 3 - after inner loop finishes dp[i] contains the best
	 * score for for range p[i, i + 3], we filled dp[i:n - 3] ... for d - after
	 * inner loop finishes dp[i] contains the best score for for range p[i, i + d],
	 * we filled dp[i:n - d] (we fill one less element of dp every time we increase
	 * the window d by 1)
	 * 
	 * Where does dp[i] = max(p[i] - dp[i + 1], p[i + d] - dp[i]) come from? Let's
	 * split the cases:
	 * 
	 * p[i] - dp[i + 1] p[i] is the stone at the left side of the window, if we pick
	 * it up, the opponent will take the best from dp[i + 1] which represents best
	 * score for piles p[i + 1] ~ p[i + d ] why? Because in previous run of the
	 * outer loop we calculated this for d - 1 and it is currently stored in dp[i +
	 * 1]. p[i + d] - dp[i] p[i + d] is the stone at the right side of the window,
	 * if we pick it up, the opponent will take the best from dp[i] which represents
	 * best score for piles p[i] ~ p[i + d - 1] why? Because in previous run of the
	 * outer loop we calculated this for d - 1 and it is currently stored in dp[i].
	 * 
	 * @param piles
	 * @return
	 */
	public boolean stoneGameMoreOpt(int[] piles) {
		// 3,7,2,3
		int[] dp = Arrays.copyOf(piles, piles.length);
		int k = 0;
		for (int windowSize = 2; windowSize <= piles.length; windowSize++) {
			for (int start = 0; start <= piles.length - windowSize; start++) {
				int end = start + windowSize - 1;
				dp[start] = Math.max(piles[start] - dp[start + 1], piles[end] - dp[start]);
				// 3,7,2,3,
	//dp :		// 4,5,1
				// -2 6
				// 5
			}
		}
		return dp[0] > 0 ? true : false;

	}

	public boolean stoneGameOptimized(int[] piles) {
		int[][] dp = new int[piles.length + 1][piles.length + 1];
		for (int i = 1; i <= piles.length; i++) {
			dp[i][i] = piles[i - 1];
		}
		for (int i = 1; i <= piles.length; i++) {
			for (int j = i + 1; j <= piles.length; j++) {
				dp[i][j] = Math.max(piles[i - 1] - dp[i + 1][j], piles[j - 1] - dp[i][j - 1]);

			}
		}

		return dp[1][piles.length] > 0 ? true : false;

	}

	public boolean stoneGame(int[] piles) {
		int[][][] dp = new int[piles.length + 1][piles.length + 1][2];

		for (int i = 1; i <= piles.length; i++) {
			dp[i][i][0] = piles[i - 1];
		}
		for (int i = 1; i <= piles.length; i++) {
			for (int j = i + 1; j <= piles.length; j++) {
				dp[i][j][0] = Math.max(dp[i][j - 1][1] + piles[j - 1], dp[i + 1][j][1] + piles[i - 1]);
				dp[i][j][1] = Math.min(dp[i][j - 1][1] + piles[j - 1], dp[i + 1][j][1] + piles[i - 1]);

			}
		}

		return dp[1][piles.length - 1][0] > dp[0][piles.length][1] ? true : false;

	}

	public static void main(String[] args) {
		int[] arr = { 3, 7, 2, 3 };
		new StoneGame().stoneGameMoreOpt(arr);
	}
}
