package com.interview.google;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * 
 * You are given a 0-indexed integer array nums of even length consisting of an
 * equal number of positive and negative integers.
 * 
 * You should rearrange the elements of nums such that the modified array
 * follows the given conditions:
 * 
 * Every consecutive pair of integers have opposite signs. For all integers with
 * the same sign, the order in which they were present in nums is preserved. The
 * rearranged array begins with a positive integer. Return the modified array
 * after rearranging the elements to satisfy the aforementioned conditions.
 * 
 * @author nisharma
 *
 */
public class ReArrangeArray {

	public static int[] rearrangeArray(int[] nums) {
		int j = 0, k = 1;
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				res[j] = nums[i];
				j += 2;
			} else {
				res[k] = nums[i];
				k += 2;
			}

		}
		return res;
	}

	public static void main(String[] args) {
		int[] peek = { 3, 1, -2, -5, 2, -4 };
		System.out.println(rearrangeArray(peek));
	}
}
