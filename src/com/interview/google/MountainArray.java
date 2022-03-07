package com.interview.google;

/**
 * https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/submissions/
 * 
 * You may recall that an array arr is a mountain array if and only if:
 * 
 * arr.length >= 3 There exists some index i (0-indexed) with 0 < i < arr.length
 * - 1 such that: arr[0] < arr[1] < ... < arr[i - 1] < arr[i] arr[i] > arr[i +
 * 1] > ... > arr[arr.length - 1] Given an integer array nums​​​, return the
 * minimum number of elements to remove to make nums​​​ a mountain array.
 * 
 * @author nisharma
 *
 */
public class MountainArray {
	public static int minimumMountainRemovals(int[] arr) {
		int left = 0, right = arr.length - 1, mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (arr[mid] < arr[mid + 1])
				left = mid + 1;
			else
				right = mid;
		}
		mid = right;
		left = getLIS(arr, 0, mid - 1);
		right = getLDS(arr, arr.length - 1, mid + 1);
		return arr.length -left - right-1;
	}

	public static int getLIS(int[] arr, int start, int end) {

		if (start >= end) {
			return 1;
		}
		if (arr[start] < arr[start + 1])
			return Math.max(1 + getLIS(arr, start + 1, end),getLIS(arr, start + 1, end));
		return getLIS(arr, start + 1, end);
	}

	public static int getLDS(int[] arr, int start, int end) {

		if (start <= end) {
			return 1;
		}
		if (arr[start] < arr[start - 1])
			return Math.max(1 + getLDS(arr, start - 1, end),getLDS(arr, start - 1, end));
		return getLDS(arr, start - 1, end);

	}

	public static void main(String[] args) {
		int[] peek = {2,1,1,5,6,2,3,1};
		System.out.println(minimumMountainRemovals(peek));
	}
}
