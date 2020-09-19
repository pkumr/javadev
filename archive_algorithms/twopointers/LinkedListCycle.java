/*
 * 
 */
package com.pk.algorithms.twopointers;

/**
 *
 * @author parveenkumar
 */
public class LinkedListCycle {
    public static class ListNode {
      int val;
       ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        //Corner Cases
		if(head == null || head.next == null){
			return false;
		}
		//Slow Node that moves one step at a time
		ListNode slow = head;
		//Fast node that moves two steps
		ListNode fast = head.next;
		//While fast meet the slow in cycle
		while(slow != fast){
			//if there is no cycle, then fast will reach the end(null)
			if(fast == null || fast.next == null){
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
    }
}
