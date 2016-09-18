package common

object CalculationUtils {
    val sumWithDefaultLimit = sumWithLimit(100000000)(_, _)

    /**
      * Returns a sum of two positive integers unless the result is greater than limit
      * In that case it returns -1 (or when any of them is negative)
      */
    def sumWithLimit(limit: Int)(a: Int, b: Int) = {
        if (a + b > limit || math.min(a, b) < 0) { -1 } else { a + b }
    }
}
