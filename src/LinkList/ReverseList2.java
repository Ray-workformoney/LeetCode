package LinkList;

import Common.ListNode;
/**
 * [206] Reverse Linked List
 * @author : huangrui
 * @version :
 * @date : 2022-02-17 16:29
 **/
public class ReverseList2 {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode pre = null, itr = head, next;
        while (itr != null) {
            if (pre == null) {
                // 第一个节点
                pre = itr;
                itr = itr.next;
                pre.next = null;
            } else {
                next = itr.next;
                itr.next = pre;
                pre = itr;
                itr = next;
            }
        }
        return pre;
    }
}
