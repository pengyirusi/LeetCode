package algorithm.array;

import java.util.*;

/**
 * Create by weiyupeng on 2021/8/11 8:18
 */
public class S446 {
    public int numberOfArithmeticSlices(int[] nums) {
        // dp[i][j] k,j,i
        int n = nums.length;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // putIfAbsent: 如果 key 不存在 则 put, return key
            map.putIfAbsent((long) nums[i], new ArrayList<>());
            map.get((long) nums[i]).add(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2 * (long) nums[j] - nums[i];
                if (map.containsKey(target)) {
                    for (int k : map.get(target)) {
                        if (k < j) {
                            dp[i][j] += dp[j][k] + 1;
                        }
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
