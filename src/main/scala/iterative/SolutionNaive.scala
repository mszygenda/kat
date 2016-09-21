package iterative

import common.TextUtils

object SolutionNaive {
    def solution(str: String): Int = {
        calculateRadiusesNaive(str, Odd).sum +
        calculateRadiusesNaive(str, Even).sum
    }

    def calculateRadiusesNaive(str: String, palindromeType: PalindromeType): Array[Int] = {
        val radiuses = new Array[Int](str.size)

        for (idx <- 1 until str.size) {
            val radiusAtIdx = TextUtils.countMatchingChars(
                str,
                palindromeType.leftSide(idx),
                palindromeType.rightSide(idx)
            )
            radiuses.update(idx, radiusAtIdx)
        }

        radiuses
    }
}
