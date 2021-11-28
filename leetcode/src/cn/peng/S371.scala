package cn.peng

/**
 * Create by weiyupeng on 2021/9/26 20:04
 */
object S371 {
    def getSum(a: Int, b: Int): Int = {
        if (b == 0) {
            a
        } else {
            getSum(a ^ b, (a & b)<<1)
        }
    }
}
