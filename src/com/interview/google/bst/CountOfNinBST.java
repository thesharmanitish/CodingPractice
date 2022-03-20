package com.interview.google.bst;


/**
 * Fist occurrence , last occurrence in binary search tree
 * 
 * @author nisharma
 *
 */
public class CountOfNinBST {
	public static void main(String[] args) {
		int[] arr = {2,4,10,10,10,10, 10, 10, 10,18,20};
		int res = last10(arr, 10) - first10(arr, 10) +1;
		System.out.println("Number of 10s in array are :"+ res);
	}

	private static int last10(int[] arr, int target) {
		int left =0, right = arr.length-1,  res = -1;
		while(left<right) {
			int mid = left + (right-left)/2;
			
			if(arr[mid]==target) {
				res = mid;
				left = mid+1;
			}
			else if(arr[mid]>target) {
				right = mid-1;
			}else {
				left =mid+1;
			}
			
		}
		return res;
	}

	private static int first10(int[] arr, int target) {
		int left =0,right  = arr.length-1,  res = -1;
		while(left<right) {
			int mid = left + (right-left)/2;
			if(arr[mid]==target) {
				res = mid;
				right = mid-1;
			}
			else if(arr[mid]<target) {
				left = mid+1;
			}else {
				right =mid-1;
			}
			
		}
		return res;
	}
}
