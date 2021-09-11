import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by weiyupeng on 2021/9/11 9:09
 */
public class S600 {
    /*public int findIntegers(int n) {
        Set<Integer> set = generate11();
        Set<Integer> yes = new HashSet<>();
        int res = 0;
        for (int i = 0; i <= n; i++) {
            boolean can = true;
            for (Integer mask : set) {
                if (Integer.bitCount(mask & i) > 1) {
                    can = false;
                    break;
                }
            }
            if (can) {
                res++;
            }
        }
        return res;
    }*/

    private Set<Integer> generate11() {
        Set<Integer> set = new HashSet<>();
        int len = 32;
        char[] binChars = new char[len];
        Arrays.fill(binChars, '0');
        for (int i = 2; i < len; i++) {
            binChars[i] = '1';
            binChars[i-1] = '1';
            binChars[i-2] = '0';
            set.add(Integer.valueOf(String.valueOf(binChars), 2));
        }
        return set;
    }

    public int findIntegers(int n) {
        if (n < 3) {
            return n + 1;
        }
        int a = 1, len = 1;
        while (a <= n) {
            a *= 2;
            len++;
        }
        a /= 2;
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0] + (i-2 >= 0 ? dp[i-2][1] : 0);
        }
        int res = dp[len-1][0] + dp[len-1][1];
        Set<Integer> set = generate11();
        for (int i = a + 1; i <= n; i++) {
            boolean can = true;
            for (Integer mask : set) {
                if (Integer.bitCount(mask & i) > 1) {
                    can = false;
                    break;
                }
            }
            if (can) {
                res++;
            }
        }
        return res;
    }
}
