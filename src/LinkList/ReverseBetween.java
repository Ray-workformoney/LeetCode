package LinkList;

import Common.ListNode;

/**
 * @program: LeetCode_J
 * @description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @author: huangrui
 * @create: 2020-11-19 10:52
 **/

public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode linkHead = new ListNode(-1);
        ListNode reversHead = new ListNode(-1);
        ListNode reversEnd = null;
        linkHead.next = head;
        ListNode pre = null, end = null;
        for (ListNode ln = linkHead; ln != null; ln = ln.next) {
            if (count + 1 == m) {
                //若下一个位置就是反转开始的位置,保存当前位置
                pre = ln;
            } else if (count - 1 == n) {
                //若前一个位置是反转结束的位置,保存当前位置
                end = ln;
            }
            if (count >= m && count <= n) {
                //若当前位置在需要反转的范围内
                ListNode tmp = new ListNode(ln.val);
                if (reversHead.next == null) {
                    //若是第一个元素
                    tmp.next = null;
                    reversEnd = tmp;
                } else {
                    //如果不是第一个元素
                    tmp.next = reversHead.next;
                }
                reversHead.next = tmp;
            }
            count++;
        }
        assert pre != null;
        pre.next = reversHead.next;
        assert reversEnd != null;
        reversEnd.next = end;
        return linkHead.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode thr = new ListNode(3);
        ListNode fou = new ListNode(4);
        ListNode fiv = new ListNode(5);
        one.next = two;
        two.next = thr;
        thr.next = fou;
        fou.next = fiv;
        fiv.next = null;
        ListNode r = ReverseBetween.reverseBetween(one, 1, 5);
        for (ListNode i = r; i != null; i = i.next) {
            System.out.print(i.val + " ");
        }
    }
}
