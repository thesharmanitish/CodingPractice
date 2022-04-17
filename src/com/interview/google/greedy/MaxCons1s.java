package com.interview.google.greedy;

import java.util.Scanner;


/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * 
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/maximum-consecutive-ones-ii-official/ojquestion
 * 
 * @author nisharma
 *
 */
public class MaxCons1s {

	public static int solution(int[] arr, int k) {
		int max = 0, j = -1, count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				count++;

			while (count > k) {
				j++;
				if (arr[j] == 0) {
					count--;

				}
			}
			int len = i - j;
			if (max < len)
				max = len;
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.println(solution(arr, k));
	}

}
