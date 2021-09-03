/**
 * Create by weiyupeng on 2021/9/2 19:46
 */
object S22 {
    def getKthFromEnd(head: ListNode, k: Int): ListNode = {
        var map: Map[Int, ListNode] = Map()
        var i = 0
        var cur: ListNode = head
        while (cur != null) {
            i += 1
            map += (i -> cur)
            cur = cur.next
        }
        map(i - k + 1)
    }
}
