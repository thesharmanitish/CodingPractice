package com.interview.string;


/**
 * https://leetcode.com/problems/minimum-window-substring/submissions/
 * 
 * https://thesharmanitish.github.io/til/2022-04-01_minimumwindowsubstring
 * 
 * @author nisharma
 *
 */
public class MinimumSubstring {
	public static String minWindow(String s, String t) {

        int[] map = new int[67];
        for(char c:t.toCharArray())
            map[c-'A'] +=1; 
        int start=0, end = 0, counter =t.length(), minLength=Integer.MAX_VALUE, mstart = 0;
        while(end < s.length()){
            final char c1 = s.charAt(end);
            if(map[c1-'A']>0){
                counter--;
            }
            map[c1-'A'] -=1;    
            end++;
            while(counter==0){
                if(minLength>end-start){
                    minLength =end-start;
                    mstart = start;
                }
                final char c2 = s.charAt(start);
                map[c2-'A']++;
                if(map[c2-'A']>0)
                    counter++;
                start++;
            }
        }
        return minLength==Integer.MAX_VALUE? "": s.substring(mstart,mstart+minLength);}
	
	public static void main(String[] args) {
		System.out.println(minWindow( "ADOBECODEBANC","ABC"));
	}
}
