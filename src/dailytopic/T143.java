package dailytopic;

import util.ListNode;

public class T143 {
	//半分链表+右半反转+合并
    public void reorderList(ListNode head) {
        if (head == null) {
        	return;
        }
        
        ListNode mid = middleNode(head);	//mid节点为中间节点前一个节点
        ListNode left = head;
        ListNode right = mid.next;
        
        mid.next = null;
        right = reverseList(right);
        
        ListNode temp1, temp2;
        while(left != null && right != null) {
        	temp1 = left.next;
        	temp2 = right.next;
        	
        	left.next = right;
        	left = temp1;
        	
        	right.next = left;
        	right = temp2;
        }
    }
    
    //反转链表
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
    
    //找到中间节点 返回中间节点前一个节点
    public ListNode middleNode(ListNode head) {
		ListNode fast = head, slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;

    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
