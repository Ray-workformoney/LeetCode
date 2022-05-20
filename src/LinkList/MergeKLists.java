/*合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
        示例:
        输入:
        [
        1->4->5,
        1->3->4,
        2->6
        ]
        输出: 1->1->2->3->4->4->5->6*/

package LinkList;

import Common.ListNode;

public class MergeKLists {

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode p, q, r;
        p = l1;
        q = l2;
        r = res;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                r.next = p;
                p = p.next;
                r = r.next;
            } else {
                r.next = q;
                q = q.next;
                r = r.next;
            }
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        res = res.next;
        return res;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0){
            return null;
        }
        if (len == 1){
            return lists[0];
        }
        ListNode result;
        result = merge(lists[0], lists[1]);
        for (int i = 2; i < len; i++){
            result = merge(result, lists[i]);
        }
        return result;
    }
}
