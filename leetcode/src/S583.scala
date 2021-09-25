/**
 * Create by weiyupeng on 2021/9/25 17:02
 */
object S583 {
    private var map: Map[String, Int] = Map()
    def minDistance(word1: String, word2: String): Int = {
        var res = 0
        val key: String = word1 + "_" + word2
        if (map.contains(key)) {
            res = map(key)
        } else if (word1.isEmpty) {
            res = word2.length
        } else if (word2.isEmpty) {
            res = word1.length
        } else if (word1.charAt(0) == word2.charAt(0)) {
            res = minDistance(word1.substring(1), word2.substring(1))
        } else {
            res = 1 + Math.min(minDistance(word1.substring(1), word2),
                minDistance(word2.substring(1), word1))
        }
        map += (key -> res)
        res
    }
}
