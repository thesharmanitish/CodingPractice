package com.interview.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-duplicate-substring/
 * 
 * Given a string s, consider all duplicated substrings: (contiguous) substrings
 * of s that occur 2 or more times. The occurrences may overlap.
 * 
 * Return any duplicated substring that has the longest possible length. If s
 * does not have a duplicated substring, the answer is "".
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "banana" Output: "ana"
 * 
 * @author nisharma
 *
 */

public class LongestDuplicateSubstring {
	public static void main(String[] args) {
		System.out.println(new LongestDuplicateSubstring().longestDupSubstring("banana"));
	}

	public String longestDupSubstring(String s) {
		if (s == null || s.length() == 0)
			return s;
         
		int l = 0, r = s.length()-1, i = 0, j = 0, mid=0;
        

		while (l < r) {
			mid = l + (r - l) / 2 +1;
			int t = -1;
         
			if ((t = findDuplicate(s, mid)) == -1) {
				r = mid - 1;

			} else {
				l = mid;
				if (j < mid) {
					j = mid;
					i = t;
				}
			}
		}
		return i > 0 ? s.substring(i, i + j) : "";
	
	
	}

	/**
	 * polynomial rolling hash
	 * 
	 * @param str
	 * @param len
	 * @param map
	 * @return
	 */
	private int findDuplicate(String str, int window) {
		long currHash = 0, multiplier = 1, p = (1 << 31) - 1, base = 26;
        StringBuilder s = new StringBuilder();
		for (int i = 0; i < window; i++) {
			currHash = ((currHash * base)  + str.charAt(i)) % p;
            s.append(str.charAt(i));
		}
        
            
		
		int start = 0;

        
        for (int k = 1; k < window; ++k) {
            multiplier = (multiplier * 26) % p;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(currHash, start);
        for (int i = window; i < str.length() ; i++) {
            
			currHash = ((currHash + p -  multiplier* str.charAt(start++) % p) * base + str.charAt(i)) % p;
            s= s.deleteCharAt(0);
            s.append(str.charAt(i));
            Integer t = map.get(currHash);
			if (t != null && str.substring(t,t+window).equals(s.toString()))
					return start;
			
			map.put(currHash, start);
		}
		map.clear();
		return -1;

		
	
		
	}
	/**
	 * O(N^2) Complexity runtime error
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public String longestDupSubstring(char[] nums1, char[] nums2) {
		int max = 0, mi = -1, mj = -1;
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		for (int i = 1; i <= nums1.length; i++) {
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				if (max < dp[i][j] && i != j) {
					max = dp[i][j];
					mi = i;
					mj = j;
				}
			}
		}
		String res = "";
		while (max-- > 0) {
			res = nums1[--mi] + res;
		}

		return res;

	}
}
