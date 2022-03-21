package com.interview.google.bst;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 * Suppose an array of length n sorted in ascending order is rotated between 1
 * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * 
 * [4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated
 * 7 times.
 * 
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums of unique elements, return the minimum
 * element of this array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * 
 * @author nisharma
 *
 */
public class MinimumInRotatedArray {
//	     public int findMin(int[] nums) {
//	     int left = 0;
//	     int right = nums.length - 1;
//	     while(left < right) {
//	         int mid = left + (right - left) / 2;
//	         if(nums[mid] < nums[right]) {
//	             right = mid;
//	         } else {
//	             left = mid + 1;
//	         }
//	     }
//	     return nums[left];
	// }

	public int findMin(int[] arr) {
		int low = 0, high = arr.length - 1;
		if (arr.length == 0)
			return -1;
		else if (arr.length == 1)
			return arr[0];

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && arr[mid - 1] > arr[mid])
				return arr[mid];
			else if (arr[low] <= arr[mid] && arr[mid] > arr[high])
				low = mid + 1;
			else {
				high = mid - 1;
			}
		}
		return arr[low];
	}
}