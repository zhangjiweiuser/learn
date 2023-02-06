package learn.chapter2022.chapter12.chapter1227;

import java.util.Stack;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-12-27 15:48
 */
public class NodeReverse {
    public static void main(String[] args) {
        Node node = build();
        Stack<Node> stack = new Stack();
        while (node != null) {
            System.out.println(node.value);
            stack.push(new Node(node.value));
            node = node.next;
        }
        Node temp = new Node(-1);
        Node root = temp;
        while (!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        Node nodet = root.next;
        while (nodet != null) {
            System.out.println(nodet.value);
            nodet = nodet.next;
        }
    }

    private static Node build() {
        int[] arr = {1, 2, 3, 4, 5};
        Node temp = new Node(-1);
        Node root = temp;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return root.next;

    }
}
