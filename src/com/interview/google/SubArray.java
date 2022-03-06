package com.interview.google;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/?page=1&difficulty[]=0&company[]=Google&company[]=Facebook&sortBy=submissions#
 * 
 * @author nisharma
 *
 */
public class SubArray {
    //Function to find a continuous sub-array which adds up to a given number.
	
//    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
//    {
//    	
//      int[] sum = new int[n];
//      int maxSum=0, max = Integer.MIN_VALUE;
//      
//      ArrayList<Integer> ll = new ArrayList<>();
//      
//      for(int i=0;i<n;i++) {
//    	  maxSum += arr[i];
//    	  if(max<arr[i])
//    		  max = arr[i];
//      }
//      
//      
//      return ll;
//    }
//    O(n2) complexity
//	  Runtime error    
    
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int[] sum = new int[n];
        ArrayList<Integer> ll = new ArrayList<>();
        sum[0] = arr[0];
        int x = 0;
        for(int i=1;i<arr.length;i++){
            sum[i] = sum[i-1] + arr[i];
            if(sum[i]==s){

               ll.add(1);
               ll.add(i+1);
               return ll;
            }
            
               
        }
        for(int i=1,j=0;i<arr.length && j<arr.length;){
            x = sum[i]-sum[j];
            if(x==s){
               ll.add(j+2);
               ll.add(i+1);
               return ll;
            }
            else if(x>s){
            	j++;
                i=j+1;
                continue;
            }
            i++;
             
        }
        if(ll.size()==0)
            ll.add(-1);
        return ll;
        
    }
    
//    5 12
//    1 2 3 7 5
//    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5,6,7,8,9,10};
		subarraySum(arr, 10, 19).stream().forEach(System.out::println);
	}
}
