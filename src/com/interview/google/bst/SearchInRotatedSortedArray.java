package com.interview.google.bst;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * @author nisharma
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int[] arr, int target) {
		int low = 0, high = arr.length - 1, n = high, res = -1, mid = 0;
		if (arr.length == 0)
			return -1;
		if (arr.length == 1) {
			if (arr[0] == target)
				return 0;
			return -1;
		}
		while (low < high - 1) {
			mid = low + (high - low) / 2;
			if (arr[mid] < arr[high])
				high = mid;
			else
				low = mid;
		}
		res = arr[low] > arr[high] ? high : low;
		if (arr[res] == target)
			return res;

		else if (target <= arr[n]) {

			low = res;
			high = arr.length - 1;
		}
		// Arrays.fill(arr, mid, high+1, Integer.MAX_VALUE);
		else if (target > arr[n]) {

			low = 0;
			high = res;
		}
		// Arrays.fill(arr, low, res+1, Integer.MIN_VALUE);

		while (low < high - 1) {
			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;

			else if (target > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;

		}
		if (arr[low] == target)
			return low;
		else if (arr[high] == target)
			return high;
		else
			return -1;

	}
}
