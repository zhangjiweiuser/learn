package com.zhang.learn.chapter2023.chapter08.chapter0813;

/**
 *               1
 *      2               3
 *  4       5    |   6       7
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        System.out.println("前序遍历"); // 1	2	4	5	3	6	7
        tree.preOrder();
        System.out.println("中序遍历"); // 4  2  5  1   6 3 7
        tree.infixOrder();
        System.out.println("后序遍历");// 4 5 2 6 7 3  1
        tree.postOrder();
    }

}
// 编写一个ArrBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree{
    private int[] arr;
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }
    // 数组结构二叉树前序遍历
    public void preOrder(int index){
        if(null == arr || arr.length == 0){
            System.out.println("数组为空，不能遍历");
            return;
        }
        System.out.print(arr[index]+"\t");
        if(2 * index + 1 < arr.length){
            preOrder(2 * index + 1);
        }
        if(2 * index + 2 < arr.length){
            preOrder(2 * index + 2);
        }
    }

    // 数组结构二叉树种序遍历
    public void infixOrder(int index){
        if(null == arr || arr.length == 0){
            System.out.println("数组为空，不能遍历");
            return;
        }
        if(2 * index + 1 < arr.length){
            infixOrder(2 * index + 1);
        }
        System.out.print(arr[index]+"\t");

        if(2 * index + 2 < arr.length){
            infixOrder(2 * index + 2);
        }
    }

    // 数组结构二叉树后序遍历
    public void postOrder(int index){
        if(null == arr || arr.length == 0){
            System.out.println("数组为空，不能遍历");
            return;
        }

        if(2 * index + 1 < arr.length){
            postOrder(2 * index + 1);
        }
        if(2 * index + 2 < arr.length){
            postOrder(2 * index + 2);
        }
        System.out.print(arr[index]+"\t");
    }
}
