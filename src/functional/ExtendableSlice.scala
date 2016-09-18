package functional

import common.TextUtils

class ExtendableSlice(val center: Int, val sliceType: SliceType, val previous: List[Slice], minimalRadius: Int, str: String) extends Slice {
    override val radius = {
        TextUtils.countMatchingChars(
            str,
            sliceType.leftSide(center) - minimalRadius,
            sliceType.rightSide(center) + minimalRadius
        ) + minimalRadius
    }

    protected def calculateNext(str: String): Slice = {
        if (radius == 0) {
            new ExtendableSlice(center + 1, sliceType, this :: previous, 0, str)
        } else if (previous.head.sticksToLeftEdgeOf(this)) {
            new ExtendableSlice(center + 1, sliceType, this :: previous, previous.head.radius, str)
        } else {
            new SliceBasedOnPast(1, previous.head, this, this :: previous)
        }
    }
}
