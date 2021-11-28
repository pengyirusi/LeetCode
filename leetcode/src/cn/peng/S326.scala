package cn.peng

/**
 * Create by weiyupeng on 2021/9/23 21:25
 */
object S326 {
    def isPowerOfThree(n: Int): Boolean = {
        if (n == 0) {
            false
        } else if (n == 1) {
            true
        } else if (n%3 == 0) {
            isPowerOfThree(n/3)
        } else {
            false
        }
    }
}