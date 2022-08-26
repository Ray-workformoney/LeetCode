package Tree;

import Common.TreeNode;

import java.util.regex.Pattern;

/**
 * @author huangrui
 * @date 2022/8/19
 */
public class LowestCommonAncestor {

    boolean foundP = false, foundQ = false;
    TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if ((foundP && foundQ) || node == null) {
            return;
        }
        dfs(node.left, p, q);
        dfs(node.right, p, q);
        if (!foundP && node == p) {
            foundP = true;
        }
        if (!foundQ && node == q) {
            foundQ = true;
        }
        if (foundP && foundQ && ancestor == null) {
            ancestor = node;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(n1, n2, n3).val);
    }
}
