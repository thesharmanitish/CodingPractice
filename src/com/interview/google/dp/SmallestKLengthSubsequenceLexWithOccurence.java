package com.interview.google.dp;

import java.util.Stack;

public class SmallestKLengthSubsequenceLexWithOccurence {
	public static void main(String[] args) {
		int[] peek = { 2, 1, 1, 5, 6, 2, 3, 1 };
		System.out.println(smallestSubsequence("eeeexeeeyexyyeyxeyexyxeyexeexyexxxxyxeye",7,'e',2));
	}
    public static String smallestSubsequence(String s, int k, char letter, int repetition) {
        int[] count  = new int[26];
        boolean[] visited  = new boolean[26];
        for(char c:s.toCharArray()){
            count[c-'a']++; 
        }
        Stack<Character> stack = new Stack<>();
        int size = s.length(), letterCount=0;
        for(char c:s.toCharArray()){
            
//            if(visited[c-'a'])
//                continue;
            while(!stack.isEmpty() && stack.peek() > c && size+stack.size() >k){
                if(stack.peek()==letter && letterCount+count[letter-'a']<=repetition) 
                    break;
                visited[stack.peek()-'a'] = false;
                if(stack.pop()==letter)
                	letterCount--;
                    
            }
            stack.push(c);
            size--; 
            if(c!=letter)
            	visited[c-'a'] = true;
            else 
            	letterCount++;
            count[c-'a']--;
            if(stack.size() >= k && letterCount==repetition){
             
                    break;
            }
        }
        StringBuilder sb = new StringBuilder(k);
        int n = stack.size();
        while(!stack.isEmpty()){
            char c= stack.pop();
            if(n==k || (c==letter && letterCount==repetition))
                sb.append(c);
            else{
                if(c!=letter)
                    n--;
                if(letterCount>repetition) {
                    letterCount--;
                    n--;
                }
            }
        }
        return sb.reverse().toString();
    }
	
}
