package com.interview.google;

public class MyCharacter {
	
	
	public static void main(String[] args) {
		testCharcter();
	}

	private static void testCharcter() {

		int[] ch = new int[128];
		
		
		String st = "nitish";
		
		for(char c:st.toCharArray()) {
			ch[c-'a'] = 1;
			
		}
		for(int i=0;i<ch.length;i++) {
			if(ch[i]!=0)
				System.out.println((char)(i+'a'));
		}
	}

}
