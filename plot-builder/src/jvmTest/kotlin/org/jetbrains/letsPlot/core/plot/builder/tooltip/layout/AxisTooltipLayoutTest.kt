/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package org.jetbrains.letsPlot.core.plot.builder.tooltip.layout

import org.jetbrains.letsPlot.commons.geometry.DoubleVector
import org.jetbrains.letsPlot.core.plot.builder.tooltip.HorizontalAxisTooltipPosition
import org.jetbrains.letsPlot.core.plot.builder.tooltip.TestUtil.coord
import org.jetbrains.letsPlot.core.plot.builder.tooltip.TestUtil.point
import org.jetbrains.letsPlot.core.plot.builder.tooltip.TestUtil.size
import org.jetbrains.letsPlot.core.plot.builder.tooltip.VerticalAxisTooltipPosition
import org.jetbrains.letsPlot.core.plot.builder.tooltip.layout.LayoutManager.HorizontalAlignment.LEFT
import org.jetbrains.letsPlot.core.plot.builder.tooltip.layout.LayoutManager.HorizontalAlignment.RIGHT
import org.jetbrains.letsPlot.core.plot.builder.tooltip.layout.LayoutManager.VerticalAlignment.BOTTOM
import org.jetbrains.letsPlot.core.plot.builder.tooltip.layout.LayoutManager.VerticalAlignment.TOP
import org.jetbrains.letsPlot.core.plot.builder.tooltip.layout.MeasuredTooltipBuilder.MeasuredTooltipBuilderFactory
import kotlin.test.BeforeTest
import kotlin.test.Test

internal class AxisTooltipLayoutTest : TooltipLayoutTestBase() {
    private var factory: MeasuredTooltipBuilderFactory? = null

    @BeforeTest
    fun setUp() {
        factory = MeasuredTooltipBuilderFactory()
    }

