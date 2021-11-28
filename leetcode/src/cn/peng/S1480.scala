package cn.peng

/**
 * Create by weiyupeng on 2021/8/28 8:00
 */
object S1480 {
    def runningSum(nums: Array[Int]): Array[Int] = {
        for (i <- 1 until nums.length) {
            nums(i) = nums(i) + nums(i - 1)
        }
        nums
    }
}
