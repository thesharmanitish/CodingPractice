package com.interview.array;

/**
 * 
 * 
 * https://leetcode.com/problems/maximum-product-subarray/submissions/
 * 
 * 
 * @author nisharma
 *
 */
public class MaxProduct {
	
    public int maxProductOpt(int[] nums) {
        int maxSoFar = nums[0], minSoFar = nums[0], prod =nums[0], result = maxSoFar;
        
        for(int i=1;i<nums.length;i++){
            int tmp = Math.max(maxSoFar*nums[i],Math.max(nums[i]*minSoFar,nums[i]));
            minSoFar = Math.min(maxSoFar*nums[i],Math.min(nums[i]*minSoFar,nums[i]));
            maxSoFar = tmp;
            result = Math.max(maxSoFar, result);
        }
            return result;
        
    }
    
	public int maxProduct(int[] nums) {
		int prod = 1, max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				prod *= nums[i];
				max = nums[i] > prod ? max > nums[i] ? max : nums[i] : max > prod ? max : prod;
			} else {
				max = max > nums[i] ? max : nums[i];
				if (i + 1 < nums.length)
					prod = 1;
				else
					prod = 0;
			}
		}
		max = max > prod ? max : prod;
		prod = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] != 0) {
				prod *= nums[i];
				max = nums[i] > prod ? max > nums[i] ? max : nums[i] : max > prod ? max : prod;
			} else {
				max = max > nums[i] ? max : nums[i];
				if (i - 1 >= 0)
					prod = 1;
				else
					prod = 0;
			}
		}
		return max > prod ? max : prod;
	}
}
