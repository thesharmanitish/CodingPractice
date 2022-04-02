package com.interview.string;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
 * 
 * Given two integer arrays nums1 and nums2, return the maximum length of a
 * subarray that appears in both arrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7] Output: 3 Explanation: The
 * repeated subarray with maximum length is [3,2,1].
 * 
 * @author nisharma
 *
 */
public class MaximumLengthOfRepeatedSubarray {
	public int findLength(int[] nums1, int[] nums2) {
		int max = 0;
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		for (int i = 1; i <= nums1.length; i++) {
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				max = Math.max(max, dp[i][j]);
			}
		}

		return max;

	}
}
