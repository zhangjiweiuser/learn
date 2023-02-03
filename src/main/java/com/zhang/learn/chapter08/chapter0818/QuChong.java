package com.zhang.learn.chapter08.chapter0818;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/18 11:01
 */
public class QuChong {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 3, 4, 4};
//        int n = removeDuplicates(nums);
//        for (int i = 0; i < n; i++) {
//            System.out.println(nums[i]);
//        }
        ListNode listNode = init();
//        while(null != listNode){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ListNode newNode = deleteDuplicates(listNode);
        while (null != newNode) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 0, fast = 1;
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    private static ListNode init(){
        ListNode node = new ListNode(1);
        node = node.add(2);
        node = node.add(3);
        node = node.add(3);
        node = node.add(4);
        return node;
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
