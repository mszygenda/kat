package functional

case class NilSlice(val sliceType: SliceType) extends Slice {
    val center = 0
    val radius = 0
    val previous = Nil

    override def sticksToLeftEdgeOf(other: Slice): Boolean = true
    override def calculateNext(str: String): Slice = new ExtendableSlice(1, sliceType, this :: previous, 0, str)
}