package com.interview.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * https://leetcode.com/problems/subsets 
 * 
 * Given an integer array nums of unique
 * elements, return all possible subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * 
 * 
 *                                        []
 *                     [][1]            [][2]                       [][3]
 *            [][1][12]  [][1][13]     [][2][23]                    [][3]
 *     [][1][12][123] [][1][13]        [][2][23]                    [][3]      
 *     
 *                  
 *                  
 * @author nisharma
 *
 */
public class PowerSet {
	public List<List<Integer>> subsetsIterative(int[] S) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int num : S) {
			List<List<Integer>> t = new ArrayList<>();
			for (int i = 0; i < res.size(); i++) {
				List<Integer> tmp = new ArrayList<>(res.get(i));
				tmp.add(num);
				t.add(tmp);
			}
			res.addAll(t);
		}
		return res;

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, res, new ArrayList<>(), 0);
		return res;
	}

	public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> ll, int ind) {
		res.add(new ArrayList<>(ll));
		for(int i= ind;i<nums.length;i++) {
			ll.add(nums[i]);
			backtrack(nums, res, ll, i+1);
			ll.remove(ll.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3 };
		System.out.println(new PowerSet().subsets(arr));
	}
}
