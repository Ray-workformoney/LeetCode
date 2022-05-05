package Tree;

import Common.TreeNode;
/**
 * [129]求根节点到叶节点数字之和
 * @author : huangrui
 * @version :
 * @date : 2021-12-02 20:46
 **/
public class SumNumbers {

    public static int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    private static int dfs(TreeNode t, int num) {

        if (t == null) {
            return 0;
        }
        int thisNum = num * 10 + t.val;
        if (t.left == null && t.right == null) {
            // 叶子节点
            return thisNum;
        }
        return dfs(t.left, thisNum) + dfs(t.right, thisNum);
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(6, null, null);
        TreeNode n2 = new TreeNode(5, null, null);
        TreeNode n3 = new TreeNode(1, null, n1);
        TreeNode n4 = new TreeNode(1, n2, n3);
        System.out.println(sumNumbers(n4));
    }
}
