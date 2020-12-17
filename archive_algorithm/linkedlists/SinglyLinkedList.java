package com.pk.algorithms.linkedlists;

/**
 *
 * @author parveenkumar
 */
public class SinglyLinkedList {
    static class ListNode{
        int value;
        ListNode next; //pointer to self
        ListNode(int x){
            this.value = x;
            this.next = null;
        }
    }
    private ListNode head = null;
    public void addNode(int data){
        if(head == null){
            head = new ListNode(data);
        }else{
            ListNode curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new ListNode(data);
        }
    }
    public void reverseList(){
        if(head == null || head.next == null){
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
}
