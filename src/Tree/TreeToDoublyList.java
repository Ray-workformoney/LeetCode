package Tree;

import com.huangrui.leetcode.TreeNode;
/**
 * [剑指offer36] 二叉搜索树与双向链表
 * @author : huangrui
 * @version :
 * @date : 2022-02-12 21:32
 **/
public class TreeToDoublyList {

    TreeNode head;
    TreeNode tail;
    TreeNode pre;

    public TreeNode treeToDoublyList(TreeNode root) {

        if (root != null) {
            dfs(root);
            tail = pre;
            tail.right = head;
            head.left = tail;
        }
        return head;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (head == null) {
            head = node;
        } else {
            node.left = pre;
            pre.right = node;
        }
        pre = node;
        dfs(node.right);
    }
}
