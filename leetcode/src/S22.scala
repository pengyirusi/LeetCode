/**
 * Create by weiyupeng on 2021/9/2 19:46
 */
object S22 {
    def getKthFromEnd(head: ListNode2, k: Int): ListNode2 = {
        var map: Map[Int, ListNode2] = Map()
        var i = 0
        var cur: ListNode2 = head
        while (cur != null) {
            i += 1
            map += (i -> cur)
            cur = cur.next
        }
        map(i - k + 1)
    }
}