    @Test
    fun whenXAxisTooltipPresented_AndSideTipUnderAxis_ShouldAlignSideTipAboveAxis() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(coord(VIEWPORT.center.x, VIEWPORT.bottom)).buildTooltip()
            )
            .addTooltip(
                xAxisTip(VIEWPORT.center.x)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(X_AXIS_TOOLTIP_KEY),
            expect(HORIZONTAL_TOOLTIP_KEY).tooltipY(DEFAULT_AXIS_ORIGIN.y - tooltip(HORIZONTAL_TOOLTIP_KEY).size().y)
        )
    }

    @Test
    fun whenXAxisTooltipPresented_AndNotFitToSpace_ShouldAlignToBorder() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(
                    targetCoord = coord(
                        VIEWPORT.center.x,
                        DEFAULT_AXIS_ORIGIN.y - DEFAULT_TOOLTIP_SIZE.y / 2
                    )
                ).buildTooltip()
            )
            .addTooltip(
                xAxisTip(VIEWPORT.center.x)
                    .size(DEFAULT_NON_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(X_AXIS_TOOLTIP_KEY).tooltipY(VIEWPORT.bottom - tooltip(X_AXIS_TOOLTIP_KEY).size().y),
            expect(HORIZONTAL_TOOLTIP_KEY).tooltipY(
                tooltip(X_AXIS_TOOLTIP_KEY).coord().y - tooltip(
                    HORIZONTAL_TOOLTIP_KEY
                ).size().y
            )
        )
    }

    @Test
    fun whenYAxisTooltipNotFitToSpace_AndIntersectsWith_HorizontalTooltip() {
        // y axis tooltip does't fit => align it to the plot border
        // horizontal tooltip intersects with the y axis tooltip => aligned to the right
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(
                    targetCoord = coord(
                        DEFAULT_AXIS_ORIGIN.x + DEFAULT_TOOLTIP_SIZE.x + DEFAULT_OBJECT_RADIUS,
                        VIEWPORT.center.y
                    )
                ).buildTooltip()
            )
            .addTooltip(
                yAxisTip(VIEWPORT.center.y)
                    .size(DEFAULT_NON_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(Y_AXIS_TOOLTIP_KEY).tooltipX(VIEWPORT.left),
            expect(HORIZONTAL_TOOLTIP_KEY).tooltipX(expectedSideTipX(HORIZONTAL_TOOLTIP_KEY, RIGHT))
        )
    }

    @Test
    fun onlyOneXAxisTooltipShouldBeShown() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(coord(150.0, 150.0)).buildTooltip()
            )
            .addTooltip(
                xAxisTip(VIEWPORT.center.x)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .addTooltip(
                xAxisTip(VIEWPORT.center.x)
                    .text("another x axis tooltip should not be added")
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(X_AXIS_TOOLTIP_KEY),
            expect(HORIZONTAL_TOOLTIP_KEY)
        )
    }

    @Test
    fun whenXAxisTooltipPresented_AndCoveredByCursor_ShouldNotMoveTooltipUp() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .cursor(
                coord(VIEWPORT.center.x, DEFAULT_AXIS_ORIGIN.y)
            )
            .addTooltip(
                xAxisTip(VIEWPORT.center.x)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(X_AXIS_TOOLTIP_KEY).tooltipY(expectedAxisTipY(X_AXIS_TOOLTIP_KEY, BOTTOM))
        )
    }

    @Test
    fun yAxisTooltip_WhenFit_ShouldBeAlignedToLeft() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                yAxisTip(VIEWPORT.center.y)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(Y_AXIS_TOOLTIP_KEY)
                .tooltipX(expectedAxisTipX(Y_AXIS_TOOLTIP_KEY, LEFT))
                .tooltipY(expectedSideTipY(Y_AXIS_TOOLTIP_KEY))
        )
    }

    @Test
    fun whenHorizontalTooltip_Intersects_yAxisTooltip_ShouldBeMovedToRight() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(
                    targetCoord = coord(
                        DEFAULT_AXIS_ORIGIN.x + DEFAULT_TOOLTIP_SIZE.x + DEFAULT_OBJECT_RADIUS,
                        VIEWPORT.center.y
                    )
                ).buildTooltip()
            )
            .addTooltip(
                yAxisTip(VIEWPORT.center.y)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(Y_AXIS_TOOLTIP_KEY),
            expect(HORIZONTAL_TOOLTIP_KEY).tooltipX(expectedSideTipX(HORIZONTAL_TOOLTIP_KEY, RIGHT))
        )
    }

    @Test
    fun whenHorizontalTooltip_NotIntersectByY_yAxisTooltip_ShouldBeAlignedToLeft() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(
                    targetCoord = coord(
                        DEFAULT_AXIS_ORIGIN.x + DEFAULT_TOOLTIP_SIZE.x + DEFAULT_OBJECT_RADIUS,
                        VIEWPORT.top
                    )
                ).buildTooltip()
            )
            .addTooltip(
                yAxisTip(VIEWPORT.center.y)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(Y_AXIS_TOOLTIP_KEY),
            expect(HORIZONTAL_TOOLTIP_KEY).tooltipX(expectedSideTipX(HORIZONTAL_TOOLTIP_KEY, LEFT))
        )
    }

    // X-axis tooltip with top position

    @Test
    fun xAxisTooltipWithTopPosition_WhenFit_ShouldBeAlignedToTheTopOfAxis() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                xAxisTip(VIEWPORT.center.x, hasBottomPosition = false)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .horizontalAxisTooltipPosition(HorizontalAxisTooltipPosition.TOP)
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(X_AXIS_TOOLTIP_KEY).tooltipY(expectedAxisTipY(X_AXIS_TOOLTIP_KEY, TOP))
        )
    }

    @Test
    fun whenXAxisTooltipWithTopPosition_AndNotFitToSpace_ShouldBeAlignedToPlotBorder() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                xAxisTip(VIEWPORT.center.x, hasBottomPosition = false)
                    .size(DEFAULT_NON_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .horizontalAxisTooltipPosition(HorizontalAxisTooltipPosition.TOP)
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(X_AXIS_TOOLTIP_KEY).tooltipY(VIEWPORT.top)
        )
    }

    @Test
    fun whenXAxisTooltipPresentedWithTopPosition_AndSideTipAboveAxis_ShouldAlignSideTipUnderAxis() {
        // axis tooltip limit the vertical space
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(coord(VIEWPORT.center.x, VIEWPORT.top)).buildTooltip()
            )
            .addTooltip(
                xAxisTip(VIEWPORT.center.x, hasBottomPosition = false)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .horizontalAxisTooltipPosition(HorizontalAxisTooltipPosition.TOP)
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(X_AXIS_TOOLTIP_KEY),
            expect(HORIZONTAL_TOOLTIP_KEY)
                .tooltipY(with(tooltip(X_AXIS_TOOLTIP_KEY)) { coord().y + size().y })
        )
    }

    // Y-axis with right position

    @Test
    fun yAxisTooltipWithRightPosition_WhenFit_ShouldBeAlignedToRightOfAxis() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                yAxisTip(VIEWPORT.center.y, hasLeftPosition = false)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .verticalAxisTooltipPosition(VerticalAxisTooltipPosition.RIGHT)
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(Y_AXIS_TOOLTIP_KEY)
                .tooltipX(expectedAxisTipX(Y_AXIS_TOOLTIP_KEY, RIGHT))
        )
    }

    @Test
    fun whenYAxisTooltipWithRightPosition_AndNotFitToSpace_ShouldBeAlignedToPlotBorder() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                yAxisTip(VIEWPORT.center.y, hasLeftPosition = false)
                    .size(DEFAULT_NON_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .verticalAxisTooltipPosition(VerticalAxisTooltipPosition.RIGHT)
            .build()

        arrange(layoutManagerController)

        assertAllTooltips(
            expect(Y_AXIS_TOOLTIP_KEY).tooltipX(VIEWPORT.right - tooltip(Y_AXIS_TOOLTIP_KEY).size().x)
        )
    }

    @Test
    fun `x axis tooltip is out of visibility`() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                xAxisTip(10.0)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .geomBounds(LIMIT_RECT)
            .build()

        arrange(layoutManagerController)

        assertNoTooltips()
    }

    @Test
    fun `y axis tooltip is out of visibility`() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                yAxisTip(10.0)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .geomBounds(LIMIT_RECT)
            .build()

        arrange(layoutManagerController)

        assertNoTooltips()
    }

    @Test
    fun `general tooltip is out of visibility, then axis tooltip will also be hidden`() {
        val layoutManagerController = createTipLayoutManagerBuilder(VIEWPORT)
            .addTooltip(
                defaultHorizontalTip(coord(10.0, 10.0)).buildTooltip()
            )
            .addTooltip(
                xAxisTip(VIEWPORT.center.x)
                    .size(DEFAULT_FIT_TOOLTIP_SIZE)
                    .buildTooltip()
            )
            .geomBounds(LIMIT_RECT)
            .build()

        arrange(layoutManagerController)

        assertNoTooltips()
    }

    private fun defaultHorizontalTip(targetCoord: DoubleVector): MeasuredTooltipBuilder {
        return factory!!.horizontal(HORIZONTAL_TOOLTIP_KEY, targetCoord)
            .size(DEFAULT_TOOLTIP_SIZE)
            .objectRadius(DEFAULT_OBJECT_RADIUS)
    }

    private fun xAxisTip(x: Double, hasBottomPosition: Boolean = true): MeasuredTooltipBuilder {
        val y = if (hasBottomPosition) {
            DEFAULT_AXIS_ORIGIN.y
        } else {
            DEFAULT_X_AXIS_PADDING
        }
        return factory!!.xAxisTip(X_AXIS_TOOLTIP_KEY, coord(x, y))
    }

    private fun yAxisTip(y: Double, hasLeftPosition: Boolean = true): MeasuredTooltipBuilder {
        val x = if (hasLeftPosition) {
            DEFAULT_AXIS_ORIGIN.x
        } else {
            VIEWPORT.right - DEFAULT_X_AXIS_PADDING
        }
        return factory!!.yAxisTip(Y_AXIS_TOOLTIP_KEY, coord(x, y))
    }

    companion object {
        private const val X_AXIS_TOOLTIP_KEY = "xaxistooltip"
        private const val Y_AXIS_TOOLTIP_KEY = "yaxistooltip"
        private const val HORIZONTAL_TOOLTIP_KEY = "sidetipkey"

        private const val DEFAULT_X_AXIS_PADDING = 30.0
        private const val DEFAULT_Y_AXIS_PADDING = 30.0
        private const val EXTRA_PADDING = 3.0

        private val DEFAULT_AXIS_ORIGIN = point(
            DEFAULT_X_AXIS_PADDING,
            VIEWPORT.bottom - DEFAULT_Y_AXIS_PADDING
        )

        private val DEFAULT_FIT_TOOLTIP_SIZE = size(
            DEFAULT_Y_AXIS_PADDING - AXIS_STEM_LENGTH - EXTRA_PADDING,
            DEFAULT_X_AXIS_PADDING - AXIS_STEM_LENGTH - EXTRA_PADDING
        )

        private val DEFAULT_NON_FIT_TOOLTIP_SIZE = size(
            DEFAULT_Y_AXIS_PADDING + EXTRA_PADDING,
            DEFAULT_X_AXIS_PADDING + EXTRA_PADDING
        )
    }
}