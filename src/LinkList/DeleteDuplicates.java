/*给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
        示例 1:
        输入: 1->1->2
        输出: 1->2
        示例 2:
        输入: 1->1->2->3->3
        输出: 1->2->3*/
package LinkList;

import Common.ListNode;

public class DeleteDuplicates
{

    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode p;
        for (p = head; p != null; p = p.next)
        {
            if (p.next != null && p.val == p.next.val)
            {
                ListNode q = p.next;
                while (q != null && q.val == p.val)
                    q = q.next;
                p.next = q;
            }
        }
        return head;
    }
}
