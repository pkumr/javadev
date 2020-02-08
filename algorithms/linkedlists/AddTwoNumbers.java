/*
 * 2. Add Two Numbers
 * 
 * Given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, 
 * except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
package com.pk.algorithms.linkedlists;

/**
 *
 * @author parveenkumar
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while(p != null || q != null){
            int x = 0;
            if(p != null){
                x = p.val;
            }
            int y = 0;
            if(q != null){
                y = q.val;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
