package com.zhang.learn.chapter2023.chapter03.chapter0307;

public class BTree {
    BTNode<Character> root;
    BTree(){
        root = null;
    }

    private BTNode<Character> findNode(BTNode<Character> t,char x){
        BTNode<Character> p;
        if(t == null || t.data == x){
            return t;
        }else{
            p = this.findNode(t.lchild,x);
            if(p != null){
                return p;
            }else{
                return this.findNode(t.rchild,x);
            }
        }
    }
    // 先序遍历
    private void preOrder(BTNode<Character> t){
        if(t != null){
            System.out.println(t.data);
            this.preOrder(t.lchild);
            this.preOrder(t.rchild);
        }
    }
    // 后续遍历
    private void postOrder(BTNode<Character> t){
        if(t != null){
            this.postOrder(t.lchild);
            this.postOrder(t.rchild);
            System.out.println(t.data);
        }
    }
    // 求二叉树中节点个数
    private int nodeCount(BTNode<Character> t){
        if(t == null){
            return 0;
        }else{
            return this.nodeCount(t.lchild) + this.nodeCount(t.rchild) + 1;
        }
    }
}
