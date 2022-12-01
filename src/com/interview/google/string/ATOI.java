package com.interview.google.string;

public class ATOI {
	public static int myAtoi(String s) {
		int i = 0;
		boolean neg = false;
		for (char ch : s.toCharArray()) {
			if (ch == '-')
				neg = true;
			else if (ch > '0' && ch <= '9')
				break;
			else if (ch == ' ')
				continue;
			i++;
		}
		int num = 0;
		for (int j = i; j < s.length(); j++) {
			if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
				if ((num * 10 + s.charAt(j) - '0') < num)
					return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				num = num * 10 + s.charAt(j) - '0';
			} else
				break;
		}
		return neg ? -num : num;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("   -42"));
	}
}
