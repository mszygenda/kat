package functional

abstract class Slice {
    val center: Int
    val radius: Int
    val sliceType: SliceType
    val previous: List[Slice]

    def next(str: String): Option[Slice] = {
        if (center >= str.size) { None } else { Some(calculateNext(str)) }
    }

    protected def calculateNext(str: String): Slice

    def sticksToLeftEdgeOf(other: Slice): Boolean = {
        val maximumRadius = other.radius - (other.center - center)

        radius == maximumRadius
    }

    override def toString = "( " + this.getClass + ":" + center + ", " + radius + ")"
}