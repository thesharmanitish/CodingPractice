package com.interview.google.list;

import java.util.Arrays;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeKLists {

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(), tmp = head;
		int[] arr = new int[lists.length];
		int min = Integer.MAX_VALUE, minInd = -1;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				arr[i] = lists[i].val;
				if (min > arr[i]) {
					min = arr[i];
					minInd = i;
				}
			} else
				arr[i] = Integer.MAX_VALUE;
		}
		while (lists[minInd] != null) {
			tmp.next = lists[minInd];
			lists[minInd] = lists[minInd].next;
			if (lists[minInd] != null) {
				arr[minInd] = lists[minInd].val;

			} else {
				arr[minInd] = Integer.MAX_VALUE;
				
			}
			tmp = tmp.next;
			tmp.next = null;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < lists.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					minInd = i;
				}

			}
		}
		return head.next;

	}

	public static void main(String[] args) {
		ListNode[] arr = new ListNode[3];
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(5);
		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		ListNode ln3 = new ListNode(2);
		ln3.next = new ListNode(6);
		arr[0] = ln1;
		arr[1] = ln2;
		arr[2] = ln3;
		System.out.println(mergeKLists(arr));
	}
}
