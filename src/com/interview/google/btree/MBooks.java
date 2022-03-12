package com.interview.google.btree;

public class MBooks {
	    public static long ayushGivesNinjatest(int n, int m, int[] time) {
	        // Write your code here.
	        long right=0, left = Long.MIN_VALUE;
	        for(int t:time){
	            right+=t;
	            if(left <t)
	                left = t;
	        }
	        
	        while(left<=right){
	            long mid = (left+right)/2;
	            if(isPossible(mid,n,time))
	                right = mid-1;
	            else
	                left = mid + 1;
	        }
	        return left;
	    }
	    public static boolean isPossible(long n, int m, int[] time) {
	     	long sum=0;
	        for(int t:time){
	            sum+=t;
	            if(sum>n){
	                sum = t;
	                m--;
	            }
	            if(m<=0)
	                return false;
	        }
	        return true;
	    }
	    public static void main(String[] args) {
	    	int[] arr = {1, 2, 2, 3, 1};
			ayushGivesNinjatest(3, 5, arr);
		}
	}