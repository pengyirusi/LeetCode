package cn.peng

/**
 * Create by weiyupeng on 2021/8/24 10:42
 */
object S1 {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map: Map[Int, Int] = Map()
        val len: Int = nums.length
        for (i: Int <- 0 until len) {
            if (map.contains(target-nums(i))) {
                return Array[Int](map(target - nums(i)), i)
            } else {
                map += (nums(i) -> i);
            }
        }
        null
    }
}
