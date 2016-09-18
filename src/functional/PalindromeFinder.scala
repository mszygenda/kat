package functional

import common.CalculationUtils._

case class PalindromeFinder(str: String) {
    lazy val palindromicSlices = {
        foldSlices[List[Slice]](Nil)(NilSlice(OddSlice), foldToPalindromicList(_, _)) ++
        foldSlices[List[Slice]](Nil)(NilSlice(EvenSlice), foldToPalindromicList(_, _))
    }

    private def foldToPalindromicList(list: List[Slice], slice: Slice): List[Slice] = {
        if (slice.radius > 0) {
            slice :: list
        } else {
            list
        }
    }

    lazy val palindromeCount: Int = {
        sumWithDefaultLimit(
            foldSlices(0)(NilSlice(OddSlice), (sum, slice) => { sumWithDefaultLimit(sum, slice.radius) }),
            foldSlices(0)(NilSlice(EvenSlice), (sum, slice) => { sumWithDefaultLimit(sum, slice.radius) })
        )
    }

    private def foldSlices[B](z: B)(slice: Slice, fun: (B, Slice) => B): B = {
        foldSlices(slice, fun, z)
    }

    private def foldSlices[B](slice: Slice, fun: (B, Slice) => B, acc: B): B = {
        slice.next(str) match {
            case Some(nextSlice) => foldSlices(nextSlice, fun, fun(acc, slice))
            case None => acc
        }
    }
}