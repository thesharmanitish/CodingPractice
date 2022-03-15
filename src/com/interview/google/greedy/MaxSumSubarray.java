package com.interview.google.greedy;
/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 * 
 * @author nisharma
 *
 */
public class MaxSumSubarray {
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE, curMax = 0;
		if (nums.length <= 1)
			return nums[0];
		for (int i = 0; i < nums.length; i++) {
			curMax = curMax + nums[i];
			max = Math.max(max, curMax);
			if (curMax < 0)
				curMax = 0;
		}

		return max;

//	        int max = 0, curMax = 0, min= Integer.MIN_VALUE;
//	        boolean allNeg = true;
//	        if(nums.length ==1)
//	            return nums[0];
//	        
//	        for(int num:nums){
//	            min = Math.max(num, min);
//	            
//	            if(num>0) 
//	                allNeg = false;
//	            if(max + num <0){
//	                max = 0;
//	                continue;
//	            }
//	            else max+=num;
//	            curMax = Math.max(curMax, max);
//	        }
//	        if(allNeg)
//	            return min;
//	        return curMax;
	}
}