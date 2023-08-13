package com.zhang.learn.chapter2023.chapter08.chapter0811;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-11 16:43
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode jieidan1 = new HeroNode(1, "节点1");
        HeroNode jieidan2 = new HeroNode(2, "节点2");
        HeroNode jieidan3 = new HeroNode(3, "节点3");
        HeroNode jieidan4 = new HeroNode(4, "节点4");
        HeroNode jieidan5 = new HeroNode(5, "节点5");
        HeroNode jieidan6 = new HeroNode(6, "节点6");
        HeroNode jieidan7 = new HeroNode(7, "节点7");
        HeroNode jieidan8 = new HeroNode(8, "节点8");

        jieidan1.setLeft(jieidan2);
        jieidan1.setRight(jieidan3);
        jieidan3.setLeft(jieidan5);
        jieidan3.setRight(jieidan4);
        jieidan5.setLeft(jieidan6);
        jieidan5.setRight(jieidan7);
        jieidan4.setRight(jieidan8);
        BinaryTree tree = new BinaryTree();
        tree.setRoot(jieidan1);
//        System.out.println("前序遍历----------");
//        tree.preOrder();
//        System.out.println("中序遍历-----------");
//        tree.infixOrder();
//        System.out.println("后序遍历-----------");
//        tree.postOrder();
//        System.out.println(tree.preOrderSearch(3));
//        System.out.println(tree.infixOrderSearch(4));
//        System.out.println(tree.postOrderSearch(5));
        System.out.println("删除前，前序遍历");
        tree.preOrder();
        tree.delNode2(3);
        System.out.println("删除后，前序遍历");
        tree.preOrder();
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

    // 如果跟节点不为空，且根节点就是要删除的节点，则将根节点直接置空
    public void delNode(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("根节点为空，无法删除");
        }
    }

    public void delNode2(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                root = null;
            } else {
                this.root.delNode2(no);
            }
        } else {
            System.out.println("根节点为空，无法删除");
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

    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        }
        return null;
    }

    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        }
        return null;
    }

    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
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

    // 如果子节点是要删除的节点，则将子节点直接置为null，不管子节点是否还有其他孙子节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    // 如果子节点是要删除的节点，如果子节点后面没有孙子节点了，则直接删除子节点，
    // 如果只有一个孙子节点，让将孙子节点变为子节点
    // 如果左右孙子节点都存在，则将左孙子节点变为子节点，右孙子节点，变为原左孙子节点的右节点
    public void delNode2(int no) {
        if (this.left != null && this.left.no == no) {
            if (this.left.left == null && this.left.right == null) {
                this.left = null;
                return;
            } else if (this.left.left == null) {
                this.left = this.left.right;
                return;
            } else if (this.left.right == null) {
                this.left = this.left.left;
                return;
            } else {
                HeroNode rightTmp = this.left.right;
                this.left = this.left.left;
                HeroNode t = this.left;
                while(t.right != null){
                    t = t.right;
                }
                t.right = rightTmp;
                return;
            }
        }
        if (this.right != null && this.right.no == no) {
            if (this.right.left == null && this.right.right == null) {
                this.right = null;
                return;
            } else if (this.right.left == null) {
                this.right = this.right.right;
                return;
            } else if (this.right.right == null) {
                this.right = this.right.left;
                return;
            } else {
                HeroNode rightTmp = this.right.right;
                this.right = this.right.left;
                HeroNode t = this.right;
                while(t.right != null){
                    t = t.right;
                }
                t.right = rightTmp;
                return;
            }
        }
        if (this.left != null) {
            this.left.delNode2(no);
        }
        if (this.right != null) {
            this.right.delNode2(no);
        }
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
