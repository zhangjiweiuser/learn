package com.zhang.learn.chapter2023.chapter08.chapter0822;

import java.util.ArrayList;
import java.util.List;

/**
 * 5
 * 4            6
 * 1    2
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-08-22 12:14
 */
public class BinaryNodeDemo {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node5.left = node4;
        node5.right = node6;
        node4.left = node1;
        node4.right = node2;
        TreeNodeUtil util = new TreeNodeUtil(node5);
        List<Integer> preLists = util.preOrder(node5);
        System.out.println("前序遍历:" + preLists);//5,4,1,2,6
        List<Integer> infixLists = util.infixOrder(node5);
        System.out.println("中序遍历:" + infixLists);// 1,4,2,5,6
        List<Integer> postLists = util.postOrder(node5);
        System.out.println("后序遍历:" + postLists); // 1,2,4,6,5
    }
}

class TreeNodeUtil {
    private TreeNode root;

    public TreeNodeUtil(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    /**
     * 中序遍历
     */
    public List<Integer> infixOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        infixOrder(root, result);
        return result;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    private void infixOrder(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        infixOrder(root.left, result);
        result.add(root.val);
        infixOrder(root.right, result);
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
