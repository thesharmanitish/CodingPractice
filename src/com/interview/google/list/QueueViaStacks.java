package com.interview.google.list;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class QueueViaStacks {

	public static void main(String[] args) {

		ArrayList<Integer> stack1 = new ArrayList<Integer>();
		ArrayList<Integer> stack2 = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int total_operations = sc.nextInt();
		int fn = 0;
		int add_element = 0;
		while (total_operations > 0) {
			fn = sc.nextInt();
			if (fn == 1) {
				add_element = sc.nextInt();
				if (stack1.size() == 0 && stack2.size() == 0) {
					stack1.add(add_element);
				} else {
					stack2.add(add_element);
				}
			} else {
				if (stack1.size() != 0) {
					if (fn == 2) {
						stack1.remove(stack1.size() - 1);
					} else {
						System.out.println(stack1.get(stack1.size() - 1));
					}
				} else {
					while (stack2.size() != 0) {
						stack1.add(stack2.get(stack2.size() - 1));
						stack2.remove(stack2.size() - 1);
					}
					if (fn == 2) {
						stack1.remove(stack1.size() - 1);
					} else {
						System.out.println(stack1.get(stack1.size() - 1));
					}
				}
			}
			--total_operations;
		}
	}
//	    private static Stack<Integer> st1 = new Stack<>();
//	    private static Stack<Integer> st2 = new Stack<>();
//	    public static void main(String[] args) {
//	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//	        Scanner  in=new Scanner(System.in);
//	        int n=in.nextInt();
//	        
//	        while(n-->0){
//	            int q = in.nextInt();
//	            int d = 0; 
//	            if(q==1)
//	            	d = in.nextInt();
//	            switch(q){
//	                case 1: enqueue(d);break;
//	                case 2: dequeue();break;
//	                case 3: print(); break;
//	            }
//	        }
//	  
//	    }
//	    public static void enqueue(int data){
//	        if(st2.isEmpty() && st1.isEmpty()){
//	            st1.push(data);
//	        }else
//	            st2.push(data);
//	    }
//	    public static void dequeue(){
//	        if(!st1.isEmpty())
//	            st1.pop();
//	        else {
//	        	while(!st2.isEmpty())
//	        		st1.push(st2.pop());
//	        	if(!st1.isEmpty())
//	        		st1.pop();
//	        }
//	    }
//	    public static void print(){
//	        System.out.println(st1.peek());
//	    }
}
