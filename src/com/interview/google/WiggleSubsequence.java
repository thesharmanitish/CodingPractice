package com.interview.google;

public class WiggleSubsequence {
	 public int wiggleMaxLength(int[] nums) {
	        if( nums.length == 0 ) return 0;
	        
	        int[] up = new int[nums.length];
	        int[] down = new int[nums.length];
	        
	        up[0] = 1;
	        down[0] = 1;
	        
	        for(int i=1;i<nums.length;i++){
	            if(nums[i]>nums[i-1]){
	                up[i] = down[i-1]+1;
	                down[i] = down[i-1];
	            }else if(nums[i]<nums[i-1]){
	                down[i] = up[i-1]+1;
	                up[i] = up[i-1];
	            }else{
	                up[i] = up[i-1];
	                down[i] = down[i-1];
	            }
	        }
	        
	        return Math.max(down[nums.length-1],up[nums.length-1]);
	    }
	    
//	     public int wiggleMaxLength(int[] nums) {
//	         if(nums.length<1) return 1;
//	         return wiggleMaxLength(nums,1);
//	     }
//	     public int wiggleMaxLength(int[] nums, int n) {
//	         if(n>=nums.length)
//	             return 0;
//	         if(nums[n]>nums[n-1]){
//	             if(n+1<nums.length && nums[n]>nums[n+1]){
//	                 return Math.max(3,2+wiggleMaxLength(nums,n+2));
//	             }
//	             if(n+1>=nums.length)
//	                 return 2;
	            
//	         }
//	         return -1;    
//	     }    
}
