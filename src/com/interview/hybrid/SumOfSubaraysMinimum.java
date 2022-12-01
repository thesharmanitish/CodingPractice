package com.interview.hybrid;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 * 
 * 
 * 
 * 907. Sum of Subarray Minimums Medium 5.3K 362 company Amazon company
 * Microsoft company Dunzo
 * 
 * Given an array of integers arr, find the sum of min(b), where b ranges over
 * every (contiguous) subarray of arr. Since the answer may be large, return the
 * answer modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [3,1,2,4] Output: 17 Explanation: Subarrays are [3], [1], [2],
 * [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. Minimums are 3, 1, 2,
 * 4, 1, 1, 2, 1, 1, 1. Sum is 17.
 * 
 * Example 2:
 * 
 * Input: arr = [11,81,94,43,3] Output: 444
 * 
 * @author nisharma
 *
 */
public class SumOfSubaraysMinimum {
	/**
	 *  Idea --> monotonic stack + dp
	 * 
	 * Create a dpdpdp array of the same size as the input array arrarrarr. All the
	 * elements are 0 by default.
	 * 
	 * Initialize an empty stack stackstackstack, which will contain a monotonically
	 * increasing stack.
	 * 
	 * For each of the elements at index iii in the array
	 * 
	 * Pop all the elements from the stack until the stack is empty or the top of
	 * the stack is smaller than the current element.
	 * 
	 * There are two cases
	 * 
	 * Stack is empty. This means the current element has no previous element
	 * smaller than itself.
	 * 
	 * dp[i]=(i+1)∗arr[i]dp[i] = (i + 1) * arr[i]dp[i]=(i+1)∗arr[i]
	 * 
	 * Stack is not empty. The top of the stack represents the index of the previous
	 * smaller element. Let's call it jjj.
	 * 
	 * dp[i]=dp[j]+(i−j)∗arr[i]dp[i] = dp[j] + (i - j) *
	 * arr[i]dp[i]=dp[j]+(i−j)∗arr[i]
	 * 
	 * At the end, we sum all the elements of the dpdpdp array to get the answer.
	 * 
	 * The process is explained in the slideshow below.
	 * 
	 * @param arr
	 * @return
	 */
	public int sumSubarrayMins(int[] arr) {
		int MOD = 1000000007;
		Stack<Integer> stack = new Stack<>();
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				dp[i] = (1 + i) * arr[i];
			} else {
				int prevSmaller = stack.peek();
				dp[i] = dp[prevSmaller] + (i - prevSmaller) * arr[i] % MOD;
			}
			stack.push(i);

		}
		long sum = 0;
		for (int i = 0; i < dp.length; i++) {
			sum += dp[i];
			sum %= MOD;
		}
		return (int) sum;

	}

	/* second approch */
	// long sum = 0;

	// Stack<Integer> stack = new Stack<>();
	// for(int i=0;i<=arr.length;i++){

	// while(!stack.isEmpty() && (arr.length ==i || arr[stack.peek()] >= arr[i])){
	// int mid = stack.pop();
	// int left = stack.isEmpty()?-1:stack.peek();
	// int right = i;

	// long s = (mid-left)*(right-mid)%MOD;
	// sum += s*arr[mid];
	// sum%=MOD;
	// }
	// stack.push(i);

	// }
	// return (int)sum;

	// }

	// public int checkBoundry(int[] arr, int i) {
	// int x = arr[i], len = 1, t = i, left = 0, right =0;
	// while(i+1 < arr.length && arr[++i]>=x)
	// right++;
	// while(t>=1 && arr[--t]>x)
	// left++;
	// len+=left+right;
	// len+=left*right;
	// return len;

	// }
}
