package com.interview.google.btree;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * 
 * Given the root of a complete binary tree, return the number of the nodes in
 * the tree.
 * 
 * According to Wikipedia, every level, except possibly the last, is completely
 * filled in a complete binary tree, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2h nodes inclusive at the last
 * level h.
 * 
 * Design an algorithm that runs in less than O(n) time complexity.
 * 
 * @author nisharma
 *
 */
public class CountCompleteTreeNodes {
	/**
	 * Recursive Solution
	 * 
	 * @param root
	 * @return
	 */
	public int countNodesRec(TreeNode root) {
		int leftHeight = height(root);

		return leftHeight < 0 ? 0
				: height(root.right) == leftHeight - 1 ? (1 << leftHeight) + countNodes(root.right)
						: (1 << leftHeight - 1) + countNodes(root.left);

	}

	/**
	 * Iterative SOlution
	 * 
	 * @param root
	 * @return
	 */
	public int countNodes(TreeNode root) {
		int leftHeight = height(root);
		int res = 0;
		while (root != null) {
			if (height(root.right) == leftHeight - 1) {
				res += 1 << leftHeight;
				root = root.right;
			} else {
				res += 1 << leftHeight - 1;
				root = root.left;
			}
			leftHeight--;
		}
		return res;
	}

	/**
	 * Get height from left subtree
	 * 
	 * @param root
	 * @return
	 */
	public int height(TreeNode root) {
		if (root == null)
			return -1;
		return 1 + height(root.left);

	}
}
