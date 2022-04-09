package com.interview.google.greedy;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-peak-element/submissions/
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given an integer array nums, find a peak element, and return its index. If
 * the array contains multiple peaks, return the index to any of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * 
 * https://leetcode.com/problems/find-peak-element/discuss/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search
 * 
 * @author nisharma
 *
 */
public class FindPeek {
	public static int findPeakElementOrderNSolution(int[] nums) {
		int max = 0, ind = -1;
		if (nums.length < 2)
			return 0;
		for (int i = 0; i < nums.length; i++) { // find max, and it will be greater than
												// every other no.
			if (max < nums[i]) { // O(n)
				max = nums[i];
				ind = i;
			}
		}
		return ind == Integer.MIN_VALUE ? -1 : ind;
	}

	public static int findPeakElement(int[] nums) {  // O(log(n) solution
		int max = 0, ind = -1;
		if (nums.length < 2)
			return 0;
		int i = 0, j = nums.length - 1, mid = 0;
		while (i < j) {
			mid = i + (j - i) / 2;
			if (nums[mid] > nums[mid + 1]) {
				j = mid;
			} else if (nums[mid] < nums[mid + 1]) {
				i = mid + 1;

			}

		}
		return nums[i] > nums[j] ? i : j;
	}

	public static void main(String[] args) {
		int[] al = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		System.out.println(findPeakElement(al));
	}
}
