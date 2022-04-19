package com.interview.google.dp;


/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * @author nisharma
 *
 */
public class CombinationSumIV {
    public static  int combinationSum4(int[] nums, int b) {
		int n = nums.length;        
		int[] dp = new int[b + 1]; 
        dp[0] = 1;       
		
        for(int j=1;j<=b;j++){   // this loop does the magic , if reveresed will give the non repeated ones
            for (int i=1;i<=n;i++) {
                if( nums[i-1]<=j)
                    dp[j] += dp[j-nums[i-1]];
            }
		}
        return dp[b];
    }
	
    public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(combinationSum4(arr, 4));
	}
}
