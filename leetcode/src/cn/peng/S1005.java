package cn.peng;

import scala.Int;

import java.util.Arrays;

/**
 * Create by weiyupeng on 2021/12/3 19:28
 */
public class S1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int neg = 0;
        for (int num : nums) {
            if (num < 0) {
                neg++;
            }
        }
        int ans = 0;
        if (neg >= k) {
            for (int i = 0; i < nums.length; i++) {
                ans += i < k ? -nums[i] : nums[i];
            }
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Math.abs(nums[i]);
                ans += nums[i];
                min = Math.min(min, nums[i]);
            }
            if ((k - neg) % 2 == 1) {
                ans -= min * 2;
            }
        }
        return ans;
    }
}
