package com.interview.google.dp;
/**
 * https://leetcode.com/problems/target-sum/submissions/
 * 
 * @author nisharma
 *
 */
public class TargetSum {

	    public int findTargetSumWaysOptimized(int[] nums, int S) {
	        int sum = 0;
	        for (int n: nums) sum += n;
	        if (sum < S || (sum - S) % 2 == 1) return 0;
	        int target = (sum - S) / 2;
	        int[] dp = new int[target + 1];
	        dp[0] = 1;
	        for (int i = 0; i < nums.length; i++) {
	            for (int j = target; j >= nums[i]; j--) {
	            dp[j] += dp[j - nums[i]];
	            }
	        }
	        return dp[target];
	    }
	    public int findTargetSumWays(int[] nums, int S) {
	        
	        int sum = 0;
	        for (int n: nums) sum += n;
	        if (sum < S || (sum - S) % 2 == 1) return 0;
	        int target = (sum - S) / 2;
	        return findTargetSumWays(nums,nums.length,target);
	        // int[] dp = new int[target + 1];
	        // dp[0] = 1;
	        // for (int i = 0; i < nums.length; i++) {
	        //     for (int j = target; j >= nums[i]; j--) {
	        //     dp[j] += dp[j - nums[i]];
	        //     }
	        // }
	        // return dp[target];
	        
	    }
	    int[][] dp;
	    public int findTargetSumWays(int[] a,int n, int sum) {
	  // Initializing the matrix
	    dp = new int[n + 1][sum + 1];
	  // Initializing the first value of matrix
	    dp[0][0] = 1;
	    for (int i = 1; i <= sum; i++)
	        dp[0][i] = 0;
	    // for (int i = 1; i <= n; i++)
	    //     dp[i][0] = 1;
	 
	    for (int i = 1; i <= n; i++)
	    {
	        for (int j = sum; j >=0; j--)  // this 1 change in subset sum problem
	        {
	            if (a[i - 1] <= j)
	                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]]; 
	            else
	           dp[i][j] = dp[i - 1][j];
	        }
	    }

	    return dp[n][sum];
	        
	    }
}
