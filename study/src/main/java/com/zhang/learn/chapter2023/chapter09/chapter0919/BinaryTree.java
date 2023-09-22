package com.zhang.learn.chapter2023.chapter09.chapter0919;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 10:09
 */
public class BinaryTree {
    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        Node node = build(arr, 0, arr.length - 1);
        System.out.println(node);
    }

    public static Node build(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node root = new Node(arr[mid]);
        root.left = build(arr, left, mid - 1);
        root.right = build(arr, mid + 1, right);
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}
