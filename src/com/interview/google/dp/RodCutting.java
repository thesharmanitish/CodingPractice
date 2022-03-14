package com.interview.google.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCutting {
	public static ArrayList<Integer> rodCut(int A, List<Integer> B) {
		int[][] dp = new int[B.size() + 1][A + 1];
		for (int i = 0; i <= B.size(); i++)
			dp[i][0] = 0;
		for (int i = 0; i <= A; i++)
			dp[0][i] = Integer.MAX_VALUE-A;
		for (int i = 1; i <= B.size(); i++) {
			for (int j = 1; j <= A; j++) {
				if (j >= B.get(i - 1) && dp[i][j - B.get(i - 1)]!= Integer.MAX_VALUE)
					dp[i][j] = Math.min(B.get(i - 1) + dp[i][j - B.get(i - 1)], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];

			}
		}
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = 1; i <= A; i++) {
			System.out.println(dp[B.size()][i - 1]);
			if (dp[B.size()][i - 1] < dp[B.size()][i]) {
				ret.add(i);
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		rodCut(6,Arrays.asList(1,2,5));
	}
}
