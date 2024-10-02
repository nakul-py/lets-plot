/*
 * Copyright (c) 2023. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package org.jetbrains.letsPlot.core.plot.base.scale.breaks

import org.jetbrains.letsPlot.commons.formatting.number.NumberFormat
import org.jetbrains.letsPlot.commons.formatting.number.NumberFormat.ExponentNotationType
import org.jetbrains.letsPlot.commons.formatting.string.StringFormat.ExponentFormat
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.log10

internal class NumericBreakFormatter(
    value: Double,
    step: Double,
    allowMetricPrefix: Boolean,
    expFormat: ExponentFormat
) {
    private var formatter: NumberFormat

    init {
        @Suppress("NAME_SHADOWING")
        val value = if (value == 0.0) {
            // Use very small value instead because log10(0) -> -Infinity.
            Double.MIN_VALUE * 10
        } else {
            abs(value)
        }

        @Suppress("NAME_SHADOWING")
        val step = if (step == 0.0) {
            value / 10
        } else {
            abs(step)
        }


        var type = "f"
        var comma = false

        val domain10Power = log10(abs(value))
        val step10Power = log10(step)

        var precision = -step10Power
        var scientificNotation = false
        if (domain10Power < 0 && step10Power < -4) {
            scientificNotation = true
            type = "e"
            precision = domain10Power - step10Power
        } else if (domain10Power > 7 && step10Power > 2) {
            scientificNotation = true
            precision = domain10Power - step10Power
        }

        if (precision < 0) {
            precision = 0.0
            type = "d"
        }
        // round-up precision unless it's very close to smaller int.
        precision = ceil(precision - 0.001)

        if (scientificNotation) {
            // generate 'engineering notation', in which the exponent is a multiple of three
            type = if (domain10Power > 0 && allowMetricPrefix && expFormat.notationType == ExponentNotationType.E) "s" else "e"
        } else {
            comma = true
        }
        val trim = type == "e" && expFormat.notationType != ExponentNotationType.E
        val expType = if (trim) expFormat.notationType else ExponentNotationType.E

        formatter = NumberFormat(NumberFormat.Spec(
            comma = comma,
            precision = precision.toInt(),
            trim = trim,
            type = type,
            expType = expType,
            minExp = expFormat.min ?: NumberFormat.DEF_MIN_EXP,
            maxExp = expFormat.max ?: precision.toInt()
        ))
    }

    fun apply(value: Any): String = formatter.apply(value as Number)
}
