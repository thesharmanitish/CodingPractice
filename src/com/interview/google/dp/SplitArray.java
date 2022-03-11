package com.interview.google.dp;

/**
 * https://leetcode.com/problems/split-array-largest-sum/ Given an array nums
 * which consists of non-negative integers and an integer m, you can split the
 * array into m non-empty continuous subarrays.
 * 
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [7,2,5,10,8], m = 2 Output: 18
 * 
 * @author nisharma
 *
 */
public class SplitArray {
	public int splitArray(int[] nums, int m) {
		int sum = 0, min = Integer.MIN_VALUE;
		for (int n : nums) {
			sum += n;
			min = min < n ? n : min;
		}
		if (m == 1)
			return sum;
		while (min < sum) {
			int mid = (sum + min) / 2;
			if (validSum(nums, mid, m)) {
				sum = mid;
			} else
				min = mid + 1;

		}
		return min;
	}

	public boolean validSum(int[] nums, int mid, int partition) {
		int curSum = 0, parts = 1;
		for (int n : nums) {
			curSum += n;
			if (curSum > mid) {
				if (++parts > partition)
					return false;
				curSum = n;
			}

		}
		return true;
	}
}