/*
 * Copyright (c) 2022. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.builder.tooltip

import jetbrains.datalore.plot.base.Aes
import jetbrains.datalore.plot.base.PlotContext
import jetbrains.datalore.plot.base.scale.ScaleUtil

internal object TooltipFormatting {
    fun createFormatter(aes: Aes<*>, ctx: PlotContext): (Any?) -> String {
        // expect only X,Y or not positional
        check(!Aes.isPositionalXY(aes) || aes == Aes.X || aes == Aes.Y) {
            "Positional aesthetic should be either X or Y but was $aes"
        }

        val scale = ctx.getScale(aes)
        if (scale.isContinuousDomain) {
            val domain = ctx.overallTransformedDomain(aes)
            val formatter = scale.getBreaksGenerator().defaultFormatter(domain, 100)
            return { value -> value?.let { formatter.invoke(it) } ?: "n/a" }
        } else {
            val labelsMap = ScaleUtil.labelByBreak(scale)
            return { value -> value?.let { labelsMap[it] } ?: "n/a" }
        }
    }
}