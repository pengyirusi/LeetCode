/**
 * Create by weiyupeng on 2021/9/7 20:54
 */
object S1221 {
    def balancedStringSplit(s: String): Int = {
        val chs: Array[Char] = s.toCharArray
        var res = 0
        var balanced = 0
        for (i <- chs.indices) {
            if (chs(i) == 'L') {
                balanced += 1
            } else {
                balanced -= 1
            }
            if (balanced == 0) {
                res += 1
            }
        }
        res
    }
}
