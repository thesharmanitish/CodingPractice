package com.interview.google;

public class StringDecode {
	    public String decodeString(String s) {
	        return decodeString(s.toCharArray()).toString();
	    }
	    private static int i = 0;
	    public StringBuilder decodeString(char[] arr) {
	        StringBuilder sb = new StringBuilder(arr.length);
	        if(arr.length==0)
	            return sb;
	        while(i<arr.length){
	                
	                 if(Character.isDigit(arr[i])){
	                     int num = arr[i++];
	                     StringBuilder s = decodeString(arr);
	                    for(int j=0;j<num-48;j++)
	                        sb.append(s);
	                  } else if(Character.isAlphabetic(arr[i])){
	                        sb.append(arr[i]);
	                     i++;
	                    }else if(arr[i] == ']'){
	                     i++;
	                        return sb;
	                    }else if(arr[i] == '['){
	                        i++;
	                        continue;
	                    }
	                
	            
	            
	        }
	        return sb;
	    }
	    public static void main(String[] args) {
			System.out.println(new StringDecode().decodeString("3[a2[c]]"));
		}
	}