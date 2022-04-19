package com.interview.google.btree;

public class KthSmallestElement2 {
	static int count = 0;

	public static int findSecondMinimumValue(TreeNode1 root) {
		return findSecondMinimumValue(root, null);
	}

	public static  int findSecondMinimumValue(TreeNode1 root, Integer max) {
		if (root == null)
			return -1;
		int res = findSecondMinimumValue(root.left, max);
		if (res != -1)
			return res;
		if (max == null)
			max = root.val;
		if (max < root.val)
			return root.val;
		res = findSecondMinimumValue(root.right, max);
		return res != -1 ? res : -1;

	}

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(5);
		root.right = new TreeNode1(8);
		root.right.left = new TreeNode1(5);
		findSecondMinimumValue(root);
	}
}
