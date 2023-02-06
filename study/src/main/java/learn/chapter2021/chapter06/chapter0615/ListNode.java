package learn.chapter2021.chapter06.chapter0615;

import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/6/15 10:32
 */
@Data
public class ListNode {
    private int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
    }
}
