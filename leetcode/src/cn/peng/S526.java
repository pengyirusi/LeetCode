package cn.peng;

/**
 * Create by weiyupeng on 2021/8/16 8:33
 */
public class S526 {
    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int i = 1; i < (1 << n); i++) {
            int num = Integer.bitCount(i);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0 && ((num % (j + 1)) == 0 || (j + 1) % num == 0)) {
                    f[i] += f[i ^ (1 << j)];
                }
            }
        }
        return f[(1 << n) - 1];
    }
}
