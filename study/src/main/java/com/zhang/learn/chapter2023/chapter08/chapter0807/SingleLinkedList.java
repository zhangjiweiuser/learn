package com.zhang.learn.chapter2023.chapter08.chapter0807;

import java.util.Stack;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-07 9:50
 */
public class SingleLinkedList {
    public static void main(String[] args) {
//        SingleLinkedListDemo linkedList = new SingleLinkedListDemo();
////        System.out.println(linkedList.count());
//        linkedList.addHeroNode(new HeroNode(1, "刘备"));
//        linkedList.addHeroNode(new HeroNode(2, "关羽"));
//        linkedList.addHeroNode(new HeroNode(3, "张飞"));
//        linkedList.addHeroNode(new HeroNode(4, "诸葛亮"));
//        linkedList.addHeroNode(new HeroNode(5, "周瑜"));
//        linkedList.show();
        System.out.println("----------------");
//        linkedList.delLinkedList(4);
//        linkedList.show();
//        System.out.println("----------------");
//        linkedList.updateLinkedList(new HeroNode(3,"张飞2"));
//        linkedList.show();
//        System.out.println("============");
//        linkedList.addReOrder(new HeroNode(8,"吕布"));
//        linkedList.show();
//        System.out.println("----------------");
//        linkedList.addReOrder(new HeroNode(8,"吕布2"));
//        linkedList.show();
//        System.out.println("----------------");
//        linkedList.addReOrder(new HeroNode(4,"曹操"));
//        linkedList.show();
//        System.out.println(linkedList.count());
//        HeroNode heroNode = linkedList.findLastK(3);
//        System.out.println(heroNode);
//        HeroNode reverse = linkedList.reverse();
//        while(reverse != null){
//            System.out.println(reverse);
//            reverse = reverse.next;
//        }
//        linkedList.reverseByStack();

        SingleLinkedListDemo linkedList1 = new SingleLinkedListDemo();
//        System.out.println(linkedList.count());
        linkedList1.addHeroNode(new HeroNode(1, "刘备"));

        linkedList1.addHeroNode(new HeroNode(3, "张飞"));

        linkedList1.addHeroNode(new HeroNode(5, "周瑜"));

        SingleLinkedListDemo linkedList2 = new SingleLinkedListDemo();
        linkedList2.addHeroNode(new HeroNode(2, "关羽"));
        linkedList2.addHeroNode(new HeroNode(4, "诸葛亮"));

        merge(linkedList1.getHead(),linkedList2.getHead());


    }

    public static void merge(HeroNode heroNode1,HeroNode heroNode2){
        HeroNode result = new HeroNode(0,"");
        HeroNode tmp = result;
        HeroNode t1 = heroNode1.next;
        HeroNode t2 = heroNode2.next;
        while(t1 != null && t2 != null){
            if(t1.id <= t2.id){
                tmp.next = t1;
                t1 = t1.next;
                tmp = tmp.next;
            }else{
                tmp.next = t2;
                t2 = t2.next;
                tmp = tmp.next;
            }
        }
        if(t1 != null){
            tmp.next = t1;
        }
        if(t2 != null){
            tmp.next = t2;
        }
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode t = result;
        while (t.next != null) {
            t = t.next;
            System.out.println(t);
        }
    }
}

class SingleLinkedListDemo {
    private HeroNode head = new HeroNode(0, "");

    // 头节点只是为了查找方便，
    public HeroNode getHead() {
        return head;
    }

    // 添加节点
    public void addHeroNode(HeroNode heroNode) {
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = heroNode;
    }

    // 显示
    public void show() {
        // 判断链表是否为空
        if (head.next == null) {
            return;
        }
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp.toString());
        }
    }

    // 修改
    public void updateLinkedList(HeroNode heroNode) {
        if (head.next == null) {
            return;
        }
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            if (tmp.id == heroNode.id) {
                tmp.name = heroNode.name;
                return;
            }
        }
    }

    // 删除
    public void delLinkedList(int id) {
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        // 要先找到待删除节点的前一个节点
        while (tmp.next != null) {
            if (tmp.next.id == id) {
                tmp.next = tmp.next.next;
                return;
            } else {
                tmp = tmp.next;
            }
        }
    }

    public void addReOrder(HeroNode heroNode) {
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        boolean flag = false;
        while (tmp.next != null) {
            if (tmp.next.id < heroNode.id) {
                tmp = tmp.next;
            } else if (tmp.next.id == heroNode.id) {
                flag = true;
                break;
            } else {
                heroNode.next = tmp.next;
                tmp.next = heroNode;
                flag = true;
            }
        }
        if (!flag) {
            tmp.next = heroNode;
        }
    }

    // 因为我们是求链表的个数，涉及到遍历，
    public int count() {
        int count = 0;
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    // 查找单链表中倒数第K个节点
    public HeroNode findLastK(int k) {
        int count = count();
        if (k > count) {
            return null;
        }
        int t = 0;
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        while (t <= count - k) {
            tmp = tmp.next;
            t++;
        }
        return tmp;
    }

    // 反转链表
    public HeroNode reverse() {
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head;
        if(tmp.next == null || tmp.next.next == null){
            return tmp;
        }
        HeroNode reverseHead = new HeroNode(0,"");
        HeroNode next = null;
        tmp = tmp.next;
        while(tmp != null){
            next = tmp.next;
            tmp.next = reverseHead.next;
            reverseHead.next = tmp;
            tmp = next;
        }
        return reverseHead.next;
    }
    public void reverseByStack() {

        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode tmp = head.next;
        if(tmp == null || tmp.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        while(tmp != null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

class HeroNode {
    public int id;
    public String name;
    public HeroNode next;

    public HeroNode(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
