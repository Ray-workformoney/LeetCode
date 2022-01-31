package Tree;

import com.huangrui.leetcode.TreeNode;
/**
 * [剑指offer27]二叉树的镜像
 * @author : huangrui
 * @version :
 * @date : 2022-01-31 13:43
 **/
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
