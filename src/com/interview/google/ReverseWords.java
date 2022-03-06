package com.interview.google;

import java.util.Arrays;

public class ReverseWords {
	public static void main(String[] args) {
		reverse("Hello World");
	}

	private static void reverse(String string) {

		char[] chArr = string.toCharArray();
		StringBuilder sb = new StringBuilder(string.length());

		int length = chArr.length-1;
		
		StringBuilder word = new StringBuilder();
		for (int i = length; i >=0 ; i--) {
			
			if(chArr[i] == ' ') {
				sb.append(word).append(chArr[i]);
				word.setLength(0);
			}
			else {
				StringBuilder temp = new StringBuilder();
				temp.append(chArr[i]).append(word);
				word =temp;
			}
			
		}
		sb.append(word);
		word.setLength(0);
		sb = sb.reverse();
		System.out.println(sb);

	}

}
