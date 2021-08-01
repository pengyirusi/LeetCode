package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Create by weiyupeng on 2021/8/1 9:59
 */
public class S1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        int m = mat.length, n = mat[0].length;
        int[][] numberWithIndex = new int[m][2];
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    num++;
                } else {
                    break;
                }
            }
            numberWithIndex[i][0] = num;
            numberWithIndex[i][1] = i;
        }
        Arrays.sort(numberWithIndex, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < k; i++) {
            res[i] = numberWithIndex[i][1];
        }
        return res;
    }
}
