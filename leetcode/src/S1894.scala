/**
 * Create by weiyupeng on 2021/9/10 20:13
 */
object S1894 {
    def chalkReplacer(chalk: Array[Int], k: Int): Int = {
        var kk = k
        while (kk >= 0) {
            for (i <- chalk.indices) {
                if (chalk(i) > kk) {
                    return i
                }
                kk -= chalk(i)
            }
        }
        -1
    }
}
