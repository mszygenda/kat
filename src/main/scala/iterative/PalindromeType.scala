package iterative

trait PalindromeType {
    def leftSide(center: Int): Int
    def rightSide(center: Int): Int
}

object Even extends PalindromeType {
    override def leftSide(center: Int): Int = center - 1
    override def rightSide(center: Int): Int = center
}
object Odd extends PalindromeType {
    override def leftSide(center: Int): Int = center - 1
    override def rightSide(center: Int): Int = center + 1
}
