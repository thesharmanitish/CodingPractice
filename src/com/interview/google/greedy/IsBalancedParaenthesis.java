package com.interview.google.greedy;

import java.util.Stack;

public class IsBalancedParaenthesis {
	    /*
	     * Complete the 'isBalanced' function below.
	     *
	     * The function is expected to return a STRING.
	     * The function accepts STRING s as parameter.
	     */

	    public static String isBalanced(String s) {
	        String open = "{[(";
	        String closed = "}])";
	        Stack<Character> st = new Stack<>();
	        for(char c:s.toCharArray()){
	            if(open.indexOf(c)>=0){
	                st.push(c);
	            }else{
	                if(st.isEmpty()) return "NO";
	                else if(closed.indexOf(c)==open.indexOf(st.peek())) st.pop();    
	                else return "NO";
	            }
	        }
	        return st.isEmpty()?"YES":"NO";
	    }
	    
	    public static void main(String[] args) {
			
		}

}
