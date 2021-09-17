package LinkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * [1019]链表中的下一个更大节点
 * @author : huangrui
 * @version :
 * @date : 2021-09-17 11:40
 **/
public class NextLargerNodes {

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
     * 暴力解法
     * @param head
     * @return
     */
    public static int[] nextLargerNodes(ListNode head) {

        List<Integer> res = new ArrayList<>();
        ListNode i = head;
        while (i.next != null) {
            // 找到下一个比i.val大的元素
            ListNode j = i.next;
            while (j != null && j.val <= i.val) {
                j = j.next;
            }
            if (j == null) {
                res.add(0);
            } else {
                res.add(j.val);
            }
            i = i.next;
        }
        // 最后一个元素 肯定是0
        res.add(0);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 单调栈法
     * 构造单调递减栈
     * @param head
     * @return
     */
    public static int[] nextLargerNodesStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode c = head;
        int count = 0;
        // 遍历第一遍 获取链表长度
        while (c != null) {
            c = c.next;
            count++;
        }
        // 链表元素存到数组中
        int[] array = new int[count];
        for (int i = 0; head != null; head = head.next, i++) {
            array[i] = head.val;
        }
        // 存放结果
        int[] res = new int[count];
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) {
                // 若栈不为空 且当前元素大于栈顶元素
                // 栈顶元素出栈 对应结果为当前元素
                res[stack.pop()] = array[i];
            }
            stack.push(i);
        }
        // 最后还在栈中的元素 结果都为0
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, null);
        ListNode b = new ListNode(5, a);
        ListNode c = new ListNode(2, b);
        ListNode d = new ListNode(9, c);
        ListNode e = new ListNode(1, d);
        ListNode f = new ListNode(5, e);
        ListNode g = new ListNode(7, f);
        ListNode h = new ListNode(1, g);
        System.out.println(Arrays.toString(nextLargerNodesStack(h)));
    }
}
