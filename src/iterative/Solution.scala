package iterative

import common.TextUtils
import common.CalculationUtils._

object Solution {
    def solution(str: String): Int = {
        sumWithDefaultLimit(
            calculateRadiuses(1, str, new Array[Int](str.size), Odd).foldLeft(0)(sumWithDefaultLimit),
            calculateRadiuses(1, str, new Array[Int](str.size), Even).foldLeft(0)(sumWithDefaultLimit)
        )
    }

    def calculateRadiuses(center: Int, str: String, radiuses: Array[Int], palindromeType: PalindromeType): Array[Int] = {
        if (center >= str.size) {
            radiuses
        } else {
            radiuses.update(center, TextUtils.countMatchingChars(
                str,
                palindromeType.leftSide(center) - radiuses(center),
                palindromeType.rightSide(center) + radiuses(center)
            ) + radiuses(center))

            val k = mirrorEasyCases(center, radiuses)

            calculateRadiuses(center + k, str, radiuses, palindromeType)
        }
    }

    /**
      * Mirrors maxium number of radiuses from the left side
      * and returns that number as a result (effectively next position to check)
      */
    private def mirrorEasyCases(center: Int, radiuses: Array[Int]): Int = {
        mirrorEasyCasesIter(1, center, radiuses);
    }

    private def mirrorEasyCasesIter(k: Int, center: Int, radiuses: Array[Int]): Int = {
        val radius = radiuses(center)

        if (k > radius || center + k == radiuses.size) {
            k
        } else if (radiuses(center - k) == radius - k) {
            radiuses.update(center + k, radius - k)
            k
        } else {
            radiuses.update(center + k, math.min(radiuses(center - k), radius - k))
            mirrorEasyCasesIter(k + 1, center, radiuses)
        }
    }
}