package com.zhang.learn.chapter2023.chapter08.chapter0814;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-14 17:26
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 0};
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        tree.infixOrder();
        tree.delNode(10);
        System.out.println("删除后，中序遍历");
        tree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (null == root) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (null != root) {
            root.infixOrder();
        }
    }

    public Node search(int value) {
        if (null == root) {
            return null;
        }
        return root.search(value);
    }

    public Node searchParent(int value) {
        if (null == root) {
            return null;
        }
        return root.searchParent(value);
    }

    /**
     * @param node 传入的结点(当作二叉排序树的根结点)
     * @return 返回的以node为根节点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    // 删除结点
    public void delNode(int value) {
        if (null == root) {
            return;
        }
        // 1. 先找到要删除的结点
        Node targetNode = search(value);
        if (null == targetNode) {
            return;
        }
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        Node parent = searchParent(value);
        // 如果删除的是叶子结点
        if (targetNode.left == null && targetNode.right == null) {
            // 判断要删除的结点是父结点是左子结点还是右子结点
            if (parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {
            // 说明要删除的结点有2颗子树
            /**
             * 1. 先找到要删除的结点，targetNode
             * 2. 找到targetNode的父结点，parent
             * 3. 从targetNode的右子树找到最小的结点
             * 4. 用一个临时变量，将最小结点的值保存，temp
             * 5. 删除该最小的结点
             * 6. targetNode.value = temp
             */
            int minVal = delRightTreeMin(targetNode.right);
            targetNode.value = minVal;
        } else { // 说明要删除的结点，只有一颗子树
            // 如果要删除的结点，有左子树
            if (targetNode.left != null) {
                // 如果targetNode 是parent的左子结点
                if (parent != null) {

                    if (parent.left != null && parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }
            } else {
                // 如果targetNode 是parent的右子结点
                if (parent != null) {
                    if (parent.left != null && parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                } else {
                    root = targetNode.right;
                }
            }
        }
    }
}

class Node {
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

    /**
     * @param value 希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            // 如果查找的值小于当前结点，向左子树递归查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            // 说明查找的值，大于等于当前结点，向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * @param value 需要删除的结点的值
     * @return 返回要删除结点的父结点
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果查找的值，小于当前结点的值，并且当前结点的左子结点不为空，则向左递归
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }

    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
