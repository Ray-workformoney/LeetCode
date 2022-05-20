/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807*/
package LinkList;

import Common.ListNode;

public class AddTwoNumbers {

    public static ListNode addTowNumbers(ListNode l1, ListNode l2){
          ListNode res, r, t1, t2;
          t1 = l1;
          t2 = l2;
          res = new ListNode(-1);
          r = res;
          res.next = null;
          int ci = 0;
          while (t1 != null && t2 != null){
              int temp;
              temp = t1.val + t2.val + ci;
              if (temp >= 10){
                  temp = temp % 10;
                  ci = 1;
              } else{
                  ci = 0;
              }
              ListNode t = new ListNode(temp);
              r.next = t;
              t.next = null;
              r = r.next;
              t1 = t1.next;
              t2 = t2.next;
          }
          ListNode t3 = (t1 == null) ? t2 : t1;
          while (t3 != null){
              int temp = t3.val + ci;
              if (temp >= 10){
                  temp = temp % 10;
                  ci = 1;
              } else{
                  ci = 0;
              }
              ListNode t = new ListNode(temp);
              r.next = t;
              t.next = null;
              r = r.next;
              t3 = t3.next;
          }
          if (ci != 0){
              ListNode t = new ListNode(1);
              r.next = t;
              t.next = null;
          }
          return res.next;
    }
}
