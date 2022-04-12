package com.interview.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/917/
 * 
 * 
 * @author nisharma
 *
 */
public class PalindromicPermutation3 {
	/**
	 * @param s: the given string
	 * @return: all the palindromic permutations (without duplicates) of it we will
	 *          sort your return value in output
	 */
	public List<String> generatePalindromes(String s) {
		int[] cha = new int[256];
		for (int i = 0; i < s.length(); i++) {
			cha[s.charAt(i)] += 1;
		}
		List<String> result = new LinkedList<String>();
		boolean odd = false;
		int oddIndex = 0;
		for (int i = 0; i < 256; i++) {
			if (cha[i] % 2 == 1) {
				if (odd == true) {
					return result;
				}
				oddIndex = i;
				odd = true;
			}
		}

		String base = "";
		if (odd == true) {
			base = (char) oddIndex + "";
			cha[oddIndex] -= 1;
		}
		process(base, cha, s.length(), result);
		return result;

	}

	private void process(String base, int[] cha, int n, List<String> result) {
		if (base.length() == n) {
			result.add(base);
			return;
		}

		for (int i = 0; i < 256; i++) {
			if (cha[i] == 0)
				continue;
			cha[i] -= 2;
			process((char) i + base + (char) i, cha, n, result);
			cha[i] += 2;

		}

	}
}
