package LinkList;

import java.util.Stack;
import Common.ListNode;
/**
 * [剑指offer06]从尾到头打印链表
 * @author : huangrui
 * @version :
 * @date : 2022-01-10 15:22
 **/
public class ReversePrint {

    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
            len++;
        }
        int[] res = new int[len];
        for (int i = 0; !stack.isEmpty(); i++) {
            int n = stack.pop();
            res[i] = n;
        }
        return res;
    }
}
