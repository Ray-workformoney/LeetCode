package LinkList;

import com.huangrui.leetcode.ListNode;
/**
 * [剑指offer18]删除链表的节点
 * @author : huangrui
 * @version :
 * @date : 2022-01-24 15:27
 **/
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode pre = head;
        ListNode t = head;
        if (head.val == val) {
            head = head.next;
            return head;
        }
        while (t != null && t.val != val) {
            pre = t;
            t = t.next;
        }
        if (t != null) {
            pre.next = t.next;
        }
        return head;
    }
}
