package cn.peng;

/**
 * Create by weiyupeng on 2021/9/22 21:42
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
