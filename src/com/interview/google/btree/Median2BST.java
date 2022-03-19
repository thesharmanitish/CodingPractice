package com.interview.google.btree;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/*
4
1
4
7
8
4
2
3
5
6
*/
public class Median2BST {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int firstArraySize  = sc.nextInt();
		int[] arr = new int[firstArraySize];
		for(int i=0;i<firstArraySize;i++)
			arr[i] = sc.nextInt();
		int secondArraySize  = sc.nextInt();
		int[] brr = new int[secondArraySize];
		for(int i=0;i<secondArraySize;i++)
			brr[i] = sc.nextInt();		
		
		System.out.println(findMedian(arr,brr));
//		
//		printArray(arr);
//		printArray(brr);

	}

	private static double findMedian(int[] arr, int[] brr) {
		// TODO Auto-generated method stub
		int a = arr.length, b = brr.length;
		int mid1 = (int) (Math.ceil(a/2)-1), mid2 = (int) (Math.ceil(b/2)-1);
		
		while(mid1>=0 && mid2+1<b && arr[mid1]<arr[mid2+1]) {
			mid1--;
			mid2++;
		}
		while(mid2>=0 && mid1+1<a &&arr[mid2]<arr[mid1+1]) {
			mid2--;
			mid1++;
		}
		if(mid1==-1)
			return brr[mid2];
		else if(mid2 ==-1)
			return arr[mid1];
		else {
			if(arr[mid1]>brr[mid2])
				if((a+b)%2==1)
					return arr[mid1];
				else {
					double prev = arr[mid1-1] < brr[mid2]?brr[mid2]:arr[mid1-1];
					prev+=arr[mid1];
					return prev/2;
				}
			else 
				if((a+b)%2==1)
					return brr[mid2];
				else {
					double prev = brr[mid2-1] < arr[mid1]?arr[mid1]:brr[mid2-1];
					prev+=brr[mid2];
					return prev/2;
				}
		}
		
		
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int n:arr)
			System.out.print(n+" ");
		
	}
}
