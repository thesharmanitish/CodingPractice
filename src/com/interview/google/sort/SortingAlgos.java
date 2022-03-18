package com.interview.google.sort;

import java.util.Arrays;

public class SortingAlgos {
	    public static int[] insertionSort(int[] nums) {
	        for(int i=1;i<nums.length;i++){
	            int prev = i-1;
	            while(prev>=0 && nums[prev] >nums[prev+1]){
	                swap(nums, prev, prev+1);
	                prev--;
	            }
	        }
	        return nums;
	    }
	    public static void swap(int[] arr, int a, int b){
	        arr[a] = arr[a]+arr[b];
	        arr[b] = arr[a]-arr[b];
	        arr[a] = arr[a]-arr[b];
	    }
	    
	    public static int[] selectionSort(int[] nums) {
	        for(int i=0;i<nums.length;i++){
	        	int j = getIndexOfMinimumElement(nums,i);
	        	if(i!=j)
	        		swap(nums, i, j);
	        }
	        return nums;
	    }	    
	    
	    private static int getIndexOfMinimumElement(int[] nums, int i) {
	    	int min = Integer.MAX_VALUE, ind = i;
	    	for(int j=i+1;j<nums.length;j++)
	    		if(min>nums[j]) {
	    			min = nums[j];
	    			ind = j;
	    		}
			return ind;
		}
		public static void main(String[] args) {
			int[] arr = {2,4,6,3,5,1};
			selectionSort(arr);
			Arrays.stream(arr).forEach(System.out::println);
		}
}
