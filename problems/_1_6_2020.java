/*
 * 445	Add Two Numbers II	Linked List	Medium	1/6/2020
 * 384	Shuffle an Array		Medium	1/6/2020
 * 74	Search a 2D Matrix	ArrayBinary Search	Medium	1/6/2020
 * 281	Zigzag Iterator	Design	Medium	1/6/2020
 * 199	Binary Tree Right Side View	TreeDepth-first SearchBreadth-first Search	Medium	1/6/2020
 * 221	Maximal Square	Dynamic Programming	Medium	1/6/2020
 * */
package com.programming.problems.twenty;

import java.util.Stack;

public class _1_6_2020 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        //Data and Execution for #445
        //Create Linked List 1
        ListNode l1Node1 = new ListNode(7);
        ListNode l1Node2 = new ListNode(2);
        ListNode l1Node3 = new ListNode(4);
        ListNode l1Node4 = new ListNode(3);
        //Link the nodes
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;

        //Create Linked List 2
        ListNode l2Node1 = new ListNode(6);
        ListNode l2Node2 = new ListNode(5);
        ListNode l2Node3 = new ListNode(6);
        ListNode l2Node4 = new ListNode(4);
        //Link the nodes
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;
        l2Node3.next = l2Node4;

        ListNode result = new _1_6_2020().addTwoNumbers(l1Node1, l2Node1);
        while (result != null){
            System.out.println(result.val + "-->");
            result = result.next;
        }

    }

    //#445
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //basic checks
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //Two stacks are used to store values from l1 and l2.
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        //Iterate through l1 and l2 and add elements into stacks s1 and s2 respectively.
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        //variable (carry) to handle carry if addition result is more than 9.
        int carry = 0;

        //Create a list node prev (this will keep track of additions
        //Inialized as null
        ListNode prev = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            //variable (sum) to calculate sum of digits node by node
            int sum = 0;
            //Check both stacks for individual digits and add it to sum
            if (!s1.isEmpty())
                sum += s1.pop().val;

            if (!s2.isEmpty())
                sum += s2.pop().val;

            sum += carry;
            //Create ListNode to store the result of addition of digits.
            //Use Mod function  (with divisor as 10) to handle result, when sum > 9
            //if sum = 12, Mod(12, 10) = 2, ListNode value is 2
            //if sum = 9, Mod(9, 10) = 9, ListNode value is 9.
            ListNode curr = new ListNode(sum % 10);
            //current(curr) next node is prev, curr.next is null first time
            /*
             * Input : (7 -> 2 -> 4 -> 3) + (6 -> 5 -> 6 -> 4)
             * (calculation starts from right end moving towards left) starting from least significant digit
             *
             * First Iteration :-
             * 3 + 4 = 7, curr is created with node value of 7%10 = 7
             * prev = null --> curr.next = null
             * in next step -> prev becomes curr => prev == 7 -> null
             *
             * Second Iteration :-
             * 6 + 4 = 10, curr is created with node value of 10%10 = 0
             * prev = 7 -> null, curr value is 0,  curr.next = 7 -> null (prev) | carry is 1
             * in next step -> prev becomes curr => prev == 0 -> 7 -> null
             *
             * Third Iteration :-
             * 5 + 2 + 1(carry) = 8, curr is created with node value of 8%10 =8
             * prev = 0 ->7 -> null, curr value is 8, curr.next = 0 -> 7 -> null (prev)
             * in next step -> prev becomes curr => prev == 8 -> 0 ->7 -> null
             *
             * Fourth Iteration :-
             * 7 + 6 = 13, curr is created with node values of 13%10 = 3 | carry is 1
             * prev = 8 -> 0 -> 7 -> null, curr value is 3, curr.next = 8 -> 0 -> 7 -> null (prev)
             * in next step -> prev becomes curr => prev == 3 -> 8 -> 0 -> 7 -> null
             *
             * Since carry 1 is left and s1 and s2 are empty. after while loop, new curr is created.
             *
             * */
            curr.next = prev;
            prev = curr;
            carry = sum >= 10 ? 1 : 0;
        }
        /*
         * (this is the case, when carry is 1 after while loop completes)
         * curr is created with node value 1.
         * curr value is 1 and curr.next = prev, (prev == 3 -> 8 -> 0 -> 7 -> null)
         * prev = curr, ==> prev = 1 -> 3 -> 8 -> 0 -> 7 -> null is final result.
         *
         **/
        if (carry == 1) {
            ListNode curr = new ListNode(1);
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
