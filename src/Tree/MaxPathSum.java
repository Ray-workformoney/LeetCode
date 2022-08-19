package Tree;

import Common.TreeNode;

/**
 * @author huangrui
 * @date 2022/8/19
 */
public class MaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int res = Math.max(node.val + Math.max(left, right), node.val);
        max = Math.max(max, Math.max(res, left + node.val + right));
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-3);
/*        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;*/
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(n1));
    }
}
