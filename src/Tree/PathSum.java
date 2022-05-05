package Tree;

import java.util.ArrayList;
import java.util.List;
import Common.TreeNode;
/**
 * [剑指offer34]二叉树中和为某一值的路径
 * @author : huangrui
 * @version :
 * @date : 2022-02-10 21:04
 **/
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            preOrder(root, res, path, 0, target);
        }
        return res;
    }

    private void preOrder(TreeNode node, List<List<Integer>> res, List<Integer> path, int sum, int target) {

        sum += node.val;
        List<Integer> thisPath = new ArrayList<>(path);
        thisPath.add(node.val);
        if (node.left != null) {
            preOrder(node.left, res, thisPath, sum, target);
        }
        if (node.right != null) {
            preOrder(node.right, res, thisPath, sum, target);
        }
        if (node.left == null && node.right == null) {
            if (sum == target) {
                res.add(thisPath);
            }
        }
    }
}
