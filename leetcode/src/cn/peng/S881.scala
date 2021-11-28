package cn.peng

/**
 * Create by weiyupeng on 2021/8/26 22:57
 */
object S881 {
    def numRescueBoats(people: Array[Int], limit: Int): Int = {
        val sorted: Array[Int] = people.sorted
        var i = 0
        var j = sorted.length - 1
        var res = 0
        while (i <= j) {
            if (sorted(i) + sorted(j) <= limit) {
                i += 1
            }
            j -= 1
            res += 1
        }
        res
    }
}
