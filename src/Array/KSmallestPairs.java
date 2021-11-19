package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * [373]查找和最小的K对数字
 * @author : huangrui
 * @version :
 * @date : 2021-11-19 14:22
 **/
public class KSmallestPairs {

    private static class Node {
        int val1;
        int val2;
        int sum;

        Node(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
            this.sum = val1 + val2;
        }
    }


    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.sum));
        int nums1Len = Math.min(nums1.length, k);
        int nums2Len = Math.min(nums2.length, k);
        for (int i = 0; i < nums1Len; i++) {
            for (int j = 0; j < nums2Len; j++) {
                Node node = new Node(nums1[i], nums2[j]);
                queue.offer(node);
            }
        }
        int count = 0;
        while (!queue.isEmpty() && count < k) {
            List<Integer> pair = new ArrayList<>();
            Node node = queue.poll();
            pair.add(node.val1);
            pair.add(node.val2);
            res.add(pair);
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res =kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3);
        System.out.println(res);
    }
}
