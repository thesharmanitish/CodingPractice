package com.interview.google.dp;

import java.util.List;
/**
 * https://www.interviewbit.com/problems/longest-increasing-subsequence/
 * @author nisharma
 *
 */
public class LIS {
	public int lis(final List<Integer> A) {
		int n = A.size();
		if (n == 1)
			return 1;
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (A.get(i) > A.get(j) && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

}
