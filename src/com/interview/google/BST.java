package com.interview.google;

public class BST {
	   static class Tree {
	        int data;
	        Tree left;
	        Tree right;
	        public Tree(int data){
	        	this.data = data;
	        }
	    }
	   public static void main(String[] args)
	    {

		   
		   Tree root = null;
	        root = insert(root, 20);
	        insert(root, 10);
	        insert(root, 5);
	        insert(root, 15);
	        insert(root, 30);
	        insert(root, 25);
	        insert(root, 35);
	        System.out.println("Inorder before Deleting the leaf Node. ");
	        inorder(root);
	        System.out.println();
	        root = leafDelete(root);
	        System.out.println("INorder after Deleting the leaf Node. ");
	        inorder(root);
	    }

	private static Tree  leafDelete(Tree root) {
		// TODO Auto-generated method stub
		if(root == null) return null;
		if(root.left==null && root.right ==null) {
			return null;
		}
		root.left = leafDelete(root.left);
		 root.right = leafDelete(root.right);
		 return root;
			
		
	}

	private static void inorder(Tree root) {
		// TODO Auto-generated method stub
		if(root == null) return ;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
		
	}

	private static Tree insert(Tree root, int i) {
		// TODO Auto-generated method stub
		if(root==null)
			root = new Tree(i);
		else if(root.data<i)
			root.right = insert(root.right,i);
		else 
			root.left =  insert(root.left,i);
		return root;
	}
}
