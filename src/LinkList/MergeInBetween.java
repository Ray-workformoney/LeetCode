package LinkList;

import Common.ListNode;
import Common.PrintUtils;

/**
 * @author huangrui
 * @date 2023/1/30
 */
public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode itr1 = list1;
        ListNode begin = null;
        ListNode end = null;
        ListNode itr2 = list2;
        int c = 0;
        while (itr1 != null) {
           if (c == a - 1) {
              begin = itr1;
           }
           itr1 = itr1.next;
           if (c == b) {
              end = itr1;
              break;
           }
            c++;
        }
        if (begin == null || end == null) {
            return null;
        }
        begin.next = list2;
        while (itr2.next != null) {
           itr2 = itr2.next;
        }
        itr2.next = end;
        return list1;
    }

    public static void main(String[] args) {
        ListNode node10 = new ListNode(0);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);
        ListNode node15 = new ListNode(5);
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        ListNode node20 = new ListNode(1000000);
        ListNode node21 = new ListNode(1000001);
        ListNode node22 = new ListNode(1000002);
        node20.next = node21;
        node21.next = node22;

        MergeInBetween mergeInBetween = new MergeInBetween();
        PrintUtils.print(mergeInBetween.mergeInBetween(node10, 3, 4, node20));
    }
}
