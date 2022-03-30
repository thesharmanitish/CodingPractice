package com.interview.google.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSort {
    public static void countSort(List<List<String>> arr)  throws Exception{
    // Write your code here
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   
    int size=bf.read();
    StringBuilder[] st=new StringBuilder[100]; 

    for(int i=0;i<100;i++)
    {
        st[i]=new StringBuilder();
    }

    for(int i=0;i<size;i++)
    {
        String sts= bf.readLine();
        String[] str=sts.split("[\\s]+");
        int k=Integer.parseInt(str[0]);
        if(i<size/2)
            st[k].append("- ");
        else
            st[k].append(str[1]+" ");
        
    }

    for(int i=0;i<100;i++)
    {   if(st[i].length()!=0)
         System.out.print(st[i]);
    
    }
  }
    public static void main(String[] args) throws Exception {
    	List<List<String>> ll = new ArrayList<>();
    	ll.add(Arrays.asList("1","a"));
    	ll.add(Arrays.asList("2","a"));
    	ll.add(Arrays.asList("1","b"));
    	ll.add(Arrays.asList("3","a"));
    	countSort(ll);
	}
}