package dailytopic;

import util.ListNode;

public class T876 {
	//双指针
	public ListNode middleNode(ListNode head) {
		ListNode fast = head, slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;

    }
}
