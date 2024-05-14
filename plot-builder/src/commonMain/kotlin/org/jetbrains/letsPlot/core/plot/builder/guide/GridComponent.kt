/*
 * Copyright (c) 2023. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package org.jetbrains.letsPlot.core.plot.builder.guide

import org.jetbrains.letsPlot.commons.geometry.DoubleRectangle
import org.jetbrains.letsPlot.commons.geometry.DoubleVector
import org.jetbrains.letsPlot.commons.values.Color
import org.jetbrains.letsPlot.core.plot.base.render.linetype.LineType
import org.jetbrains.letsPlot.core.plot.base.render.svg.StrokeDashArraySupport
import org.jetbrains.letsPlot.core.plot.base.render.svg.SvgComponent
import org.jetbrains.letsPlot.core.plot.base.render.svg.lineString
import org.jetbrains.letsPlot.core.plot.base.theme.PanelGridTheme
import org.jetbrains.letsPlot.core.plot.builder.layout.AxisLayoutInfo
import org.jetbrains.letsPlot.datamodel.svg.dom.*

class GridComponent(
    private val majorGrid: List<List<DoubleVector>>,
    private val minorGrid: List<List<DoubleVector>>,
    axisInfo: AxisLayoutInfo,
    private val gridTheme: PanelGridTheme,
    private val isOrthogonal: Boolean,
    private val geomContentBounds: DoubleRectangle
) : SvgComponent() {
    private val container = SvgGElement()
    private val orientation = axisInfo.orientation
    private val start = 0.0
    private val end: Double = if (orientation.isHorizontal) geomContentBounds.height else geomContentBounds.width
    private val geomContentLocalBounds = geomContentBounds.subtract(geomContentBounds.origin)

    override fun buildComponent() {
        rootGroup.children().add(container)

        if (gridTheme.showMinor()) {
            buildGrid(
                minorGrid,
                gridTheme.minorLineWidth(),
                gridTheme.minorLineColor(),
                gridTheme.minorLineType()
            )
        }

        if (gridTheme.showMajor()) {
            buildGrid(
                majorGrid,
                gridTheme.majorLineWidth(),
                gridTheme.majorLineColor(),
                gridTheme.majorLineType()
            )
        }
    }

    private fun buildGrid(
        grid: List<List<DoubleVector>>,
        lineWidth: Double,
        lineColor: Color,
        lineType: LineType
    ) {
        val visibleGridLines =
            if (isOrthogonal) {

                grid
                    .map { (p) ->
                        when (orientation.isHorizontal) {
                            true -> listOf(DoubleVector(p.x, start), DoubleVector(p.x, end))
                            false -> listOf(DoubleVector(start, p.y), DoubleVector(end, p.y))
                        }
                    }
                    .filter { line -> line.any { p -> p in geomContentLocalBounds } }
            } else {
                // Non-orthogonal grid is always visible and don't support panning
                grid
            }

        val elems = visibleGridLines.map { buildGridLine(it, lineWidth, lineColor, lineType) }
        container.children().addAll(elems)
    }

    private fun buildGridLine(
        lineString: List<DoubleVector>,
        width: Double,
        color: Color,
        lineType: LineType
    ): SvgNode {
        val shapeElem: SvgShape = when {
            lineString.size == 2 -> SvgLineElement(lineString[0].x, lineString[0].y, lineString[1].x, lineString[1].y)
            lineString.size > 2 -> SvgPathElement(SvgPathDataBuilder().lineString(lineString).build())
            else -> SvgPathElement()
        }

        shapeElem.strokeColor().set(color)
        shapeElem.strokeWidth().set(width)
        StrokeDashArraySupport.apply(shapeElem, width, lineType)
        shapeElem.fill().set(SvgColors.NONE)
        return shapeElem as SvgNode
    }
}
