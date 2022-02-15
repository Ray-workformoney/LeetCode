package LinkList;

import com.huangrui.leetcode.ListNode;
/**
 * [25] Reverse Nodes in k-Group
 * @author : huangrui
 * @version :
 * @date : 2022-02-15 23:00
 **/
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode iterator = head;
        ListNode pre = null;
        while(iterator != null) {
            ListNode begin = iterator, end;
            int i = 1;
            while(i < k && iterator != null) {
                iterator = iterator.next;
                i++;
            }
            if (i < k || iterator == null) {
                break;
            }
            end = iterator;
            iterator = iterator.next;
            if (pre == null) {
                head = reverse(begin, end);
            } else {
                pre.next = reverse(begin, end);
            }
            pre = begin;
        }
        return head;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode iterator = head;
        ListNode end = tail.next;
        ListNode pre = null, succ = null;
        while (iterator != end) {
            succ = iterator;
            if (pre == null) {
                pre = iterator;
                iterator = iterator.next;
                pre.next = end;
            } else {
                iterator = iterator.next;
                succ.next = pre;
                pre = succ;
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = reverseKGroup.reverseKGroup(node0, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
