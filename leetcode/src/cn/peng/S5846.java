package cn.peng;

/**
 * Create by weiyupeng on 2021/9/4 22:31
 */
public class S5846 {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] l2r = new int[n];
        l2r[0] = nums[0];
        int[] r2l = new int[n];
        r2l[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            l2r[i] = l2r[i-1] + nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            r2l[i] = r2l[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (l2r[i] == r2l[i]) {
                return i;
            }
        }
        return -1;
    }
}
