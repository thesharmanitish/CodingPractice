package com.interview.google;

/**
 * https://leetcode.com/problems/partition-list/
 * Given the head of a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,4,3,2,5,2], x = 3 Output: [1,2,2,4,3,5]
 * 
 * @author nisharma
 *
 */
public class PartitionList {
//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
	    public ListNode partition(ListNode head, int x) {
	        if(head ==null) 
	            return head;
	        ListNode rightroot = new ListNode(-1), prev = null, right = rightroot, root = head;
	        ListNode node = root;
	        while(root!=null){
	            if(root.val>= x){
	                right.next = root;
	                right = right.next;
	                root = root.next;
	                right.next = null;
	                
	            }else{
	                if(prev !=null)
	                    prev.next = root;
	                else 
	                    node =root;
	                prev = root;
	                root = root.next;
	            }
	            
	        }
	        rightroot = rightroot.next;
	        if(prev!=null)
	            prev.next = rightroot;
	        
	       return node;
	    }
	    
//	     public ListNode partition(ListNode head, int x) {
//	     ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
//	     ListNode smaller = smallerHead, bigger = biggerHead;
//	     while (head != null) {
//	         if (head.val < x) {
//	             smaller = smaller.next = head;
//	         } else {
//	             bigger = bigger.next = head;
//	         }
//	         head = head.next;
//	     }
//	     // no need for extra check because of fake heads
//	     smaller.next = biggerHead.next; // join bigger after smaller
//	     bigger.next = null; // cut off anything after bigger
//	     return smallerHead.next;
	// }
	}