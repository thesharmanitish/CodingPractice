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
	 * 
	 * Approach :
	 * 
	 * The height of a tree can be found by just going left. Let a single node tree
	 * have height 0. Find the height h of the whole tree. If the whole tree is
	 * empty, i.e., has height -1, there are 0 nodes.
	 * 
	 * Otherwise check whether the height of the right subtree is just one less than
	 * that of the whole tree, meaning left and right subtree have the same height.
	 * 
	 * If yes, then the last node on the last tree row is in the right subtree and
	 * the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of
	 * the left subtree plus the 1 root node plus recursively the number of nodes in
	 * the right subtree. If no, then the last node on the last tree row is in the
	 * left subtree and the right subtree is a full tree of height h-2. So we take
	 * the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus
	 * recursively the number of nodes in the left subtree.
	 * 
	 * Since I halve the tree in every recursive step, I have O(log(n)) steps.
	 * Finding a height costs O(log(n)). So overall O(log(n)^2).
	 */

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
