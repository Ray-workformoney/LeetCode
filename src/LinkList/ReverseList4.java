package LinkList;

import Common.ListNode;

/**
 * @author huangrui
 * @date 2022/8/16
 */
public class ReverseList4 {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode ptr = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode tmp = next;
            next = next.next;
            tmp.next = ptr;
            ptr = tmp;
        }
        head.next = null;
        return ptr;
        }
    }
