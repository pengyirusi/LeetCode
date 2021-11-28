package cn.peng

/**
 * Create by weiyupeng on 2021/9/6 19:51
 */
object S704 {
    def search(nums: Array[Int], target: Int): Int = {
        var l = 0
        var r = nums.length - 1
        while (l <= r) {
            val mid = (r - l) / 2 + l
            if (nums(mid) == target) {
                return mid
            }
            if (nums(mid) < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        -1
    }
}
