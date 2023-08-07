package com.zhang.learn.chapter2023.chapter08.chapter0807;

import java.util.Stack;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-07 12:43
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedListDemo2 linkedList = new DoubleLinkedListDemo2();
        linkedList.addHeroNode(new HeroNode2(1, "刘备"));
        linkedList.addHeroNode(new HeroNode2(2, "关羽"));
        linkedList.addHeroNode(new HeroNode2(3, "张飞"));
        linkedList.addHeroNode(new HeroNode2(4, "诸葛亮"));
        linkedList.addHeroNode(new HeroNode2(5, "周瑜"));
        linkedList.show();
        System.out.println("-----");
        linkedList.updateLinkedList(new HeroNode2(4, "诸葛亮2"));
        linkedList.show();
        System.out.println("-----");
        linkedList.delLinkedList(3);
        linkedList.show();
        System.out.println("-----");
        linkedList.delLinkedList(5);
        linkedList.show();
        System.out.println("-----");

        linkedList.addReOrder(new HeroNode2(3,"张飞"));
        linkedList.show();
        System.out.println("-----");
    }
}

class DoubleLinkedListDemo2 {
    private HeroNode2 head = new HeroNode2(0, "");

    // 头节点只是为了查找方便，
    public HeroNode2 getHead() {
        return head;
    }

    // 添加节点
    public void addHeroNode(HeroNode2 heroNode) {
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = heroNode;
        heroNode.prev = tmp;
    }

    // 显示
    public void show() {
        // 判断链表是否为空
        if (head.next == null) {
            return;
        }
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.println(tmp);
        }
    }

    // 修改
    public void updateLinkedList(HeroNode2 heroNode) {
        if (head.next == null) {
            return;
        }
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head;
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
        HeroNode2 tmp = head.next;
        // 要先找到待删除节点的前一个节点
        while (tmp != null) {
            if (tmp.id == id) {
                tmp.prev.next = tmp.next;
                if (tmp.next != null) {
                    tmp.next.prev = tmp.prev;
                }
                return;
            } else {
                tmp = tmp.next;
            }
        }
    }

    public void addReOrder(HeroNode2 heroNode) {
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head;
        boolean flag = false;
        while (tmp.next != null) {
            if (tmp.next.id < heroNode.id) {
                tmp = tmp.next;
            } else if (tmp.next.id == heroNode.id) {
                flag = true;
                break;
            } else {
                tmp.next.prev = heroNode;
                heroNode.next = tmp.next;
                tmp.next = heroNode;
                heroNode.prev = tmp;
                flag = true;
            }
        }
        if (!flag) {
            tmp.next = heroNode;
            heroNode.prev = tmp;
        }
    }

    // 因为我们是求链表的个数，涉及到遍历，
    public int count() {
        int count = 0;
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    // 查找单链表中倒数第K个节点
    public HeroNode2 findLastK(int k) {
        int count = count();
        if (k > count) {
            return null;
        }
        int t = 0;
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head;
        while (t <= count - k) {
            tmp = tmp.next;
            t++;
        }
        return tmp;
    }

    // 反转链表
    public HeroNode2 reverse() {
        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head;
        if (tmp.next == null || tmp.next.next == null) {
            return tmp;
        }
        HeroNode2 reverseHead = new HeroNode2(0, "");
        HeroNode2 next = null;
        tmp = tmp.next;
        while (tmp != null) {
            next = tmp.next;
            tmp.next = reverseHead.next;
            reverseHead.next = tmp;
            tmp = next;
        }
        return reverseHead.next;
    }

    public void reverseByStack() {

        // 因为head节点是不能动的，因此我们需要一个辅助节点tmp
        HeroNode2 tmp = head.next;
        if (tmp == null || tmp.next == null) {
            return;
        }
        Stack<HeroNode2> stack = new Stack<>();
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

class HeroNode2 {
    public int id;
    public String name;
    public HeroNode2 prev;
    public HeroNode2 next;

    public HeroNode2(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
