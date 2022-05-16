package Tree;

import Common.PrintUtils;
import Common.TreeNode;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 *
 * 提示：
 *
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author rayyhuang
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 先处理根节点
        root1.val = root1.val + root2.val;
        merge(root1.left, root2.left, root1, "left");
        merge(root1.right, root2.right, root1, "right");
        return root1;
    }

    /**
     * 层序遍历
     * @param r1
     * @param r2
     * @param r1P
     * @param type
     */
    private void merge(TreeNode r1, TreeNode r2, TreeNode r1P, String type) {
        if (r1 == null && r2 == null) {
            return;
        }
        if (r2 == null) {
            return;
        }
        if (r1 == null) {
            if ("left".equals(type)) {
                r1P.left = r2;
            } else {
                r1P.right = r2;
            }
            return;
        }
        r1.val = r1.val + r2.val;
        merge(r1.left, r2.left, r1, "left");
        merge(r1.right, r2.right, r1, "right");
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(3);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(5);
        root1.left = node11;
        root1.right = node12;
        node11.left = node13;
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(3);
        TreeNode node23 = new TreeNode(4);
        TreeNode node24 = new TreeNode(7);
        root2.left = node21;
        root2.right = node22;
        node21.left = null;
        node21.right = node23;
        node22.left = null;
        node22.right = node24;

        MergeTrees mergeTrees = new MergeTrees();
        TreeNode res = mergeTrees.mergeTrees(root1, root2);
        PrintUtils.print(res);
    }
}
