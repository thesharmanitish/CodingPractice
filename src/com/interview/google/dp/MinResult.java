package com.interview.google.dp;

/**
 * https://leetcode.com/contest/weekly-contest-288
 * 
 * @author nisharma
 *
 */
public class MinResult {
	public static  String minimizeResult(String expression) {

		int start = 0, ind = expression.indexOf('+'), end = ind + 1, n = expression.length(),
				l1 = 0, l2 = 0;
		long min = Long.MAX_VALUE;
		long[][] dp = new long[n + 1][n + 1];
		for (int i = 0; i < ind; i++) {
			for (int j = end; j < n; j++) {
				int left = -1, right = -1, mid = 0;
				
				for (int k = 0; k < i; k++) {
					if(left !=-1)
						left += Character.getNumericValue(expression.charAt(k));
					else 
						left = Character.getNumericValue(expression.charAt(k));
					left*=10;
				}
				if(left !=-1) 
					left/=10;
				else left =1;
				for (int k = j+1; k < n; k++) {
					if(right!=-1)
						right += Character.getNumericValue(expression.charAt(k));
					else 
						right = Character.getNumericValue(expression.charAt(k));
					right*=10;
				}
				if(right !=-1)
					right/=10;
				else
					right =1;
				for (int k = i; k < ind; k++) {
					mid += Character.getNumericValue(expression.charAt(k));
					mid *=10;
				}
				mid/=10;
				int mid2= Character.getNumericValue(expression.charAt(end))*10;
				for (int k = end+1; k <= j; k++) {
					mid2 += Character.getNumericValue(expression.charAt(k));
					mid2 = mid2*10;
				}
				mid2/=10;
				dp[i][j] = left * right * (mid+mid2);

				if (min > dp[i][j]) {
					l1 = i;
					l2 = j;
					min = dp[i][j];
				}

			}
		}
		return expression.substring(0, l1) + "(" + expression.substring(l1, l2+1) + ")"
				+ expression.substring(l2+1 );
	}
	public static void main(String[] args) {
		System.out.println(minimizeResult("999+999"));
	}
}
