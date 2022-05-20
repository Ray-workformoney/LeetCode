package Common;

import java.util.*;

/**
 * @author huangrui
 * @since 2021-04-26
 */
public class PrintUtils {

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static <T> void print(List<List<T>> res) {
        if (res == null) {
            return;
        }
        for (List<T> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
        System.out.println();
    }

    public static void printInOrder(int[][] arr) {
        if (arr == null) {
            return;
        }
        List<int[]> list = new ArrayList<>(Arrays.asList(arr));
        list.sort(Comparator.comparing(ints -> ints[0]));
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        if (arr == null) {
            return;
        }
        for (int[] ints : arr) {
            print(ints);
        }
        System.out.println();
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static <T> void printList(List<T> nums) {
        System.out.println(Arrays.toString(nums.toArray()));
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != null) {
                System.out.print(t.val + " ");
                if (t.left != null || t.right != null) {
                    queue.add(t.left);
                    queue.add(t.right);
                }
            } else {
                System.out.print("null ");
            }
        }
    }
}
