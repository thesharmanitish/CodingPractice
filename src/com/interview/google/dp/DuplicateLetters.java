package com.interview.google.dp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 * 
 * Given a string s, remove duplicate letters so that every letter appears once
 * and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "bcabc" Output: "abc"
 * 
 * Example 2:
 * 
 * Input: s = "cbacdcbc" Output: "acdb"
 * 
 * @author nisharma
 *
 */
public class DuplicateLetters {
	public static String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] count = new int[26];
		char[] arr = s.toCharArray();
		for (char c : arr) {
			count[c - 'a']++;
		}
		boolean[] visited = new boolean[26];
		for (char c : arr) {
			count[c - 'a']--;

			if (visited[c - 'a'])
				continue;

			while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
				visited[stack.pop() - 'a'] = false;
			}
			stack.push(c);

			visited[c - 'a'] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] peek = { 2, 1, 1, 5, 6, 2, 3, 1 };
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}

}
