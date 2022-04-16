package com.interview.bit;

/**
 * 
 * https://doc.lagout.org/security/Hackers%20Delight.pdf
 * 
 * 
 * @author nisharma
 *
 */
public class BitCount {
	public static int bitCount(int i) {
		// HD, Figure 5-2
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		return i & 0x3f;
	}

	public static void main(String[] args) {
//		System.out.println(bitCount(511) );
//		System.out.println(signum(-1) );
		System.out.println(highestOneBit(10));
	}

	public static int signum(int i) {
		// HD, Section 2-7
		return (i >> 31) | (-i >>> 31);
	}

	public static int highestOneBit(int i) {
		i |= (i >> 1);
		i |= (i >> 2);
		i |= (i >> 4);
		i |= (i >> 8);
		i |= (i >> 16);
		return i - (i >>> 1);
	}
}
