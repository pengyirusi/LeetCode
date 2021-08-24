import scala.util.control.Exception

/**
 * Create by weiyupeng on 2021/8/24 11:24
 */
object S7 {
    def reverse(x: Int): Int = {
        var sign = 1
        var num: String = ""
        if (x < 0) {
            sign = -1
            num = x.toString.substring(1)
        } else {
            num = x.toString
        }
        val res: Long = num.reverse.toLong * sign
        if (res < Int.MinValue || res > Int.MaxValue) {
            return 0
        }
        res.toInt
    }
}
