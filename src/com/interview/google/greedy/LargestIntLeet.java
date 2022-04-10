package com.interview.google.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * https://leetcode.com/contest/weekly-contest-288
 * 
 * 
 * @author nisharma
 *
 */
public class LargestIntLeet {
    public static int largestInteger(int num) {
        List<Integer> even= new ArrayList<>();
        List<Integer> odd= new ArrayList<>();
        int i=0;
        int temp = num;
        int[] arr = new int[10];
        while(num>0){
            int t = num%10;
            num = num/10;
            if((t&1 ) ==1)
                 odd.add(t);
            else 
                even.add(t);
            arr[i] = t;
            i++;
        }
        Collections.sort(odd);
        Collections.sort(even);
        int a= odd.size()-1;
        int b = even.size()-1;
        long res = 0;
        for(int j=i-1;j>=0;j--){
            if((arr[j]&1)==1){
                res +=odd.get(a--);
            }else{
                res +=even.get(b--);
            }
            if(j!=0)
            	res *=10;
            
        }
        return (int) res;
        
    }
    public static void main(String[] args) {
		System.out.println(largestInteger(143915027));
	}
}
