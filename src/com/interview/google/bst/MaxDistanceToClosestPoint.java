package com.interview.google.bst;
/**
 * 
 * https://leetcode.com/problems/maximize-distance-to-closest-person/submissions/
 * 
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

 * @author nisharma
 *
 */
public class MaxDistanceToClosestPoint {
	public static int maxDistToClosestOptimized(int[] seats) {
		int res = 0, max = 0, last = -1, n = seats.length;
		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				res = last < 0 ? i : Math.max(res, (i - last) / 2);
				last = i;
			}

		}
		max = Math.max(n - last - 1, res);
		return max;
	}

	public static int maxDistToClosest(int[] seats) {

		int start = 0, end = seats.length - 1, max = 0, n = end, ind = -1, count = 0;
		while (seats[start++] != 1)
			;
		max = start - 1;
		ind = 0;
		while (seats[end--] != 1)
			;
		if (max < (n - end - 1)) {
			ind = n;
			max = n - end - 1;
		}
		if (n < 2)
			return max;
		int i = 0;
		for (i = start; i <= end; i++) {
			if (seats[end] == 1)
				end--;
			if (seats[i] == 1) {
				if (count % 2 == 1) {
					int cal = (count + 1) / 2;
					if (max < cal) {
						ind = i - count;
						max = cal;
					}

				} else {
					int cal = (count) / 2;
					if (max < cal) {
						ind = i - 1 - count;
						max = cal;
					}
				}
				count = 0;
			} else {
				count++;
			}
		}
		if (count != 0) {

			if (count % 2 == 1) {
				int cal = (count + 1) / 2;
				if (max < cal) {
					ind = i - count - 1;
					max = cal;
				}

			} else {
				int cal = (count) / 2;
				if (max < cal) {
					ind = i - 2 - count;
					max = cal;
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 1 };
		System.out.println(maxDistToClosest(arr));
	}
}
