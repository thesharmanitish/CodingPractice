package com.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.interview.set.PowerSet;

/**
 * \
 * ["ATM","withdraw","withdraw","deposit","withdraw","withdraw","withdraw","deposit","deposit","deposit","deposit","deposit","withdraw","deposit","withdraw","withdraw","deposit","withdraw","deposit","deposit","deposit","deposit","deposit","withdraw","withdraw","deposit","deposit","withdraw","withdraw","deposit"]
 * [[],[75329590],[631369955],[[573861,522095,714533,492476,546097]],[450365875],[904221400],[218866420],[[436475,393954,886813,118753,978101]],[[783700,572445,515321,955370,741885]],[[341930,680951,109191,114867,949031]],[[509021,688157,630091,503505,810300]],[[653380,677561,215900,785755,606718]],[739610330],[[818314,820475,473020,577435,239453]],[655930425],[589310315],[[260981,487438,551962,809214,17595]],[271331715],[[41597,487402,481341,436242,787544]],[[213838,293302,198244,85456,421277]],[[472844,201439,746749,966314,316108]],[[135432,529298,740563,683999,502217]],[[864054,838876,415697,763324,182756]],[188361675],[42918510],[[469710,337534,855480,904490,155031]],[[705257,510243,223596,877527,338171]],[126584155],[704087790],[[489549,437633,85397,281851,410876]]]
 * Output:
 * [null,[-1],[-1],null,[-1],[-1],[-1],null,null,null,null,null,[-1],null,[-1],[-1],null,[-1],null,null,null,null,null,[-1],[-1],null,null,[-1],[2,1,0,1,1408175],null]
 * Expected:
 * [null,[-1],[-1],null,[-1],[-1],[1,0,0,2,437732],null,null,null,null,null,[-1],null,[-1],[-1],null,[-1],null,null,null,null,null,[-1],[-1],null,null,[-1],[2,1,0,1,1408175],null]
 * Stdout: 75329590 631369955 5 427625290 20 10 5 15 15 5 10 5 0
 * 
 * 
 * @author nisharma
 *
 */

class ATM {
	int[] denom = { 20, 50, 100, 200, 500 };
	long[] N = { 0, 0, 0, 0, 0 };

	public ATM() {

	}

	public void deposit(int[] banknotesCount) {
		int i = 0;
		for (int notes : banknotesCount)
			N[i++] += notes;
	}

	public int[] withdraw(int amount) {
		int[] res = { 0, 0, 0, 0, 0 };
		for (int i = 4; i >= 0; i--) {
			if (amount >= denom[i] && N[i] > 0) {
				res[i] = (int) Math.min(amount / denom[i], N[i]);
				amount -= denom[i] * res[i];

			}
		}
		if (amount != 0) {
			return new int[] { -1 };
		}
		int i = 0;
		for (int n : res)
			N[i++] -= n;
		return res;

	}
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */

/**
 * Your ATM object will be instantiated and called as such: ATM obj = new ATM();
 * obj.deposit(banknotesCount); int[] param_2 = obj.withdraw(amount);
 */
