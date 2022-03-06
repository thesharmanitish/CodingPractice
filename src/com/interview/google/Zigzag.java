package com.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

 * 
 * @author nisharma
 *
 */
public class Zigzag {
    public static String convert(String st, int numRows) {
        char[] s = st.toCharArray();
        StringBuilder[] listSt = new StringBuilder[numRows];
        for(int i=0;i<listSt.length;i++)
        	listSt[i] = new StringBuilder();
        int k=0;
        if(s.length==0)
            return "";
        for(int i=0;i<s.length;i++){
        	listSt[k++].append(s[i]);
            if(k%(numRows)==0) {
            	for(int j=numRows-2;j>=0;j--){
                    listSt[j].append(s[++i]);
                }
                k=0;
            }
            
        }
        
        StringBuilder b = new StringBuilder();
        Arrays.stream(listSt).forEach(b::append);
        return b.toString();
    }
    public static void main(String[] args) {
		convert("PAYPALISHIRING", 4);
	}

}
