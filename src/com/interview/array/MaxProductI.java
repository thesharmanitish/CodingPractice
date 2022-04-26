package com.interview.array;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/submissions/
 * 
 * @author nisharma
 *
 */
public class MaxProductI {
	public int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
		int min1 = Integer.MAX_VALUE, min2 = min1;

		for (int num : nums) {
			if (max1 < num) {
				max3 = max2;
				max2 = max1;
				max1 = num;

			} else if (max2 < num) {
				max3 = max2;
				max2 = num;
			} else if (max3 < num) {
				max3 = num;
			}

			if (min1 > num) {
				min2 = min1;
				min1 = num;

			} else if (min2 > num) {
				min2 = num;
			}

		}
		return Math.max(min1 * min2 * max1, max1 * max2 * max3);
	}
}
