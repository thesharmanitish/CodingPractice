package com.interview.google.btree;

public class KthSmallestElement {
	static int count = 0;

	public static int kthSmallest(TreeNode1 root, int k) {
		if (root == null)
			return -1;
		int left = kthSmallest(root.left, k);
		if (left != -1)
			return left;
		count++;
		if (count == k)
			return root.val;
		int right = kthSmallest(root.right, k);
		if (right != -1)
			return right;
		return -1;
	}

//[5,3,6,2,4,null,null,1]
	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(5);
		root.left = new TreeNode1(3);
		root.right = new TreeNode1(6);
		root.left.left = new TreeNode1(2);
		root.left.right = new TreeNode1(4);
		root.left.left.left = new TreeNode1(1);

		kthSmallest(root, 3);
	}

}

class TreeNode1 {

	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1() {
	}

	TreeNode1(int val) {
		this.val = val;
	}

	TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
