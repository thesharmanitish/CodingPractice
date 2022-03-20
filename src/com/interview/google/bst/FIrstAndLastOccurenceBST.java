package com.interview.google.bst;


/**
 * Fist occurrence , last occurrence in binary search tree
 * 
 * @author nisharma
 *
 */
public class FIrstAndLastOccurenceBST {
	public static void main(String[] args) {
		int[] arr = {2,4,10,10,10,18,20};
		System.out.println(first10(arr, 10));
		System.out.println(last10(arr, 10));
	}

	private static int last10(int[] arr, int target) {
		int left =0, right = arr.length-1;
		while(left<right) {
			int mid = left + (right-left)/2;
			if(arr[mid]>target) {
				right = mid-1;
			}else
				left =mid;
			
		}
		return left;
	}

	private static int first10(int[] arr, int target) {
		int left =0, right = arr.length-1;
		while(left<right) {
			int mid = left + (right-left)/2;
			if(arr[mid]<target) {
				left = mid+1;
			}else
				right =mid;
			
		}
		return right;
	}
}
