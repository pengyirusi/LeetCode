import scala.collection.mutable

/**
 * Create by weiyupeng on 2021/9/17 21:39
 */
object S36 {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        for (elems <- board) {
            var set: Set[Char] = Set[Char]()
            for (elem <- elems) {
                if (elem != '.') {
                    if (set.contains(elem)) {
                        return false
                    }
                    set = set.+(elem)
                }
            }
        }
        for (j <- 0 to 8) {
            var set: Set[Char] = Set[Char]()
            for (i <- 0 to 8) {
                val c: Char = board(i)(j)
                if (c != '.') {
                    if (set.contains(c)) {
                        return false
                    }
                    set = set.+(c)
                }
            }
        }

        var sets: Array[mutable.Set[Char]] = Array.fill(9)(mutable.Set[Char]())

        for (i <- 0 to 8) {
            for (j <- 0 to 8) {
                if (board(i)(j) != '.') {
                    val block: Int = i / 3 * 3 + j / 3
                    if (sets(block).contains(board(i)(j))) {
                        return false
                    }
                    sets(block) = sets(block).+(board(i)(j))
                }
            }
        }
        true
    }
}
