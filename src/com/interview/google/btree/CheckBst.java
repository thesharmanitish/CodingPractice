package com.interview.google.btree;

import java.util.Stack;

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

public class CheckBst {


	private static Integer prev = null;
	public boolean isValidBSTIterative(TreeNode root) {
		   if (root == null) return true;
		   Stack<TreeNode> stack = new Stack<>();
		   TreeNode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.val <= pre.val) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
		}
	
	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (!isValidBST(root.left))
			return false;
		if (prev != null && prev >= root.val)
			return false;
		prev = root.val;
		if (!isValidBST(root.right))
			return false;
		return true;
	}
	public static void main(String[] args) {
		TreeNode t = new TreeNode(0);
		isValidBST(t);
	}
}
