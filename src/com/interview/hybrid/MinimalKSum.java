package com.interview.hybrid;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/append-k-integers-with-minimal-sum/description/
 * 
 * 
 * 2195. Append K Integers With Minimal Sum Medium 480 258 company Amazon
 * 
 * You are given an integer array nums and an integer k. Append k unique
 * positive integers that do not appear in nums to nums such that the resulting
 * total sum is minimum.
 * 
 * Return the sum of the k integers appended to nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,4,25,10,25], k = 2 Output: 5 Explanation: The two unique
 * positive integers that do not appear in nums which we append are 2 and 3. The
 * resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the
 * minimum. The sum of the two integers appended is 2 + 3 = 5, so we return 5.
 * 
 * @author nisharma
 *
 */
public class MinimalKSum {
	public long minimalKSum(int[] nums, int k) {
		Arrays.sort(nums);
		int prev = -1;
		long sum = 0;

		for (int num : nums) {
			if (num > k)
				break;
			if (prev != num && num <= k) {
				k++;
				sum += num;
			}
			prev = num;
		}

		long res = (long) (1 + k) * k / 2 - sum;
		return res;
	}
}
