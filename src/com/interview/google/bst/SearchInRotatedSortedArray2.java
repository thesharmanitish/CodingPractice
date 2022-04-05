package com.interview.google.bst;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * T
 * There is an integer array nums sorted in non-decreasing order (not
 * necessarily with distinct values).
 * 
 * Before being passed to your function, nums is rotated at an unknown pivot
 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
 * example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become
 * [4,5,6,6,7,0,1,2,4,4].
 * 
 * Given the array nums after the rotation and an integer target, return true if
 * target is in nums, or false if it is not in nums.
 * 
 * You must decrease the overall operation steps as much as possible.
 * 
 * @author nisharma
 *
 */
public class SearchInRotatedSortedArray2 {
	public boolean search(int[] arr, int target) {

		int low = 0, high = arr.length - 1, n = high, l = low, res = -1, mid = 0;
		if (arr.length == 0)
			return false;
		if (arr.length == 1) {
			if (arr[0] == target)
				return true;
			return false;
		}
		Arrays.toar
		while (low < high - 1) {
			while (low < arr.length - 1 && arr[low] == arr[low + 1])
				low++;

			while (high > 0 && arr[high] == arr[high - 1])
				high--;

			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return true;
			else if (arr[mid] < arr[high])
				high = mid;
			else
				low = mid;
		}
		res = arr[low] > arr[high] ? high : low;

		if (arr[res] == target)
			return true;

		else if (target <= arr[n]) {

			low = res;
			high = n;
		}
		// Arrays.fill(arr, mid, high+1, Integer.MAX_VALUE);
		else if (target > arr[n]) {

			low = l;
			high = res;
		}
		// Arrays.fill(arr, low, res+1, Integer.MIN_VALUE);

		while (low < high - 1) {
			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return true;

			else if (target > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;

		}
		if (arr[low] == target || arr[high] == target)
			return true;
		else
			return false;

	}
}
