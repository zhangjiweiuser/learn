package com.zhang.learn.chapter2023.chapter08.chapter0817;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-17 16:12
 */
public class NodeDemo {
    public static void main(String[] args) {
        NodeUtil util = new NodeUtil();
        util.add(1);
        util.add(2);
        util.add(3);
        util.add(4);
        util.show();
//        util.deleteAtIndex(3);
//        System.out.println("--删除3后");
//        util.addAtHead(0);
//        System.out.println("----在头部添加0");
//        util.addAtIndex(2,5);
//        System.out.println("在3后面增加5");
//        util.show();
        // 测试反转
        Node reverse = util.reverse();
        System.out.println("测试反转");
        reverse.show();
    }
}

class NodeUtil {
    public Node root;

    public void add(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            root.add(val);
        }
    }

    public void show() {
        if (root == null) {
            System.out.println("没有数据");
        } else {
            root.show();
        }
    }

    public void del(int val) {
        if (null == root) {
            System.out.println("没有数据，无需删除");
        } else {
            Node node = root.del(val);
            root = node;
        }
    }

    public int get(int index) {
        if (root == null) {
            return -1;
        }
        Node tmp = root;
        int t = 1;
        while (tmp != null && t <= index) {
            t++;
            tmp = tmp.next;
        }
        if (tmp != null) {
            return tmp.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node tmp = new Node(val);
        tmp.next = root;
        root = tmp;
    }

    public void addAtTail(int val) {
        add(val);

    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        }
        if (null == root) {
            return;
        }
        Node tmp = root;
        int t = 1;
        while (tmp != null && t <= index) {
            tmp = tmp.next;
            t++;
        }
        if (tmp != null) {

            if (tmp.next == null) {
                tmp.next = new Node(val);
            } else {
                Node node = new Node(val);
                node.next = tmp.next;
                tmp.next = node;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || null == root) {
            return;
        }
        if(index == 0){
            root = root.next;
            return;
        }
        Node tmp = root;
        int t = 1;
        while (tmp != null && t < index) {
            tmp = tmp.next;
            t++;
        }
        if(tmp != null && tmp.next != null){
            tmp.next = tmp.next.next;
        }
    }

    public Node reverse(){
        if(root == null){
            return null;
        }
        Node pre = null;
        Node cur = root;
        while(cur != null){
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public void add(int val) {
        Node node = new Node(val);
        Node next = this;
        while (next.next != null) {
            next = next.next;
        }
        next.next = node;
    }

    public void show() {
        Node t = this;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
    }

    public Node del(int val) {
        Node root = this;
        while (root != null && root.val == val) {
            root = root.next;
        }
        if (root == null) {
            return null;
        }
        Node pre = root;
        Node cur = root.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return root;
    }
}
