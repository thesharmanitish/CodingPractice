package com.interview.google.greedy;

import java.util.Stack;

public class MatchingParanthesis {
	    public boolean isValid(String s) {
	        
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
	        
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else {
	            if(stack.isEmpty()) 
	                return false;
	            switch(c){
	                case ')' : if(stack.pop() != '(') 
	                            return false;
	                          break;
	                case ']' : if(stack.pop() != '[') 
	                            return false;
	                          break;
	                case '}' : if(stack.pop() != '{') 
	                            return false;
	                          break;   
	            }
	        }
		}
		return stack.isEmpty() ? true: false;
	    }
	}