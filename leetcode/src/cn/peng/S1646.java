package cn.peng;

/**
 * Create by weiyupeng on 2021/8/23 8:41
 */
public class S1646 {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if ((1 & i) == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
                arr[1] = Math.max(arr[1], arr[i]);
            }
        }
        return arr[1];
    }
}
