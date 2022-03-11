package com.interview.google.btree;

public class SplitArraySum {
	    public static int splitArray(int[] nums, int m) {
	      int sum=0, min = Integer.MIN_VALUE;
	      for(int n:nums)  {
	          sum += n;
	          min = min<n?n:min;
	      }
	      if (m == 1) return sum;
	      while(min<sum) {
	          int mid = (sum+min)/2;
	          if(validSum(nums,mid, m)){
	              min = mid+1;
	          }else
	              sum = mid;
	          
	      }
	        return min;
	    }
	    public static boolean validSum(int[] nums,int mid, int partition){
	        int curSum = 0, parts =1;
	        for(int n:nums){
	            curSum +=n;
	            if(curSum > mid){
	                if(++parts >partition)
	                    return false;
	                curSum = n;
	            }
	            
	                
	        }
	        return true;
	    }
	    public static void main(String[] args) {
	    	int[] nums = { 7,2,5,10,8 };
	    	System.out.println(splitArray(nums,2));
		}
}
