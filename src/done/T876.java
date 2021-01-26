package done;

import util.ListNode;

public class T876 {
	//˫ָ�뷨
	public ListNode middleNode(ListNode head) {
		ListNode fast = head, slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;

    }
}
