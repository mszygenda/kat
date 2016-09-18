package common

object TextUtils {
    def countMatchingChars(str: String, leftIdx: Int, rightIdx: Int): Int = {
        countMatchingCharsIter(str, leftIdx, rightIdx, 0)
    }

    private def countMatchingCharsIter(str: String, leftIdx: Int, rightIdx: Int, acc: Int): Int = {
        if (leftIdx < 0 || rightIdx >= str.size || str.charAt(leftIdx) != str.charAt(rightIdx)) {
            acc
        } else {
            countMatchingCharsIter(str, leftIdx - 1, rightIdx + 1, acc + 1)
        }
    }
}
