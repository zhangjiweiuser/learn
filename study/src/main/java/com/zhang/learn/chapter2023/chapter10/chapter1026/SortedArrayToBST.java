package com.zhang.learn.chapter2023.chapter10.chapter1026;

/**
 * 将一个有序数组转化成平衡二叉树
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(nums, 0, nums.length - 1);
        System.out.println(node);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
