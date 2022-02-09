package Tree;

/**
 * [剑指offer33]二叉搜索树的后序遍历序列
 * @author : huangrui
 * @version :
 * @date : 2022-02-08 22:39
 **/
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int begin, int end) {

        if (begin > end) {
            return true;
        }
        int i = begin;
        while (i < end && postorder[i] <= postorder[end]) {
            // 遍历 找到第一个比跟大的数 以此切分左右子树
            i++;
        }
        // 左子树 都比根节点小
        for (int j = begin; j < i; j++) {
            if (postorder[j] > postorder[end]) {
                return false;
            }
        }
        // 右子树 都比根节点大
        for (int j = i; j < end; j++) {
            if (postorder[j] < postorder[end]) {
                return false;
            }
        }
        // 递归判断左右子树
        return verify(postorder, begin, i - 1) && verify(postorder, i, end - 1);
    }

    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        System.out.println(verifyPostorder.verifyPostorder(new int[] {}));
    }
}
