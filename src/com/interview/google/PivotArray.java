package com.interview.google;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * 
 * You are given a 0-indexed integer array nums of even length consisting of an
 * equal number of positive and negative integers.
 * 
 * You should rearrange the elements of nums such that the modified array
 * follows the given conditions:
 * 
 * Every consecutive pair of integers have opposite signs. For all integers with
 * the same sign, the order in which they were present in nums is preserved. The
 * rearranged array begins with a positive integer. Return the modified array
 * after rearranging the elements to satisfy the aforementioned conditions.
 * 
 * @author nisharma
 *
 */
public class PivotArray {

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length] ;
         int j=0, k= nums.length-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<pivot)
                res[j++] = nums[i];
        }
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i]>pivot){
                res[k--] = nums[i];
            }
        }
         for(int i=j;i<=k;i++)
             res[i] = pivot;
     return res;
     }

	public static void main(String[] args) {
		int[] peek = {9,12,5,10,14,3,10};
		System.out.println(pivotArray(peek, 10));
	}
}
