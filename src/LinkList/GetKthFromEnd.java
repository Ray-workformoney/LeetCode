package LinkList;

import Common.ListNode;
/**
 * [剑指offer22]链表中倒数第k个节点
 * @author : huangrui
 * @version :
 * @date : 2022-01-25 15:40
 **/
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast!= null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
