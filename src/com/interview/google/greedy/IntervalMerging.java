package com.interview.google.greedy;

import java.util.Arrays;

public class IntervalMerging {
	    public int[][] merge(int[][] intervals) {
	        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);
	        int a = intervals[0][0];
	        int b = intervals[0][1];
	        int ind = 0;
	        
	        for(int i=1;i<intervals.length;i++){
	                if(b>=intervals[i][0]){
	                    if(b<intervals[i][1]){
	                        b = intervals[i][1];
	                    }
	                    intervals[i][1] = -1;
	                    intervals[i][0] = -1;
	                }else{
	                    intervals[ind][1] = b;
	                    intervals[ind][0] = a;
	                    ind++;
	                    b = intervals[i][1];
	                    a = intervals[i][0];
	                }
	        }
	        intervals[ind][1] = b;
	        intervals[ind][0] = a;        
	        int k=0;
	        int[][] res = new int[ind+1][2];
	        for(int i=0;i<=ind;i++){
	            if(intervals[i][0]==-1)
	               break;
	            res[k][0] =  intervals[i][0];
	            res[k][1] =  intervals[i][1];
	            k++;
	        }
	        return res;
	    }
	}