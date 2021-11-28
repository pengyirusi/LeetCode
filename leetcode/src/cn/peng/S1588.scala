package cn.peng

/**
 * Create by weiyupeng on 2021/8/29 9:07
 */
object S1588 {
    def sumOddLengthSubarrays(arr: Array[Int]): Int = {
        val len: Int = arr.length
        for (i <- 1 until len) {
            arr(i) = arr(i) + arr(i - 1)
        }
        var res: Int = arr(len - 1)
        for (i <- 3 to len
             if i%2 == 1) {
            for (j <- i - 1 until len) {
                var left = 0
                if (j - i >= 0) {
                    left = arr(j - i)
                }
                res += arr(j) - left
            }
        }
        res
    }
}
