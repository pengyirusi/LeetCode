import java.util.Arrays;

/**
 * Create by weiyupeng on 2021/9/22 21:39
 */
public class S725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int[] number = new int[k];
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int less = len / k;
        Arrays.fill(number, less);
        int pre = len - less * k;
        for (int i = 0; i < pre; i++) {
            number[i] ++;
        }
        cur = head;
        res[0] = head;
        for (int i = 0; i < number.length - 1; i++) {
            int j = number[i];
            while (--j > 0) {
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
            res[i + 1] = cur;
        }
        return res;
    }
}
