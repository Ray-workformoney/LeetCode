/*将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4*/

package LinkList;

public class mergeTwoLists 
{
	public class ListNode 
	{
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public static ListNode merge(ListNode l1, ListNode l2)
	{
		mergeTwoLists mt = new mergeTwoLists();
		ListNode res = mt.new ListNode(-1);
		ListNode p, q, r;
		p = l1;
		q = l2;
		r = res;
		while (p != null && q != null)
		{
			if (p.val <= q.val)
			{
				r.next = p;
				p = p.next;
				r = r.next;
			}
			else
			{
				r.next = q;
				q = q.next;
				r = r.next;
			}
		}
		if (p != null)
			r.next = p;
		if (q != null)
			r.next = q;
		res = res.next;
		return res;
	}

}
