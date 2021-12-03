package com.huangrui.leetcode;

/**
 *
 * @author : huangrui
 * @version :
 * @date : 2021-12-02 20:47
 **/
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}