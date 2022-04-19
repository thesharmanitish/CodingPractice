package com.interview.google.bst;


/**
 * https://leetcode.com/problems/increasing-order-search-tree/submissions/
 * 
 * 
 * @author nisharma
 *
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class IncOrderSearchTree {
	public TreeNode increasingBST(TreeNode root) {
		return increasingBST(root, null);
	}

	public TreeNode increasingBST(TreeNode root, TreeNode next) {
		if (root == null)
			return next;
		root.right = increasingBST(root.right, next);
		TreeNode tmp = increasingBST(root.left, root);
		root.left = null;
		return tmp;
	}
	public static void main(String[] args) {
		 TreeNode t = new  TreeNode(2);
		 t.left = new TreeNode(1);
		 t.right = new TreeNode(3);
		 
		 new IncOrderSearchTree().increasingBST(t);
	}
}
