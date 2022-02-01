package Tree;

import com.huangrui.leetcode.TreeNode;
/**
 * [剑指offer28] 对称的二叉树
 * @author : huangrui
 * @version :
 * @date : 2022-02-01 22:35
 **/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return symmetric(left.left, right.right) && symmetric(right.left, left.right);
    }

}
