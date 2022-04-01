package com.interview.string;

/**
 * https://leetcode.com/problems/minimum-window-substring/submissions/
 * 
 * https://thesharmanitish.github.io/til/2022-04-01_minimumwindowsubstring
 * 
 * 
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * @author nisharma
 *
 */
public class MinimumSubstring {
	public static String minWindow(String s, String t) {

		int[] map = new int[67];
		for (char c : t.toCharArray())
			map[c - 'A'] += 1;
		int start = 0, end = 0, counter = t.length(), minLength = Integer.MAX_VALUE, mstart = 0;
		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1 - 'A'] > 0) {
				counter--;
			}
			map[c1 - 'A'] -= 1;
			end++;
			while (counter == 0) {
				if (minLength > end - start) {
					minLength = end - start;
					mstart = start;
				}
				final char c2 = s.charAt(start);
				map[c2 - 'A']++;
				if (map[c2 - 'A'] > 0)
					counter++;
				start++;
			}
		}
		return minLength == Integer.MAX_VALUE ? "" : s.substring(mstart, mstart + minLength);
	}

	/**
	 * Max Substring with atmost k Distinct characters
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] map = new int[256];
		int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

		while (end < s.length()) {
			final char c = s.charAt(end);
			if (map[c] == 0)
				counter++;
			end++;
			map[c] += 1;

			while (counter > k) {

				final char c2 = s.charAt(start);
				if (map[c2]-- == 1)
					counter--;

				start++;

			}
			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}

	/**
	 * LongestSubstring - without repeating characters
	 * 
	 * @param s
	 * @return
	 */
	public static  int lengthOfLongestSubstring2(String s) {
		int[] map = new int[128];
		int start = 0, end = 0, maxLen = 0, counter = 0;

		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] > 0)
				counter++;
			map[c1]++;
			end++;

			while (counter > 0) {
				final char c2 = s.charAt(start);
				if (map[c2] > 1)
					counter--;
				map[c2]--;
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}

	public static void main(String[] args) {
//		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//		System.out.println(lengthOfLongestSubstringKDistinct("ADOBECODEBAANCBE", 4));
		System.out.println(lengthOfLongestSubstring2("ADOBECODEBAANCBE"));
	}
}
