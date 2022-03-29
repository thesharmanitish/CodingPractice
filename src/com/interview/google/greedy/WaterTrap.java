package com.interview.google.greedy;

import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode.com/problems/trapping-rain-water/discuss/153992/Java-O(n)-time-and-O(1)-space-(with-explanations).
 * 
 * @author nisharma
 *
 */
public class WaterTrap {
	public static int trap(final List<Integer> A) {
		int i = 0, n = A.size(), j = n - 1, sum = 0, maxleft =0, maxright = 0;
		while (i < j) {
			// rightVal = Math.max(A.get(j),rightVal);
			// leftVal = Math.max(A.get(i),leftVal);

			if (A.get(i) > A.get(j)) {
				if (maxright > A.get(j)) {
					sum +=maxright - A.get(j);
				}else
					maxright = A.get(j);
				j--;
			} else {
				if (maxleft > A.get(i)) {
					sum += maxleft - A.get(i);
				}
				else
					maxleft = A.get(i);
				i++;

			}

		}
		return sum;
	}

	public static void main(String[] args) {

		List<Integer> arr = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
		System.out.print(trap(arr));

	}
}
