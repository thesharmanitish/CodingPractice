package com.interview.google.sort;

import java.util.Arrays;

public class SortingAlgos {
	    public static int[] insertionSort(int[] nums) {
	        int prev = 0;
	        for(int i=1;i<nums.length;i++){
	            prev = i-1;
	            int temp = nums[prev+1];
	            while(prev>=0){
	                // swap(nums, prev, prev+1);
	                if(nums[prev] >temp){
	                   nums[prev+1] = nums[prev];
	                    prev--;
	                }else 
	                    break;
	            }
	            nums[prev+1] = temp;
	        }
	        return nums;
	    }
	    public static void bottomsUpSortArray(int[] nums) {
	        for (int size = 1; size < nums.length; size *= 2) {
	            for (int i = 0; i < nums.length - size; i += 2 * size) {
	                int mid = i + size - 1;
	                int end = Math.min(i + 2 * size - 1, nums.length - 1);
	                merge2(nums, i, mid, end);
	            }
	        }     
	        }
	        private static void merge2(int[] nums, int l, int mid, int r) {
	        int[] tmp = new int[r - l + 1];
	        int i = l, j = mid + 1, k = 0;
	            while (i <= mid || j <= r) {
	                if (i > mid || j <= r && nums[i] > nums[j]) {
	                    tmp[k++] = nums[j++];
	                } else {
	                    tmp[k++] = nums[i++];
	                }
	            }
	        System.arraycopy(tmp, 0, nums, l, r - l + 1);
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
	    public static  int[] quickSort(int[] nums) {
	        if (nums == null || nums.length == 0) return nums;
//	         sortArray(nums, 0, nums.length-1);
	         bottomsUpSortArray(nums);
	         return nums;
	        
	    }
	    
	    public static void sortArray(int[] nums, int start, int end) {
	        if (start >= end) return;
	        int mid = start+((end-start)/2);
	        
	        sortArray(nums, start, mid);
	        sortArray(nums, mid+1, end);
	        
	         merge(nums, start, end);
	        
	        
	    }
	    public static void merge(int[] nums, int start, int end) {
	        int mid = start +((end-start)/2);
	        int j=start,k= mid+1,l=0;
	        int[] tmp = new int[end-start+1];
	        while(j <= mid || k<=end){
	            if(j>mid ||(k<=end && nums[k]<nums[j])){
	                tmp[l++] = nums[k++];
	                
	            }else
	             tmp[l++] = nums[j++];
	            
	        }
	        System.arraycopy(tmp, 0, nums, start, end - start + 1);
	        
	    }
		public static void main(String[] args) {
			int[] arr = {5,2,3,1};
//			selectionSort(arr);
			quickSort(arr);
			Arrays.stream(arr).forEach(System.out::println);
		}

}
