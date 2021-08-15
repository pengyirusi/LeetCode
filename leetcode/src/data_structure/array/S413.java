package data_structure.array;

/**
 * Create by weiyupeng on 2021/8/10 8:05
 */
public class S413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int res = 0;
        int cur = nums[1] - nums[0], num = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == cur) {
                num++;
            } else {
                res += num * (num - 1) / 2;
                cur = nums[i + 1] - nums[i];
                num = 1;
            }
        }
        res += num * (num - 1) / 2;
        return res;
    }
}
