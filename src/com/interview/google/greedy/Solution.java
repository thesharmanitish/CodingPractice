package com.interview.google.greedy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        StringBuilder sb = new StringBuilder(s.length());
        int a=25;
       

        for(char ch:s.toCharArray()){

            if((ch>='A' && ch<='Z')){
                ch+=k;  
                if(ch>'Z'){
                  int tmp =  (int) (ch-'Z')%a;
                   char b=(char)tmp;
                   b+='A';
                   
                }
            }
            else if(ch>='a' && ch<='z'){
                ch+=k;
                if(ch>'z'){
                   int tmp =  (int) (ch-'z')%a;
                   char b=(char)tmp;
                   b+='a';
                }               
            }
            
            sb.append(ch);
            
        }
        System.out.println(sb);
        return sb.toString();

    }


}

public class Solution {
	public static void main(String[] args) {
        System.out.println(Result.caesarCipher("Zabcdefghijklmnopqrstuvwxyz-':", 27));
    }
}
