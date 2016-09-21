package functional

class SliceBasedOnPast(k: Int, pastHead: Slice, containerSlice: Slice, override val previous: List[Slice]) extends Slice {
    override val center = containerSlice.center + k
    override val sliceType = containerSlice.sliceType
    override val radius = Math.min(pastHead.radius, containerSlice.radius - k)

    protected def calculateNext(str: String): Slice= {
        if (k == containerSlice.radius) {
            new ExtendableSlice(center + 1, sliceType, this :: previous, 0, str)
        } else if (pastHead.previous.head.sticksToLeftEdgeOf(containerSlice)) {
            new ExtendableSlice(center + 1, sliceType, this :: previous, pastHead.previous.head.radius, str)
        } else {
            new SliceBasedOnPast(k + 1, pastHead.previous.head, containerSlice, this :: previous)
        }
    }
}
