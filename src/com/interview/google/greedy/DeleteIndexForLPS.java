package com.interview.google.greedy;

public class DeleteIndexForLPS {
    public static int palindromeIndex(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start<end && s.charAt(start++)!= s.charAt(end--));
        if(start>=end) return -1;
        if(isPalindrome(s, start+1, end)) return start;
        if(isPalindrome(s, start, end-1)) return end;
        return -1;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;        
    }
}


