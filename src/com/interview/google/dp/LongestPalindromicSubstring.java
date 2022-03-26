package com.interview.google.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 * 
 * dp(i, j) represents whether s(i ... j) can form a palindromic substring,
 * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic
 * substring. When we found a palindrome, check if it's the longest one. Time
 * complexity O(n^2).
 * 
 * Alternate Solution
 * https://www.youtube.com/watch?v=y2BD4MJqV20
 * 
 * @author nisharma
 *
 */

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		String res = "";
		StringBuilder sb = new StringBuilder(s.length());
		if (s.length() == 0)
			return s;

		for (int i = s.length() - 1; i >= 0; i--)
			sb.append(s.charAt(i));
		if (s.equals(sb.toString()))
			return s;
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) { // start
			for (int j = i; j < n; j++) { //end
				if (s.charAt(i) == s.charAt(j) && ((j < i + 3) || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					if (res.length() < j - i + 1 || res == null)
						res = s.substring(i, j + 1);
				}

			}

		}

		return res;
	}

	public boolean isPalindrome(String s, int i, int j) {
		while (i <= j && i < s.length() && j < s.length())
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		return true;
	}
}
