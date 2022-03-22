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
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING s 2. INTEGER k
	 */

	public static String caesarCipher(String s, int k) {
		// Write your code here
		// Write your code here
		if (s.length() == 0 || k == 0)
			return s;
		StringBuilder sb = new StringBuilder(s.length());
		int a = 26;
		k = k % 26;
		for (char ch : s.toCharArray()) {

			if ((ch >= 'A' && ch <= 'Z')) {
				if (ch + k > 'Z') {
					int tmp = (int) (ch - a);
					ch = (char) tmp;
				}
				ch += k;
			} else if (ch >= 'a' && ch <= 'z') {
				if (ch + k > 'z') {
					int tmp = (int) (ch - a);
					ch = (char) tmp;
				}
				ch += k;
			}

			sb.append(ch);

		}
		return sb.toString();
	}

}

public class Solution {
	public static void main(String[] args) {
		System.out.println(Result.caesarCipher("Zabcdefghijklmnopqrstuvwxyz-':", 27));
	}
}
