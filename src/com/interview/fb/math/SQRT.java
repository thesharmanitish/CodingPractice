package com.interview.fb.math;


/**
 * https://leetcode.com/problems/sqrtx/submissions/
 * 
 * 
 * @author nisharma
 *
 */
public class SQRT {
    public static  int mySqrt(int x) {
        int start = 1, end  = x, mid =0,res = 0;
        if(x ==1 || x ==0)
            return x;
        if(x<6)
            return x/2;
        while(start<end-1){
            mid = (start+end) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid; 
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
                
            }
        
        return start;
            
    }
    public static void main(String[] args) {
		System.out.println(mySqrt(8));
	}
}
