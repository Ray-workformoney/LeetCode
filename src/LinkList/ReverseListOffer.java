package LinkList;

import java.util.Stack;
import Common.ListNode;
import Common.PrintUtils;
/**
 * [剑指offer24]反转链表
 * @author : huangrui
 * @version :
 * @date : 2022-01-25 16:05
 **/
public class ReverseListOffer {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode iter = head;
        ListNode next = head.next;
        while (iter != null) {
            iter.next = pre;
            pre = iter;
            iter = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;
    }

    public ListNode reverseListStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode iter;
        ListNode pre = stack.pop();
        head = pre;
        while (!stack.isEmpty()) {
            iter = stack.pop();
            iter.next = null;
            pre.next = iter;
            pre = iter;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ReverseListOffer reverseListOffer = new ReverseListOffer();
        PrintUtils.print(reverseListOffer.reverseListStack(l4));
    }
}
