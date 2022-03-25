package com.interview.google.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectPeek {
	public static int perfectPeak(List<Integer> A) {
		int n = A.size(), max = A.get(0), min = Integer.MAX_VALUE;
		int[] mx = new int[n];
		int[] mn = new int[n];
		mx[0] = max;
		mn[n - 1] = min;
		for (int i = 1; i <= n - 1; i++) {
			if (max < A.get(i - 1)) {
				max = A.get(i - 1);

			}

			mx[i] = max;

		}
		for (int i = n-2; i >=0; i--) {
			if (min > A.get(i+1)) {
				min = A.get(i+1);

			}
			mn[i] = min;
		}
		for (int i = 1; i < n - 1; i++) {
			if (A.get(i) > mx[i] && A.get(i) < mn[i])
				return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		List<Integer> al = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
		System.out.println(perfectPeak(al));
	}
}
