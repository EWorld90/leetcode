package dailytopic;

import java.util.*;

import util.ListNode;

public class T234 {
	//借助数组的解法
	public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currNode = head;
        while (currNode != null) {
            vals.add(currNode.val);
            currNode = currNode.next;
        }

        // 使用双指针判断是否回文
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
		// TODO 自动生成的方法存根

	}

}
