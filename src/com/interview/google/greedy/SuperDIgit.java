package com.interview.google.greedy;

/**
 * 
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-recursive-digit-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-four
 * e define super digit of an integer using the following rules:
 * 
 * Given an integer, we need to find the super digit of the integer.
 * 
 * If has only digit, then its super digit is . Otherwise, the super digit of is
 * equal to the super digit of the sum of the digits of . For example, the super
 * digit of will be calculated as:
 * 
 * super_digit(9875) 9+8+7+5 = 29 super_digit(29) 2 + 9 = 11 super_digit(11) 1 +
 * 1 = 2 super_digit(2) = 2
 * 
 * @author nisharma
 *
 */
public class SuperDIgit {
	public static int superDigit(String n, int k) {
		// Write your code here
		int sum = 0;
		for (char c : n.toCharArray()) {
			sum += (int) c - '0';
		}
		int tmp = sum;

		while (tmp > 9) {
			sum = 0;
			String s = String.valueOf(tmp);
			for (char a : s.toCharArray()) {
				sum += (int) a - '0';
			}

			tmp = sum;
		}
		if (k == 1)
			return tmp;
		else {
			sum = tmp;
			while (k-- > 1) {
				sum += tmp;
			}
			return superDigit(String.valueOf(sum), 1);

		}

	}

	public static void main(String[] args) {
		superDigit("123", 1);
	}
}
