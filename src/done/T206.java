package done;

import util.ListNode;

public class T206 {
	//迭代法反转
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode temp = null;
		
		while(curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		return prev;
    }
	
	//递归法反转
	public ListNode reverseList2(ListNode head) {
		//终止条件 当前节点为空或下个节点为空
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode curr = reverseList2(head.next);	//curr为递归得到的尾结点
		
		head.next.next = head;
		head.next = null;
		
		return curr;
    }

}
