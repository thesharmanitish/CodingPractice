package com.interview.leetcode;

import com.interview.set.PowerSet;

public class Leetcode1 {
	public int findClosestNumber(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (Math.abs(num) < min) {
				min = num;
				System.out.print(min + " ");
			} else if (Math.abs(num) == min)
				min = min > num ? min : num;

		}
		return min;
	}
	public static void main(String[] args) {
		int[] arr = { -4,-2,1,4,8 };
		System.out.println(new Leetcode1().findClosestNumber(arr));
	}
}
