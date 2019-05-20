package jetbrains.datalore.visualization.plot.gog.core.scale.transform

import jetbrains.datalore.base.gcommon.base.Preconditions.checkArgument
import jetbrains.datalore.base.gcommon.collect.ClosedRange
import jetbrains.datalore.visualization.plot.common.data.SeriesUtil
import jetbrains.datalore.visualization.plot.gog.core.scale.BreaksGenerator
import jetbrains.datalore.visualization.plot.gog.core.scale.ScaleBreaks
import jetbrains.datalore.visualization.plot.gog.core.scale.Transform
import kotlin.jvm.JvmOverloads

internal class IdentityTransform @JvmOverloads constructor(
        private val myBreaksGenerator: BreaksGenerator = LinearBreaksGen()) :
        Transform, BreaksGenerator {

    override fun apply(rawData: List<*>): List<Double?> {
        val checkedDoubles = SeriesUtil.checkedDoubles(rawData)
        checkArgument(checkedDoubles.canBeCast(), "Not a collections of numbers")
        return checkedDoubles.cast()
    }

    override fun applyInverse(v: Double?): Any? {
        return v
    }

    override fun generateBreaks(domainAfterTransform: ClosedRange<Double>, targetCount: Int): ScaleBreaks {
        return myBreaksGenerator.generateBreaks(domainAfterTransform, targetCount)
    }
}
