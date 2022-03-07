package com.interview.google;

import com.interview.google.PartitionList.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int m=n;
        if(head ==null)
            return head;
        if(head.next==null){
            if(n>1)
                return head;
            return head.next;
        }
        ListNode slow =head, fast =head;
        while(n-->0){
            fast=fast.next;
        }
        if(fast==null)
            return slow.next;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        
        return head;
        
    }
}