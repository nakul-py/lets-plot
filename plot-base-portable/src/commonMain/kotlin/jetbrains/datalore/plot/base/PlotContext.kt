/*
 * Copyright (c) 2022. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.base

import jetbrains.datalore.base.interval.DoubleSpan
import jetbrains.datalore.plot.base.aes.AestheticsDefaults
import jetbrains.datalore.plot.base.render.LegendKeyElementFactory

interface PlotContext {
    val layers: List<Layer>

    fun getScale(aes: Aes<*>): Scale<*>
    fun overallTransformedDomain(aes: Aes<*>): DoubleSpan

    interface Layer {
        val isLegendDisabled: Boolean
        val aestheticsDefaults: AestheticsDefaults
        val legendKeyElementFactory: LegendKeyElementFactory
        fun renderedAes(): List<Aes<*>>
        fun hasBinding(aes: Aes<*>): Boolean
        fun hasConstant(aes: Aes<*>): Boolean
        fun <T> getConstant(aes: Aes<T>): T
    }
}