package com.interview.google.bst;

public class MaxDistanceToClosestPoint {
    public static int maxDistToClosest(int[] seats) {

        int[] dp = new int[seats.length];
        int sum=seats[0];
        dp[0] = seats[0]==0?1:0;
        for(int i=1;i<seats.length;i++){
            if(seats[i]==0){
                dp[i] = dp[i-1]+1;
            }
            sum+=seats[i];
        }
        if(sum==0)
            return seats.length;
        
        int max = Integer.MIN_VALUE, ind = -1;
        for(int i=0;i<seats.length;i++){
            if(dp[i] >= max){
                max = dp[i];
                ind = i;
            }
            
        }
        if((1 & dp[ind])  ==1)
            return  ind== seats.length-1 || dp[ind]-ind==1?dp[ind]:(dp[ind]/2)+1;
        else 
            return  ind== seats.length-1 || dp[ind]-ind==1?dp[ind]:dp[ind]/2;
        
        
    }
    public static void main(String[] args) {
		int[] arr = {1,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0};
		System.out.println(maxDistToClosest(arr));
	}
}
