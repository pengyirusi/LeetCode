package cn.peng

import scala.collection.immutable.Range

/**
 * Create by weiyupeng on 2021/9/1 8:31
 */
object S165 {
    def compareVersion(version1: String, version2: String): Int = {
        val v1: Array[String] = version1.split("\\.")
        val v2: Array[String] = version2.split("\\.")
        if (v1.length > v2.length) {
            return - compareVersion(version2, version1)
        }
        for (i <- v1.indices) {
            if (v1(i).toInt < v2(i).toInt) {
                return -1
            } else if (v1(i).toInt > v2(i).toInt) {
                return 1
            }
        }
        for (i <- v1.length until v2.length) {
            if (v2(i).toInt > 0) {
                return 1
            }
        }
        0
    }

    def main(args: Array[String]): Unit = {
        print(compareVersion("1","1.0.1"))
    }
}
