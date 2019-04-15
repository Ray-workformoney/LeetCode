package LinkList;

public class DeleteDuplicates
{
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

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
