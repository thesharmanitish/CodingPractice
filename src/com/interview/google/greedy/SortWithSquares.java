package com.interview.google.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortWithSquares {

    public static  ArrayList<Integer> solve(List<Integer> A) {

        for(int i=0;i<A.size();i++){
            A.set(i,A.get(i)*A.get(i));
        }
        int start =0, end = A.size()-1, curr = end;
        ArrayList<Integer> t = new ArrayList<>(end+1);
        for(int i=0;i<end+1;i++)
            t.add(0);
        while(start<=end){

                if(Math.abs(A.get(start))>A.get(end)){
                    t.set(curr--,Math.abs(A.get(start++)));
                }
                else
                    t.set(curr--,A.get(end--));
            
        }
        return t;
    }
    public static void main(String[] args) {
    	List<Integer> al = Arrays.asList(-6, -3, -1, 2, 4, 5);
		System.out.println(solve(al));
	}
}
