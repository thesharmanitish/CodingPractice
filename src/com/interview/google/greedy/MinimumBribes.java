package com.interview.google.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinimumBribes {
	public static void minimumBribes(List<Integer> q) {
		// Write your code here
		// int[] arr = new int[q.size()];
		if (q.size() < 2)
			System.out.println(q.get(0));
		int sum = 0;
		for (int i = 0; i < q.size(); i++) {
			if (q.get(i) - 1 - i > 2) {
				System.out.println("Too chaotic");
				return;
			}
			// sum+= q.get(i)-i-1 >0 ?q.get(i)-i-1:0;
			// if(q.get(i)<i-1)
			// sum+= Math.abs(q.get(i)-i)-2;
		}

		for (int i = q.size() - 1; i >= 0; i--) {
			if (q.get(i) == i + 1)
				continue;
			else {
				if (i - 1 >= 0 && q.get(i - 1) == i+1) {
					q.set(i - 1, q.get(i));
					sum += 1;
				} else if (i - 2 >= 0 && q.get(i - 2) == i+1) {
					int temp = q.get(i);
					sum += 2;
					q.set(i - 2, q.get(i - 1));
					q.set(i - 1, temp);
				} else {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(sum);

	}

	public static void main(String[] args) {
		List<Integer> al = Arrays.asList(2,3,5,4,1);
		 minimumBribes(al);
	}

}
