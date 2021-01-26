package done;

import java.util.*;

import util.ListNode;

public class T234 {
	//��������Ľⷨ
	public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // �������ֵ���Ƶ�������
        ListNode currNode = head;
        while (currNode != null) {
            vals.add(currNode.val);
            currNode = currNode.next;
        }

        // ʹ��˫ָ���ж��Ƿ����
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
