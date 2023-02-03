package com.zhang.learn.chapter2021.chapter06.chapter0610;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/10 10:23
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
