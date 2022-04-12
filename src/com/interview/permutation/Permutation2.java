package com.interview.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutations-ii/
 * 
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * 
 * 
 * Input: nums = [1,1,2] Output: [[1,1,2], [1,2,1], [2,1,1]]
 * 
 * 
 * 
 * Solution: same as earlier duplicate can be removed via set, map, or withing
 * res(List) least time was observed via Map where key is saved as concatenation
 * of all numbers in permute
 * 
 * Another alternatives best solution is to skip permutation of duplicates
 * itself
 * 
 * @author nisharma
 *
 */
public class Permutation2 {

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

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		permute(nums, res, new ArrayList<Integer>(), 0);
		return res;
	}

	public List<List<Integer>> permuteOptimized(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, used, list, res);
		return res;
	}

	public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])  //skips already joined indexes not numbers
				continue;
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) // skip if first repeat is not used till now and second
				continue;										// wants
			list.add(nums[i]);
			used[i] = true;
			dfs(nums, used, list, res);
			used[i] = false;
			list.remove(nums[i]);

		}
	}

	static Map<String, String> set = new HashMap<>();

	/**
	 * Working Code with less performance
	 * 
	 * 
	 * @param nums
	 * @param res
	 * @param suffix
	 * @param ind
	 */
	public static void permute(int[] nums, List<List<Integer>> res, List<Integer> suffix, int ind) {
		if (suffix.size() == nums.length) {
			StringBuilder sb = new StringBuilder();
			for (Integer i : suffix)
				sb.append(i);
			// String s = suffix.stream().map(key -> key+"")
			// .collect(Collectors.joining(", "));
			if (set.get(sb.toString()) == null) {
				set.put(sb.toString(), "1");
				res.add(suffix);
			}
			return;
		}
		int num = nums[ind];
		for (int i = 0; i <= suffix.size(); i++) {
			List<Integer> ll = new ArrayList<>(suffix);
			ll.add(i, num);
			permute(nums, res, ll, ind + 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 3 };
//		System.out.println(permute(arr));
		System.out.println(new Permutation2().permuteOptimized(arr));
	}
}
