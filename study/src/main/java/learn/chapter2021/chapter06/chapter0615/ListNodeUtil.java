package learn.chapter2021.chapter06.chapter0615;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/15 10:34
 */
public class ListNodeUtil {

    private static ListNode nodeList;

    public static void main(String[] args) {
        init();
//        while (nodeList != null) {
//            System.out.println(nodeList.getVal());
//            nodeList = nodeList.next;
//        }

        ListNode rever = reverse(nodeList);
        System.out.println("---------");
        while (rever != null) {
            System.out.println(rever.getVal());
            rever = rever.next;
        }
    }

    private static ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private static void init() {
        ListNode node9 = new ListNode(9);
        ListNode node8 = new ListNode(8);
        node8.next = node9;
        ListNode node7 = new ListNode(7);
        node7.next = node8;
        ListNode node6 = new ListNode(6);
        node6.next = node7;
        ListNode node5 = new ListNode(5);
        node5.next = node6;
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        nodeList = node1;
//        while(node1 != null){
//            System.out.println( node1.getVal());
//            node1 = node1.next;
//        }

    }
}
