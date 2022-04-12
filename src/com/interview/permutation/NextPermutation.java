package com.interview.permutation;

/**
 * https://leetcode.com/problems/next-permutation/
 * 
 * A permutation of an array of integers is an arrangement of its members into a
 * sequence or linear order.
 * 
 * For example, for arr = [1,2,3], the following are considered permutations of
 * arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * 
 * The next permutation of an array of integers is the next lexicographically
 * greater permutation of its integer. More formally, if all the permutations of
 * the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that
 * follows it in the sorted container. If such arrangement is not possible, the
 * array must be rearranged as the lowest possible order (i.e., sorted in
 * ascending order).
 * 
 * @author nisharma
 *
 */
public class NextPermutation {
	/* 0 */ public void nextPermutation(int[] nums) {
		// pivot is the element just before the non-increasing (weakly decreasing)
		// suffix
		/* 2 */ int pivot = indexOfLastPeak(nums) - 1;
		// paritions nums into [prefix pivot suffix]
		if (pivot != -1) {
			int nextPrefix = lastIndexOfGreater(nums, nums[pivot]);
			// in the worst case it's suffix[0]
			// next prefix must exist because pivot < suffix[0], otherwise pivot would be
			// part of suffix
			/* 4 */ swap(nums, pivot, nextPrefix); // this minimizes the change in prefix
		}
		/* 5 */ reverseSuffix(nums, pivot + 1);
		// reverses the whole list if there was no pivot
		/* 6 */ }

	/**
	 * Find the last element which is a peak. In case there are multiple equal
	 * peaks, return the first of those.
	 * 
	 * @return first index of last peak
	 */
	/* 1 */ int indexOfLastPeak(int[] nums) {
		for (int i = nums.length - 1; 0 < i; --i) {
			if (nums[i - 1] < nums[i])
				return i;
		}
		return 0;
	}

	/** @return last index where the {@code num > threshold} or -1 if not found */
	/* 3 */ int lastIndexOfGreater(int[] nums, int threshold) {
		for (int i = nums.length - 1; 0 <= i; --i) {
			if (threshold < nums[i])
				return i;
		}
		return -1;
	}

	/** Reverse numbers starting from an index till the end. */
	void reverseSuffix(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start++, end--);
		}
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
