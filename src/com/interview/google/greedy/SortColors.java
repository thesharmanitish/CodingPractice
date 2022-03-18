package com.interview.google.greedy;

/**
 * https://leetcode.com/problems/sort-colors/submissions/ Given an array nums
 * with n objects colored red, white, or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * 
 * @author nisharma
 *
 */
public class SortColors {

	public void sortColors(int[] nums) {
		int j = nums.length - 1;
		int i = 0, start = 0;
		if (nums.length <= 1)
			return;
		while (i <= j) {
			if (nums[i] == 0) {
				swap(nums, i, start);
				i++;
				start++;
			} else if (nums[i] == 2) {
				swap(nums, i, j);
				j--;
			} else
				i++;

		}
	}

//	     public void sortColors(int[] nums) {
//	         int last = nums.length-1;
//	         int start = 0;
//	         int size= last;

//	         for(int i=0;i<nums.length;i++){
//	            while(last>=0 && nums[last]==2) last--;
//	            if(nums[i] ==2 && i<last){
//	                swap(nums,i, last);
//	                last--;
//	            }             

//	         }
//	         for(int i=last;i>=0;i--){
//	            while(start < size && nums[start]==0) start++;
//	            if(nums[i] ==0 && i>start){
//	                swap(nums,i, start);
//	                start++;
//	            }             

//	         }
//	     }

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
