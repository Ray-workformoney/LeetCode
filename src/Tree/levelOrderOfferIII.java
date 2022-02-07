package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.huangrui.leetcode.TreeNode;
/**
 * [剑指offer32-III]从上到下打印二叉树
 * @author : huangrui
 * @version :
 * @date : 2022-02-08 00:01
 **/
public class levelOrderOfferIII {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int order = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelLen = queue.size();
            List<TreeNode> thisLevel = new ArrayList<>();
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.poll();
                thisLevel.add(node);
            }
            if (order == 0) {
                // 从左往右
                for (TreeNode t : thisLevel) {
                    level.add(t.val);
                    if (t.left != null) {
                        queue.offer(t.left);
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    }
                }
                order = 1;
            } else {
                // 从右往左
                for (TreeNode t : thisLevel) {
                    if (t.left != null) {
                        queue.offer(t.left);
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    }
                }
                int len = thisLevel.size();
                for (int i = len - 1; i >= 0; i--) {
                    level.add(thisLevel.get(i).val);
                }
                order = 0;
            }
            res.add(level);
        }
        return res;
    }
}
