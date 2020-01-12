public class _141_LinkedListCycle{
	//Approach - Two Pointers
	/*
	# Imagine two runners runnning on a track at different speed. What heepns when the track is actually
	# a circle

	# By considering two pointers at different speed - a slow pointer and a fast pointer. the slow
	# pointer moves one step at a time while the fast pointer moves two steps at a time.
	# If there is no cycle in the list, the fast pointer will eventually reach the end and we can
	# return fasle in this case.
	*/
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head){
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