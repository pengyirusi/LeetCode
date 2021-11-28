package cn.peng;

/**
 * Create by weiyupeng on 2021/8/7 8:03
 */
public class S457 {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (helper(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean helper(int[] nums, int i) {
        int n = nums.length, slow = i, fast = i;
        do {
            slow = (nums[slow] + slow + n) % n;
            if (slow < 0) {
                slow += n;
            }
            fast = ((nums[fast] + fast + n) % n + n) % n;
            if (fast < 0) {
                fast += n;
            }
            fast = (nums[fast] + fast + n) % n;
            if (fast < 0) {
                fast += n;
            }
        } while (slow != fast);
        if (slow == (nums[slow] + slow + n) % n) {
            return false;
        }
        boolean pos = nums[slow] > 0;
        int k = 0;
        while (true) {
            int t = nums[slow];
            nums[slow] = 0;
            slow = (t + slow + n) % n;
            if (slow < 0) {
                slow += n;
            }
            k++;
            if (nums[slow] == 0) {
                break;
            }
            if (pos != (nums[slow] > 0)) {
                return false;
            }
        }
        return k > 1;
    }
}
