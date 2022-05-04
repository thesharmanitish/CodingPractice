package com.interview.string;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/generate-parentheses/submissions/
 * 
 * 
 * @author nisharma
 *
 */
public class GenerateParanthesis {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList();
		generateAll(new StringBuilder(), 0, 0, n, res);
		return res;
	}

	public void generateAll(StringBuilder current, int start, int end, int max, List<String> res) {
		if (current.length() == 2 * max) {
			res.add(current.toString());
		} else {
			if (start < max) {

				generateAll(current.append("("), start + 1, end, max, res);
				current.setLength(current.length() - 1);
			}
			if (end < start) {

				generateAll(current.append(")"), start, end + 1, max, res);
				current.setLength(current.length() - 1);
			}
		}

	}
//	     public void generateAll(char[] current, int pos, List<String> result) {
//	         if(pos == current.length)
//	         {
//	             if(isValid(current))
//	                 result.add(new String(current));
//	         }else{
//	             current[pos] = '(';
//	             generateAll(current, pos+1, result);
//	             current[pos] = ')';
//	             generateAll(current, pos+1, result);

//	         }
//	     } 
//	     public boolean isValid(char[] current) {
//	         int balance = 0;
//	         for(char c:current){
//	             if(c=='(')
//	                 balance++;
//	             else balance--;

//	             if(balance<0)
//	                 return false;
//	         }
//	         return (balance ==0);
//	     }    
}