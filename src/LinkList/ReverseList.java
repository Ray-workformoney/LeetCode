package LinkList;

import Common.ListNode;

import java.util.Stack;

/**
 * [206]反转链表
 *
 * @author : huangrui
 * @version :
 * @date : 2021-11-22 15:10
 **/
public class ReverseList {

    public ListNode reverseList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            ListNode temp = p;
            p = p.next;
            temp.next = null;
            stack.push(temp);
        }
        if (!stack.isEmpty()) {
            head = stack.pop();
        }
        ListNode end = head;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            end.next = temp;
            end = temp;
        }
        return head;
    }
}
