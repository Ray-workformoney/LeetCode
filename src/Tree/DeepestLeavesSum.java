package Tree;

import Common.TreeNode;

import java.util.*;

/**
 * [1302] Deepest Leaves Sum
 *
 * @author huangrui
 * @date 2022/8/17
 */
public class DeepestLeavesSum {

    int deepestSum = 0;
    int deepestLevel = -1;

    public int deepestLeavesSum(TreeNode root) {
/*        Map<Integer, Integer> sum = dfs(root, 0);
        return new ArrayList<>(sum.values()).get(0);*/
/*        dfs2(root, 0);
        return deepestSum;*/
        return bfs(root);
    }

    private Map<Integer, Integer> dfs(TreeNode t, int level) {
        if (t.left == null && t.right == null) {
            Map<Integer, Integer> result = new HashMap<>();
            result.put(level + 1, t.val);
            return result;
        }
        Map<Integer, Integer> leftSum = null, rightSum = null;
        if (t.left != null) {
            leftSum = dfs(t.left, level + 1);
        }
        if (t.right != null) {
            rightSum = dfs(t.right, level + 1);
        }
        if (leftSum == null) {
            return rightSum;
        } else if (rightSum == null) {
            return leftSum;
        } else {
            int leftLevel = new ArrayList<>(leftSum.keySet()).get(0);
            int rightLevel = new ArrayList<>(rightSum.keySet()).get(0);
            if (leftLevel == rightLevel) {
                rightSum.put(rightLevel, rightSum.get(rightLevel) + leftSum.get(leftLevel));
                return rightSum;
            } else if (leftLevel < rightLevel) {
                return rightSum;
            } else {
                return leftSum;
            }
        }
    }

    private void dfs2(TreeNode t, int level) {
        if (t == null) {
            return;
        }
        level = level + 1;
        dfs2(t.left, level);
        dfs2(t.right, level);
        if (t.left == null && t.right == null) {
            if (level == deepestLevel) {
                deepestSum += t.val;
            } else if (level > deepestLevel) {
                deepestSum = t.val;
                deepestLevel = level;
            }
        }
    }

    private int bfs(TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t);
        int res = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            res = 0;
            for (int i = 0; i < levelSize; i++) {
               TreeNode node = queue.poll();
               res += node.val;
               if (node.left != null) {
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   queue.offer(node.right);
               }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t7;
        t3.right = t6;
        t6.right = t8;
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        System.out.println(deepestLeavesSum.deepestLeavesSum(t1));
    }

}
