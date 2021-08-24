/**
 * Create by weiyupeng on 2021/8/3 19:43
 */
public class S581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        l2r[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > l2r[i - 1]) {
                l2r[i] = nums[i];
            } else {
                l2r[i] = l2r[i - 1];
            }
        }
        r2l[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < r2l[i + 1]) {
                r2l[i] = nums[i];
            } else {
                r2l[i] = r2l[i + 1];
            }
        }

        boolean[] mark = new boolean[n];
        boolean need = false;
        for (int i = 0; i < n; i++) {
            if (l2r[i] > nums[i] || r2l[i] < nums[i]) {
                mark[i] = true;
                need = true;
            }
        }

        if (!need) {
            return 0;
        }

        int s = -1, e = -1;
        for (int i = 0; i < n; i++) {
            if (mark[i]) {
                s = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (mark[i]) {
                e = i;
                break;
            }
        }

        return e - s + 1;
    }
}
