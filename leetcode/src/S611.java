import java.util.Arrays;

/**
 * Create by weiyupeng on 2021/8/4 20:37
 */
public class S611 {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    res += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return res;
    }
}
