/*
 * 445. Add Two Numbers II
 * Given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, 
 * except the number 0 itself.
 * 
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
 */
package com.pk.algorithms.linkedlists;
import java.util.Stack;
/**
 *
 * @author parveenkumar
 */

public class AddTwoNumbersII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }
    //Approach - Using Stacks 
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        //Take two stacks to store values from List l1 and l2;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        //Iterate through l1 and l2 and add elements of both into stack s1 and s2
        while (l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        //variable to handle carry if addition result is more than 9.
        int carry = 0;
        //create a ListNode prev
        ListNode prev = null;
        //loop until stack s1 and s2 has values
        while (!s1.isEmpty() || !s2.isEmpty()){
            //variable to calculate sum of values node by node
            int sum = 0;
            if(!s1.isEmpty())
                sum += s1.pop().val;
            
            if(!s2.isEmpty())
                sum += s2.pop().val;
            
            sum += carry;
            //Mod function to create ListNode instance
            //if sum = 12, Mod(12, 10) = 2, ListNode value is 2
            //if sum = 9, Mod(9,10) = 9, ListNode value is 9

            //curr is ListNode (created) to store the result of addition of two numbers
            ListNode curr = new ListNode(sum % 10);
            //Current (curr) next is prev; curr.next is assigned null first time
            /*
            * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
            * First Iteration :-
            * 3+4 = 7 curr is created with node value of 7%10 = 7
            * prev == null --> curr.next = null | carry is 0 because sum < 10
            * prev becomes 7->null (prev = curr)
            *
            * Second Iteration :-
            * 6 + 4 = 10, curr is created with node value of 10%10 = 0
            * prev == 7->null, curr.next = 7->null | carry is 1
            * prev become 0->7->null
            *

            *
            * Third Iteration :-
            * 5 + 2 + 1(carry) = 8, curr is created with node value of 8%10 = 8
            * prev = 0->7->null, curr.next = prev = 0->7->null
            * prev becomes 8->0->7->null
            *
            * Fourth Iteration :-
            * sum = 7 + 6 = 13, curr is created with node value of 13%10 = 3
            * prev = 8->0->7->null, curr.next = prev = 8->0->7->null
            * prev = curr, prev becomes 3->8->0->7->null
            *
            * Since carry = 1, new curr is created with value 1,
            * curr.next = prev --> prev = 3->8->0->7->null
            * prev = curr, prev becomes 1->3->8->0->7->null
            *
            *
            * */

            curr.next = prev;
            //prev equals curr.
            prev = curr;
            carry = sum >=10? 1:0;
        }
        if(carry == 1){
            ListNode curr = new ListNode(1);
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
