package com.interview.array;

/**
 * 
 * 
 * https://leetcode.com/problems/maximum-product-subarray/submissions/
 * 
 * 
 * @author nisharma
 *
 */
public class MaxProduct {
	public int maxProduct(int[] nums) {
		int prod = 1, max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				prod *= nums[i];
				max = nums[i] > prod ? max > nums[i] ? max : nums[i] : max > prod ? max : prod;
			} else {
				max = max > nums[i] ? max : nums[i];
				if (i + 1 < nums.length)
					prod = 1;
				else
					prod = 0;
			}
		}
		max = max > prod ? max : prod;
		prod = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != 0) {
				prod *= nums[i];
				max = nums[i] > prod ? max > nums[i] ? max : nums[i] : max > prod ? max : prod;
			} else {
				max = max > nums[i] ? max : nums[i];
				if (i - 1 >= 0)
					prod = 1;
				else
					prod = 0;
			}
		}
		return max > prod ? max : prod;
	}
}
