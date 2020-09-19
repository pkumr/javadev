public class LinkedListAddTwoNo{
//ListNode
public static class ListNode{
int val;
ListNode next;
public ListNode(int x){
this.val = x;
}
}

public ListNode addTwoNumbers(ListNode l1, ListNode l2){
ListNode dummy = new ListNode(0);
ListNode curr = dummy;
ListNode p = l1;
ListNode q = l2;
int carry = 0;
while(p != null && q != null){
int x = p == null? 0 : p.val;
int y = q == null? 0 : q.val;
int sum = x + y + carry;
carry = sum / 10;
curr.next = new ListNode(carry % 10);
curr = curr.next;
if(p != null) p = p.next;
if(q != null) q = q.next;
}
if(carry > 0){
curr.next  = new ListNode(carry);
}
return dummy.next;
}
}
