package com.interview.google.bst;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

	public static int search(int[] arr, int target) {
		int low = 0, high = arr.length - 1, res = -1, mid = 0;
		if (arr.length == 0)
			return -1;
		if (arr.length == 1) {
			if (arr[0] == target)
				return 0;
			return -1;
		}
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (mid>0 && arr[mid] < arr[mid - 1]) {
				res = mid - 1;
				break;
			} else if (arr[mid] > arr[low] && arr[mid] > arr[high])
				low = mid + 1;
			else
				high = mid - 1;
		}
		low = 0;
		high = arr.length - 1;
        if(res ==-1);
		else if (arr[res] >= target && arr[low] <= target)
			Arrays.fill(arr, mid, high+1, Integer.MAX_VALUE);
		else if (arr[res + 1] <= target && arr[high] >= target)
			Arrays.fill(arr, low, res+1, Integer.MIN_VALUE);
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;

			else if (target > arr[mid])
				low = mid+1;
			else 
				high = mid - 1;

		}
		return -1;
	}
	public static void main(String args[])
	{
		int a[] = {3,1};
		int n = a.length;
		
		System.out.println(search(a,0));
	}
}
