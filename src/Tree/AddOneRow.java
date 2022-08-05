package Tree;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huangrui
 * @date: 2022/8/5
 */
public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        // offer root node to queue
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            // level order
            int len = queue.size();
            if (level == depth - 1) {
                // till depth - 1 level
                for (TreeNode t : queue) {
                    // create new level
                    TreeNode left  = new TreeNode(val);
                    left.left = t.left;
                    t.left = left;
                    TreeNode right = new TreeNode(val);
                    right.right = t.right;
                    t.right = right;
                }
                break;
            }
            for (int i = 0; i < len; i++) {
                // offer next level to queue
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            level++;
        }
        return root;
    }

    public TreeNode addOneRowDfs(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, 1, val, depth);
        return root;
    }

    private void dfs(TreeNode node, int level, int val, int depth) {
        if (node == null) {
            return;
        }
        if (level == depth - 1) {
            TreeNode left = new TreeNode(val);
            left.left = node.left;
            node.left = left;
            TreeNode right = new TreeNode(val);
            right.right = node.right;
            node.right = right;
            return;
        }
        if (node.left != null) {
            dfs(node.left, level + 1, val, depth);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, val, depth);
        }
    }


}
