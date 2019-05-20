package jetbrains.datalore.visualization.plot.gog.core.data.sampling

import jetbrains.datalore.base.gcommon.base.Preconditions.checkArgument
import jetbrains.datalore.visualization.plot.common.data.SeriesUtil
import jetbrains.datalore.visualization.plot.gog.core.data.DataFrame
import jetbrains.datalore.visualization.plot.gog.core.data.PointSampling
import jetbrains.datalore.visualization.plot.gog.core.data.sampling.SamplingUtil.xVar

/**
 * Picks first N data points with unique X-values. In addition scoops all data-points with X-values
 * which are already being accepted to the sample (to account for grouping)
 */
internal class PickSampling(sampleSize: Int) : SamplingBase(sampleSize), PointSampling {

    override val expressionText: String
        get() = "sampling_" + ALIAS + "(" +
                "n=" + sampleSize + ")"

    override fun apply(population: DataFrame): DataFrame {
        checkArgument(isApplicable(population))
        val pickedXValues = HashSet<Any>()
        val pickedIndices = ArrayList<Int>()

        val xValues = population[xVar(population)]
        for (i in xValues.indices) {
            val v = xValues[i]
            if (v is String || SeriesUtil.isFinite(v as Double)) {
                if (!pickedXValues.contains(v)) {
                    if (pickedXValues.size >= sampleSize) {
                        // do not add new X-values
                        continue
                    }
                    // pick this data-point and all subsequent data-points with equial X
                    pickedXValues.add(v)
                }

                pickedIndices.add(i)
            }
        }

        return population.selectIndices(pickedIndices)
    }

    companion object {
        val ALIAS = "pick"
    }
}
