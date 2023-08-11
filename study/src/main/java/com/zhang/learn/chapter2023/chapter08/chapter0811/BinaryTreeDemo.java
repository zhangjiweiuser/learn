package com.zhang.learn.chapter2023.chapter08.chapter0811;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-11 16:43
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode songjiang = new HeroNode(1, "宋江");
        HeroNode wuyong = new HeroNode(2, "吴用");
        HeroNode lujunyi = new HeroNode(3, "卢俊义");
        HeroNode likui = new HeroNode(4, "李逵");
        HeroNode guansheng = new HeroNode(5, "关胜");

        songjiang.setLeft(wuyong);
        songjiang.setRight(lujunyi);
        lujunyi.setLeft(guansheng);
        lujunyi.setRight(likui);


        BinaryTree tree = new BinaryTree();
        tree.setRoot(songjiang);
//        System.out.println("前序遍历----------");
//        tree.preOrder();
//        System.out.println("中序遍历-----------");
//        tree.infixOrder();
//        System.out.println("后序遍历-----------");
//        tree.postOrder();
        System.out.println(tree.preOrderSearch(3));
        System.out.println(tree.infixOrderSearch(4));
        System.out.println(tree.postOrderSearch(5));
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
    }

    public HeroNode preOrderSearch(int no){
        if(this.root != null){
            return this.root.preOrderSearch(no);
        }
        return null;
    }

    public HeroNode infixOrderSearch(int no){
        if(this.root != null){
            return this.root.infixOrderSearch(no);
        }
        return null;
    }

    public HeroNode postOrderSearch(int no){
        if(this.root != null){
            return this.root.postOrderSearch(no);
        }
        return null;
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    // 前序
    public void preOrder() {
        System.out.println(this);
        // 递归向左子节点遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子节点遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序
    public void infixOrder() {

        // 递归向左子节点遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        // 递归向右子节点遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序
    public void postOrder() {

        // 递归向左子节点遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        // 递归向右子节点遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(no);
        }
        if (res != null) {
            return res;
        }

        if (this.right != null) {
            res = this.right.preOrderSearch(no);
        }
        return res;
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.infixOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            res = this.right.infixOrderSearch(no);
        }
        return res;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.postOrderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        return res;
    }
}
