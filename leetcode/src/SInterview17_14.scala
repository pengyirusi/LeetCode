/**
 * Create by weiyupeng on 2021/9/3 20:35
 */
object SInterview17_14 {
    def smallestK(arr: Array[Int], k: Int): Array[Int] = {
        if (k == 0) {
            return new Array(0)
        }
        val sorted: Array[Int] = arr.sorted
        val res: Array[Int] = new Array[Int](k)
        for (i <- 0 until k) {
           res(i) = sorted(i)
        }
        res
    }
}