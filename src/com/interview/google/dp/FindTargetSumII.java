package com.interview.google.dp;

import java.util.Arrays;
/**
 * 
 * Wallmart interview Question
 * 
 * 
 *  19 = 11 + 11 -1-1-1 | result is min no one's i.e 7
 *  109 = 111-1-1-1 = 6
 *  
 *  N <= 10^12
 *  
 * @author nisharma
 *
 */



public class FindTargetSumII {
    public static int findTargetSumWays(long[] nums, long target) {
		int n = -1;
		long t = target;
		while(t>0) {
			t/=10;
			n++;
		}
		t = target;
		int count =0, x = n;
		if(target<nums[x]) {
			count = checkTargetSumWays(nums,(int) (nums[x] - target)) + x+2;
		}
		else {	
			for(int i=x;i>=0;i--) {
					if(t<nums[x]) {
						count += checkTargetSumWays(nums,(int) (nums[x] - target)) + x+1;
						t = (int) (nums[x] - t);
					}
					while(t>=nums[x]) {
						count+=(x+1)*(t / nums[x]);
						t %= nums[x];
					}
					x--;
			}
		}
		long temp = target % nums[n];
		temp = nums[n]-temp;
		if(temp >0) {
			long temp1 = target / nums[n] +1;
			 int count2 = checkTargetSumWays(nums,temp) + (int) (temp1*(n+1));
			 count = count>count2 ? count2:count;
			
		}
		
		
		n+=1;
		x = n;
		t = target;
		int count1 = checkTargetSumWays(nums,(int) (nums[x] - target)) + x+1;
		
		
		return Math.min(count, count1);
		
    }
    
    public static int checkTargetSumWays(long[] nums, long target) {
		int n = -1;
		long t = target;
		while(t>0) {
			t/=10;
			n++;
		}
		t = target;
		int count =0, x = n;
		for(int i=x;i>=0;i--) {
			while(t>=nums[x]) {
				count+=(x+1)*(t / nums[x]);
				t %= nums[x];
			}
			x--;
		}
		return count;
    }
    public static void main(String[] args) {
		long[] arr = { 1, 11, 111, 1111, 11111,111111,1111111, 11111111, 111111111, 1111111111, 11111111111L, 111111111111L };
		System.out.println(findTargetSumWays(arr, 19));
	}
}
