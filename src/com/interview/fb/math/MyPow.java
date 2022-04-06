package com.interview.fb.math;

/**
 * 
 * https://leetcode.com/problems/powx-n/submissions/
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 2.00000, n = 10 Output: 1024.00000
 * 
 * @author nisharma
 *
 */
public class MyPow {
	public double myPow(double x, int n) {
		double res = 1;
		if (x == 0)
			return x;
		else if (x == 1 || n == 0)
			return 1;
		int t = n;
		if (n < 0) {
			x = 1 / x;
			n = -(n + 1);// for Integer.MIN_VALUE
			res = res * x; // when n= -1 should return 1/x atleast 
		}
		while (n > 0) {
			if ((n & 1) == 1) {
				res = res * x;
			}
			x = x * x;
			n = n >> 1;
		}

		return res;

	}
}
