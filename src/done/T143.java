package done;

import util.ListNode;

public class T143 {
	//�������+�Ұ뷴ת+�ϲ�
    public void reorderList(ListNode head) {
        if (head == null) {
        	return;
        }
        
        ListNode mid = middleNode(head);	//mid�ڵ�Ϊ�м�ڵ�ǰһ���ڵ�
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
    
    //��ת����
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
    
    //�ҵ��м�ڵ� �����м�ڵ�ǰһ���ڵ�
    public ListNode middleNode(ListNode head) {
		ListNode fast = head, slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;

    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
