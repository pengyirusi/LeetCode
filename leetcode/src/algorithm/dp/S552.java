package algorithm.dp;

/**
 * Create by weiyupeng on 2021/8/18 8:22
 */
public class S552 {
    public int checkRecord(int n) {
        int mod = 1000000007;

        // 1.只考虑没有 A 的情况

        int[] dp = new int[n <= 3 ? 4 : n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7; // LLL 不行

        // 1.1 以 P 结尾：dp[i] = dp[i - 1]
        // 1.1 以 L 结尾：dp[i] = dp[i - 1] - dp[i - 4]
        // so 加到一起
        for (int i = 4; i <= n; i++) {
            dp[i] = ((2 * dp[i - 1]) % mod + mod - dp[i - 4]) % mod;
        }
        int res = dp[n];

        // 2.加上 A 的情况

        // 1 ...... n
        // i-1个长度, A, n-i个长度
        // 两边排列组合做乘法
        for (int i = 1; i <= n; i++) {
            // 乘法有可能越界
            res = (res + (int)(((long) dp[i - 1] * dp[n - i]) % mod)) % mod;
        }
        return res;
    }
}
