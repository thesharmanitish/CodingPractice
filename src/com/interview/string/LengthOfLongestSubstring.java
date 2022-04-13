package com.interview.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the
 * length of 3.
 * 
 * @author nisharma
 *
 */

/**
 * Optimized version using array of boolean
 * 
 * @author nisharma
 *
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		boolean[] flag = new boolean[256];
		int n = s.length(), start = 0, max = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < n; i++) {
			if (flag[arr[i]]) {
				max = Math.max(max, i - start);
				for (int j = start; j < i; j++) {
					if (arr[j] == arr[i]) {
						start = j + 1;
						break;
					}
					flag[arr[j]] = false;
				}

			} else {
				flag[arr[i]] = true;
			}

		}

		max = Math.max(max, n - start);
		return max;
	}

	/**
	 * Using stack to get max window size
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringWithSet(String s) {
		Deque<Character> set = new LinkedList<>();
		int max = 0;
		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				max = Math.max(max, set.size());
				while (set.pop() != c)
					;

			}
			set.add(c);

		}
		return Math.max(max, set.size());
	}
}
