package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import Common.TreeNode;
/**
 * [103] Binary Tree Zigzag Level Order Traversal
 * @author : huangrui
 * @version :
 * @date : 2022-02-17 17:32
 **/
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            int order = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int[] levelVal = new int[queue.size()];
                for (int i = 0; i < levelVal.length; i++) {
                    TreeNode node = queue.poll();
                    levelVal[i] = node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if (order == 0) {
                    // left to right
                    for (int j : levelVal) {
                        level.add(j);
                    }
                    order = 1;
                } else {
                    // right to left
                    for (int j = levelVal.length - 1; j >= 0; j--) {
                        level.add(levelVal[j]);
                    }
                    order = 0;
                }
                res.add(level);
            }
        }
        return res;
    }
}
