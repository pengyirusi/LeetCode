package cn.peng

/**
 * Create by weiyupeng on 2021/9/4 8:33
 */
object SJZ10_1 {
    def fib(n: Int): Int = {
        if (n < 2) {
            return n
        }
        var a = 0
        var b = 1
        var c = 1
        for (_ <- 2 until n) {
            a = b
            b = c
            c = (a + b) % 1000000007
        }
        c
    }
}
