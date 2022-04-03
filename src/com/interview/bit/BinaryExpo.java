package com.interview.bit;

public class BinaryExpo {
	public static void main(String[] args) {
		System.out.println(binExpIter(2,30));
		System.out.println(binExpRec(2,30));
	}
	public static int binExpIter(int a, int b) {
		int ans =1;
		while(b>0) {
			if((b&1) ==1) {
				ans = (ans*a);
			}
			a = a*a;
			b>>=1;
		}
		return ans;
	}
	public static int binExpRec(int a, int b) {
		if(a==1 || b==0)
			return 1;
		else if(b==1)
			return a;
		int res = binExpRec(a,b/2) * binExpRec(a,b/2) ; 
		
		if((b&1)==1)
			return a*res;
		else return res;
	}
}
