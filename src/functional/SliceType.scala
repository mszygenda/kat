package functional

trait SliceType {
    def leftSide(center: Int): Int
    def rightSide(center: Int): Int
}

object EvenSlice extends SliceType {
    def leftSide(center: Int): Int = center - 1
    def rightSide(center: Int): Int = center
}
object OddSlice extends SliceType {
    def leftSide(center: Int): Int = center - 1
    def rightSide(center: Int): Int = center + 1
}
