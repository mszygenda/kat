import iterative.{Even, Odd, Solution}

object PlayGround {
    def main(args: Array[String]): Unit = {
        /*println(Solution.solution("abba"))
        var str = "abbacabba"
        println(Solution.calculateRadiuses(0, str, new Array[Int](str.size), Even).toSeq)
*/
        val str = "zaaabcbaaacaaabcbaaaz"
        println(Solution.calculateRadiuses(0, str, new Array[Int](str.size), Odd).toSeq)
    }
}
