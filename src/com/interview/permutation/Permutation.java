package com.interview.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/submissions/
 * 
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * Solution: Idea is to start from 1 >> 1 2| 2 1 >> 3 1 2 | 1 3 2 | 1 2 3 | 3 2
 * 1 | 2 3 1 | 2 1 3 via recursion
 * 
 * @author nisharma
 *
 */
public class Permutation {

	/**
	 * Iterative way to genearate permutation
	 * 
	 * 
	 * basic idea is, to permute n numbers, we can add the nth number into the
	 * resulting List<List<Integer>> from the n-1 numbers, in every possible
	 * position.
	 * 
	 * For example, if the input num[] is {1,2,3}: First, add 1 into the initial
	 * List<List<Integer>> (let's call it "answer").
	 * 
	 * Then, 2 can be added in front or after 1. So we have to copy the List in
	 * answer (it's just {1}), add 2 in position 0 of {1}, then copy the original
	 * {1} again, and add 2 in position 1. Now we have an answer of {{2,1},{1,2}}.
	 * There are 2 lists in the current answer.
	 * 
	 * Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position 0; then
	 * copy {2,1} and {1,2}, and add 3 into position 1, then do the same thing for
	 * position 3. Finally we have 2*3=6 lists in answer, which is what we want.
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permuteIterative(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> ll = new ArrayList<>();
		ll.add(nums[0]);
		res.add(ll);
		for (int i = 1; i <nums.length; i++) {   //element
			List<List<Integer>> tmp = new ArrayList<>();
			for (int j = 0; j <=i; j++) {  //position
				for(List<Integer> t: res) {   //list
					List<Integer> new_l = new ArrayList<Integer>(t);
					new_l.add(j, nums[i]);
					tmp.add(new_l);
				}
//				if(j>t.size())
//					return res;
				
			}
			res = tmp;
			
		}
		return res;
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		permute(nums, res, new ArrayList<Integer>(), 0);
		return res;
	}

	public static void permute(int[] nums, List<List<Integer>> res, List<Integer> suffix, int ind) {
		if (suffix.size() == nums.length) {
			res.add(suffix);
			return;
		}

		for (int i = 0; i <= suffix.size(); i++) {
			List<Integer> tmp = new ArrayList<>(suffix);
			tmp.add(i, nums[ind]);
			permute(nums, res, tmp, ind + 1);

		}
	}

	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3 };
		int[] arr = { 1, 1, 2 };
		System.out.println(permuteIterative(arr));
	}
}

