package com.interview.google.string;

public class MaxArea {
	public static int maxArea(int[] height) {
		int start = 0, end = height.length - 1, max = 0, mul = 0;
		int maxLeft = start, maxRight = end;

		while (start < end) {
			if (height[start] < height[end]) {
				if (height[start] > maxLeft)
					maxLeft = start;
				mul = height[maxLeft] * (end - start);
				start++;
			} else {
				if (height[end] > maxRight)
					maxRight = end;
				mul = height[maxRight] * (end - start);
				end--;
			}
			System.out.println(mul);
			max = Math.max(max, mul);

		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {1,8,6,2,5,4,8,3,7};
		maxArea(arr);
	}
}
