package LinkList;

import Common.ListNode;
import Common.PrintUtils;

/**
 * @author huangrui
 */
public class ReverseList3 {

    /**
     * 循环写法
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        while (head != null) {
           ListNode next = head.next;
           head.next = pre;
           pre = head;
           head = next;
        }
        return pre;
    }

    /**
     * 递归写法
     */
    public ListNode reverseListRecursion(ListNode head) {
       return head == null ? null : reverseRecursion(head, null);
    }

    private ListNode reverseRecursion(ListNode node, ListNode pre) {

        ListNode next = node.next;
        node.next = pre;
        if (next != null) {
            return reverseRecursion(next, node);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ReverseList3 reverseList = new ReverseList3();
        PrintUtils.print(reverseList.reverseListRecursion(n1));

    }
}
