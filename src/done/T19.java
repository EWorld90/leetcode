package done;

import util.ListNode;

public class T19 {
	//双指针 一次遍历
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode first = head;
		ListNode second = dummy;
		
		for(int i = 0; i < n; i++) {
			first = first.next;
		}
		
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		
		second.next = second.next.next;
		
		return dummy.next;
    }

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = null;
		
		removeNthFromEnd(a, 5);
	}

}
