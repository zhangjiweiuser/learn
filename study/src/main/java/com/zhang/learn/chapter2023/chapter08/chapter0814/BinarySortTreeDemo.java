package com.zhang.learn.chapter2023.chapter08.chapter0814;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-14 17:26
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        int[] arr = {7,3,10,12,5,1,9};
        for(int i=0;i<arr.length;i++){
            tree.add(new Node(arr[i]));
        }
        tree.infixOrder();
    }
}
class BinarySortTree{
    private Node root;

    public void add(Node node){
        if(null == root){
            root = node;
        }else{
            root.add(node);
        }
    }
    public void infixOrder(){
        if(null != root){
            root.infixOrder();
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if(node == null){
            return;
        }
        if(this.value > node.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
}
