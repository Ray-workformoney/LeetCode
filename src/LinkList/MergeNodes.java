package LinkList;

import com.huangrui.leetcode.ListNode;
/**
 * [6013] 合并零之间的节点
 * @author : huangrui
 * @version :
 * @date : 2022-02-20 14:55
 **/
public class MergeNodes {

    class Solution {
        public ListNode mergeNodes(ListNode head) {

            ListNode itr = head;
            ListNode pre = null;
            while (itr != null) {
                int sum = 0;
                if (itr.val == 0) {
                    itr = itr.next;
                    while (itr != null && itr.val != 0) {
                        sum += itr.val;
                        itr = itr.next;
                    }
                    if (sum != 0) {
                        ListNode node = new ListNode(sum);
                        if (head.val == 0) {
                            head = node;
                        } else {
                            pre.next = node;
                        }
                        pre = node;
                    }
                } else {
                    itr = itr.next;
                }
            }
            return head;
        }
    }
}
