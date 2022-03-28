package com.interview.google.greedy;

import java.util.Scanner;
import java.util.Stack;

public class Vim {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc  = new Scanner(System.in);
        int in = sc.nextInt();
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        for(int i=0;i<in;i++){
            
            int op = sc.nextInt();
            switch(op){
                case 1: stack.push(res.toString());
                        res.append(sc.next());
                
                        break;
                case 2: stack.push(res.toString());
                        int k = sc.nextInt();
                        res.delete(res.length()-k, res.length());
                        break;
                case 3: k = sc.nextInt();
                        System.out.println(res.charAt(k-1)); 
                        break;
                case 4: res = new StringBuilder(stack.pop());
                         break;
            }
        }
    }
}
