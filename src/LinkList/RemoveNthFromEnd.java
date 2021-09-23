package LinkList;

import java.util.HashMap;
import java.util.Map;
/**
 * [19]删除链表的倒数第N个节点
 * @author : huangrui
 * @version :
 * @date : 2021-09-23 15:39
 **/
public class RemoveNthFromEnd {

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 用一个map记录位置
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer, ListNode> locationMap = new HashMap<>();
        ListNode t = head;
        int c = 1;
        while (t != null) {
            locationMap.put(c, t);
            c++;
            t = t.next;
        }
        int target = c - n;
        ListNode pre = locationMap.get(target - 1);
        ListNode next = locationMap.get(target + 1);
        if (pre == null) {
            head = next;
        } else {
            pre.next = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5, null);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(2, c);
        ListNode e = new ListNode(1, d);
        System.out.println(removeNthFromEnd(e, 2));
    }
}
