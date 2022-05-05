package Tree;

import java.util.HashMap;
import java.util.Map;
import Common.TreeNode;
/**
 * [剑指offer07]重建二叉树
 * @author : huangrui
 * @version :
 * @date : 2022-01-10 15:41
 **/
public class BuildTree {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    /**
     * 递归构造
     * @param preorder 前序遍历 前序遍历的遍历顺序就是根节点的访问顺序
     * @param preorderStart 前序遍历的开始位置
     * @param preorderEnd 前序遍历的结束位置
     * @param inorderStart 中序遍历的开始位置
     * @param inorderEnd 中序遍历的结束位置
     * @return
     */
    private TreeNode build(int[] preorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {

        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int index = indexMap.get(root.val);
        // 左子树
        // 前序遍历的开始位置就是当前元素的下一个元素位置
        // 前序遍历的结束位置就是当前元素的位置加上左子树的元素个数
        // 中序遍历的开始位置就是中序遍历中左子树的第一个元素的位置
        // 终须遍历的结束位置就是当前元素在中序遍历的位置
        root.left = build(preorder, preorderStart + 1, preorderStart + index - inorderStart, inorderStart, index);
        // 右子树
        // 前序遍历的开始位置就是当前元素位置加上左子树的长度再加1
        // 前序遍历的结束位置就是前序遍历数组最后一个元素的位置
        // 中序遍历的开始位置就是当前元素在中序遍历数组的下一个位置
        // 中序遍历的结束位置就是中序遍历数组的长度
        root.right = build(preorder, preorderStart + index - inorderStart + 1, preorderEnd, index + 1, inorderEnd);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode t = buildTree.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        System.out.println("");
    }
}
