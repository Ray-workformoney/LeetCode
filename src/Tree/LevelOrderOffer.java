package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import Common.TreeNode;
/**
 * [剑指offer32]从上到下打印二叉树
 * @author : huangrui
 * @version :
 * @date : 2022-02-07 23:43
 **/
public class LevelOrderOffer {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelLen = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelLen; i++) {
               TreeNode node = queue.poll();
               level.add(node.val);
               if (node.left != null) {
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   queue.offer(node.right);
               }
            }
            res.add(level);
        }
        return res;
    }
}
