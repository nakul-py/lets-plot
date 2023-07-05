/*
 * Copyright (c) 2020. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.base.geom

import jetbrains.datalore.plot.base.*
import jetbrains.datalore.plot.base.geom.util.GeomUtil
import jetbrains.datalore.plot.base.geom.util.LinesHelper
import jetbrains.datalore.plot.base.geom.util.TargetCollectorHelper
import jetbrains.datalore.plot.base.render.LegendKeyElementFactory
import jetbrains.datalore.plot.base.render.SvgRoot

open class PathGeom : GeomBase() {

    var animation: Any? = null
    var flat: Boolean = false
    var geodesic: Boolean = false

    override val legendKeyElementFactory: LegendKeyElementFactory
        get() = HLineGeom.LEGEND_KEY_ELEMENT_FACTORY

    protected open fun dataPoints(aesthetics: Aesthetics): Iterable<DataPointAesthetics> {
        return GeomUtil.with_X_Y(aesthetics.dataPoints())
    }

    override fun buildIntern(
        root: SvgRoot,
        aesthetics: Aesthetics,
        pos: PositionAdjustment,
        coord: CoordinateSystem,
        ctx: GeomContext
    ) {

        val dataPoints = dataPoints(aesthetics)
        val linesHelper = LinesHelper(pos, coord, ctx)
        val targetCollectorHelper = TargetCollectorHelper(GeomKind.PATH, ctx)

        val variadicPathData = linesHelper.createVariadicPathData(dataPoints)

        // To not add interpolated points and to not show incorrect tooltips on them
        targetCollectorHelper.addVariadicPaths(variadicPathData)

        val visualPathData = LinesHelper.createVisualPath(variadicPathData)

        val svgPath = linesHelper.createPaths(visualPathData, closePath = false)
        root.appendNodes(svgPath)
    }


    companion object {
        const val HANDLES_GROUPS = true
    }
}
