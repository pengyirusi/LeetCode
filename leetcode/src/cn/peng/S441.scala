package cn.peng

/**
 * Create by weiyupeng on 2021/10/10 15:54
 */
object S441 {
    def arrangeCoins(n: Int): Int = {
        var step = 1
        var all: Int = n
        while (true) {
            all -= step
            if (all < 0) {
                return step
            }
            step += 1
        }
        step
    }
}
