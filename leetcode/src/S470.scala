///**
// * Create by weiyupeng on 2021/9/5 9:03
// */
//object S470 extends Ran7 {
//
//    def rand10(): Int = {
//        var rand0to18: Int = 0
//        for (_ <- 1 to 6) {
//            rand0to18 += rand7() - 1
//        }
//        rand0to18 % 9 + 1
//    }
//
//}
//
//trait Ran7 {
//    def rand7(): Int = _
//}