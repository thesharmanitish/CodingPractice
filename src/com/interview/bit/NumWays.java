package com.interview.bit;

public class NumWays {
	public static long numberOfWays(String s) {
//		for(int i=0;i<s.length();i++)
			numberOfWays(s, 0, false);
		return num;
	}

	static int counter = 2;
	static long num = 0;

	public static void numberOfWays(String s, int start, boolean flag) {
		int j = start + 1;
		while (j < s.length()) {

			if ((s.charAt(start) ^ s.charAt(j)) == 1) {
				counter--;
				if (counter == 0) {
					num++;
					counter++;
					continue;
				}
				numberOfWays(s, j, !flag);

			}
			j++;

		}
		counter++;

	}

	public static void main(String[] args) {
		System.out.println(numberOfWays("001101"));
	}
}
