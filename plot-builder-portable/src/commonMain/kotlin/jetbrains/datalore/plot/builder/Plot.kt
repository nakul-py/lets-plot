/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.builder

import jetbrains.datalore.base.event.Event
import jetbrains.datalore.base.gcommon.base.Throwables
import jetbrains.datalore.base.geometry.DoubleRectangle
import jetbrains.datalore.base.geometry.DoubleVector
import jetbrains.datalore.base.logging.PortableLogging
import jetbrains.datalore.base.registration.Registration
import jetbrains.datalore.base.values.Color
import jetbrains.datalore.base.values.SomeFig
import jetbrains.datalore.plot.FeatureSwitch.FLIP_AXIS
import jetbrains.datalore.plot.FeatureSwitch.PLOT_DEBUG_DRAWING
import jetbrains.datalore.plot.base.Scale
import jetbrains.datalore.plot.base.render.svg.SvgComponent
import jetbrains.datalore.plot.base.render.svg.TextLabel
import jetbrains.datalore.plot.base.render.svg.TextLabel.HorizontalAnchor
import jetbrains.datalore.plot.base.render.svg.TextLabel.VerticalAnchor
import jetbrains.datalore.plot.builder.coord.CoordProvider
import jetbrains.datalore.plot.builder.event.MouseEventPeer
import jetbrains.datalore.plot.builder.guide.Orientation
import jetbrains.datalore.plot.builder.interact.TooltipSpec
import jetbrains.datalore.plot.builder.layout.*
import jetbrains.datalore.plot.builder.layout.PlotLayoutUtil.liveMapBounds
import jetbrains.datalore.plot.builder.presentation.Style
import jetbrains.datalore.plot.builder.theme.Theme
import jetbrains.datalore.vis.svg.SvgElement
import jetbrains.datalore.vis.svg.SvgGElement
import jetbrains.datalore.vis.svg.SvgNode
import jetbrains.datalore.vis.svg.SvgRectElement
import jetbrains.datalore.vis.svg.event.SvgEventHandler
import jetbrains.datalore.vis.svg.event.SvgEventSpec

abstract class Plot(private val theme: Theme) : SvgComponent() {

    private val myTooltipHelper = PlotTooltipHelper()
    private val myLiveMapFigures = ArrayList<SomeFig>()

    val mouseEventPeer = MouseEventPeer()

    protected abstract val scaleXProto: Scale<Double>

    protected abstract val scaleYProto: Scale<Double>

    protected abstract val title: String

    protected abstract val axisTitleLeft: String

    protected abstract val axisTitleBottom: String

    protected abstract val coordProvider: CoordProvider

    protected abstract val legendBoxInfos: List<LegendBoxInfo>

    protected abstract val isAxisEnabled: Boolean

    abstract val isInteractionsEnabled: Boolean

    internal val liveMapFigures: List<SomeFig>
        get() = myLiveMapFigures

    var plotSize: DoubleVector = DEF_PLOT_SIZE
        private set

    protected abstract fun hasTitle(): Boolean

    protected abstract fun hasAxisTitleLeft(): Boolean

    protected abstract fun hasAxisTitleBottom(): Boolean

    protected abstract fun hasLiveMap(): Boolean

    protected abstract fun tileLayers(tileIndex: Int): List<GeomLayer>

    protected abstract fun plotLayout(): PlotLayout

    override fun buildComponent() {
        try {
            buildPlot()
        } catch (e: RuntimeException) {
            LOG.error(e) { "buildPlot" }

            val rootCause = Throwables.getRootCause(e)
            val messages = arrayOf(
                "Error building plot: " + rootCause::class.simpleName, if (rootCause.message != null)
                    "'" + rootCause.message + "'"
                else
                    "<no message>"
            )
            var y = plotSize.y / 2 - 8
            for (s in messages) {
                val errorLabel = TextLabel(s)
                errorLabel.setHorizontalAnchor(HorizontalAnchor.MIDDLE)
                errorLabel.setVerticalAnchor(VerticalAnchor.CENTER)
                errorLabel.moveTo(plotSize.x / 2, y)
                rootGroup.children().add(errorLabel.rootGroup)
                y += 16.0
            }
        }
    }

    private fun buildPlot() {
        rootGroup.addClass(Style.PLOT)
        buildPlotComponents()

        reg(object : Registration() {
            override fun doRemove() {
                myTooltipHelper.removeAllTileInfos()
                myLiveMapFigures.clear()
            }
        })
    }

    fun resize(plotSize: DoubleVector) {
        if (plotSize.x <= 0 || plotSize.y <= 0) return
        if (plotSize == this.plotSize) return

        this.plotSize = plotSize

        // just invalidate
        clear()
    }


//    private fun rebuildPlot() {
//        clear()
//        buildPlot()
//    }


    private fun createTile(
        tilesOrigin: DoubleVector,
        tileInfo: TileLayoutInfo,
        tileLayers: List<GeomLayer>,
        theme: Theme,
    ): PlotTile {

        val frameOfReference: TileFrameOfReference
        if (hasLiveMap()) {
            // Livemap usues its own.
            frameOfReference = BogusFrameOfReference()
        } else {

            val xDomain = tileInfo.xAxisInfo!!.axisDomain!!
            val xAxisLength = tileInfo.xAxisInfo.axisLength

            val yDomain = tileInfo.yAxisInfo!!.axisDomain!!
            val yAxisLength = tileInfo.yAxisInfo.axisLength

            // set-up scales and coordinate system
            val xScale =
                coordProvider.buildAxisScaleX(scaleXProto, xDomain, xAxisLength, tileInfo.xAxisInfo.axisBreaks!!)
            val yScale =
                coordProvider.buildAxisScaleY(scaleYProto, yDomain, yAxisLength, tileInfo.yAxisInfo.axisBreaks!!)
            val coord = coordProvider.createCoordinateSystem(xDomain, xAxisLength, yDomain, yAxisLength)

            frameOfReference = SquareFrameOfReference(
                xScale, yScale,
                coord,
                tileInfo,
                theme,
                isAxisEnabled,
                FLIP_AXIS,
            )
            frameOfReference.isDebugDrawing = DEBUG_DRAWING
        }

        val tile = PlotTile(tileLayers, tilesOrigin, tileInfo, theme, frameOfReference)
        tile.isDebugDrawing = DEBUG_DRAWING
        return tile
    }

    private fun createAxisTitle(
        text: String,
        orientation: Orientation,
        plotBounds: DoubleRectangle,
        geomBounds: DoubleRectangle
    ) {
        val horizontalAnchor = HorizontalAnchor.MIDDLE
        val verticalAnchor: VerticalAnchor = when (orientation) {
            Orientation.LEFT, Orientation.RIGHT, Orientation.TOP -> VerticalAnchor.TOP
            Orientation.BOTTOM -> VerticalAnchor.BOTTOM
        }

        val titleLocation: DoubleVector
        var rotation = 0.0
        when (orientation) {
            Orientation.LEFT -> {
                titleLocation =
                    DoubleVector(plotBounds.left + PlotLayoutUtil.AXIS_TITLE_OUTER_MARGIN, geomBounds.center.y)
                rotation = -90.0
            }
            Orientation.RIGHT -> {
                titleLocation =
                    DoubleVector(plotBounds.right - PlotLayoutUtil.AXIS_TITLE_OUTER_MARGIN, geomBounds.center.y)
                rotation = 90.0
            }
            Orientation.TOP -> titleLocation =
                DoubleVector(geomBounds.center.x, plotBounds.top + PlotLayoutUtil.AXIS_TITLE_OUTER_MARGIN)
            Orientation.BOTTOM -> titleLocation =
                DoubleVector(geomBounds.center.x, plotBounds.bottom - PlotLayoutUtil.AXIS_TITLE_OUTER_MARGIN)
        }

        val titleLabel = TextLabel(text)
        titleLabel.setHorizontalAnchor(horizontalAnchor)
        titleLabel.setVerticalAnchor(verticalAnchor)
        titleLabel.moveTo(titleLocation)
        titleLabel.rotate(rotation)

        val titleElement = titleLabel.rootGroup
        titleElement.addClass(Style.AXIS_TITLE)

        // hack: we have style: ".axis .title text" and we don't want to break backward-compatibility with 'census' charts
        val parent = SvgGElement()
        parent.addClass(Style.AXIS)

        parent.children().add(titleElement)

        add(parent)
    }

    private fun onMouseMove(e: SvgElement, message: String) {
        e.addEventHandler(SvgEventSpec.MOUSE_MOVE, object :
            SvgEventHandler<Event> {
            override fun handle(node: SvgNode, e: Event) {
                println(message)
            }
        })
    }

    private fun buildPlotComponents() {
        val overallRect = DoubleRectangle(DoubleVector.ZERO, plotSize)

        @Suppress("ConstantConditionIf")
        if (DEBUG_DRAWING) {
            val rect = SvgRectElement(overallRect)
            rect.strokeColor().set(Color.MAGENTA)
            rect.strokeWidth().set(1.0)
            rect.fillOpacity().set(0.0)
            onMouseMove(rect, "MAGENTA: preferred size: $overallRect")
            add(rect)
        }

        // compute geom bounds
        val entirePlot = if (hasLiveMap()) {
            liveMapBounds(overallRect)
        } else {
            overallRect
        }

        // subtract title size
        val withoutTitle = if (hasTitle()) {
            val titleSize = PlotLayoutUtil.titleDimensions(title)
            DoubleRectangle(
                entirePlot.origin.add(DoubleVector(0.0, titleSize.y)),
                entirePlot.dimension.subtract(DoubleVector(0.0, titleSize.y))
            )
        } else {
            entirePlot
        }

        // adjust for legend boxes
        var boxesLayoutResult: LegendBoxesLayout.Result? = null
        val legendTheme = theme.legend()
        val withoutTitleAndLegends = if (legendTheme.position().isFixed) {
            val legendBoxesLayout =
                LegendBoxesLayout(withoutTitle, legendTheme)
            boxesLayoutResult = legendBoxesLayout.doLayout(legendBoxInfos)
            boxesLayoutResult.plotInnerBoundsWithoutLegendBoxes
        } else {
            withoutTitle
        }

        @Suppress("ConstantConditionIf")
        if (DEBUG_DRAWING) {
            val rect = SvgRectElement(withoutTitleAndLegends)
            rect.strokeColor().set(Color.BLUE)
            rect.strokeWidth().set(1.0)
            rect.fillOpacity().set(0.0)
            onMouseMove(rect, "BLUE: plot without title and legends: $withoutTitleAndLegends")
            add(rect)
        }

        // subtract left axis title width
        var geomAndAxis = withoutTitleAndLegends
        if (isAxisEnabled) {
            if (hasAxisTitleLeft()) {
                val titleSize = PlotLayoutUtil.axisTitleDimensions(axisTitleLeft)
                val thickness =
                    titleSize.y + PlotLayoutUtil.AXIS_TITLE_OUTER_MARGIN + PlotLayoutUtil.AXIS_TITLE_INNER_MARGIN
                geomAndAxis = DoubleRectangle(
                    geomAndAxis.left + thickness, geomAndAxis.top,
                    geomAndAxis.width - thickness, geomAndAxis.height
                )
            }

            // subtract bottom axis title height
            if (hasAxisTitleBottom()) {
                val titleSize = PlotLayoutUtil.axisTitleDimensions(axisTitleBottom)
                val thickness =
                    titleSize.y + PlotLayoutUtil.AXIS_TITLE_OUTER_MARGIN + PlotLayoutUtil.AXIS_TITLE_INNER_MARGIN
                geomAndAxis = DoubleRectangle(
                    geomAndAxis.left, geomAndAxis.top,
                    geomAndAxis.width, geomAndAxis.height - thickness
                )
            }
        }

        // Layout plot inners
        val plotLayout = plotLayout()
        val plotInfo = plotLayout.doLayout(geomAndAxis.dimension)

        if (plotInfo.tiles.isEmpty()) {
            return
        }

        val geomAreaBounds = PlotLayoutUtil.absoluteGeomBounds(geomAndAxis.origin, plotInfo)
        if (legendTheme.position().isOverlay) {
            // put 'overlay' in 'geom' bounds
            val legendBoxesLayout = LegendBoxesLayout(geomAreaBounds, legendTheme)
            boxesLayoutResult = legendBoxesLayout.doLayout(legendBoxInfos)
        }

        // build tiles
        val tileTheme = if (plotInfo.tiles.size > 1) {
            theme.multiTile()
        } else {
            theme
        }

        val tilesOrigin = geomAndAxis.origin
        for (tileLayoutInfo in plotInfo.tiles) {
            val tileLayersIndex = tileLayoutInfo.trueIndex

//            println("plot offset: " + tileInfo.plotOffset)
//            println("     bounds: " + tileInfo.bounds)
//            println("geom bounds: " + tileInfo.geomBounds)
//            println("clip bounds: " + tileInfo.clipBounds)
            val tile = createTile(tilesOrigin, tileLayoutInfo, tileLayers(tileLayersIndex), tileTheme)

            val plotOriginAbsolute = tilesOrigin.add(tileLayoutInfo.plotOrigin)
            tile.moveTo(plotOriginAbsolute)

            add(tile)

            tile.liveMapFigure?.let(myLiveMapFigures::add)

            val geomBoundsAbsolute = tileLayoutInfo.geomBounds.add(plotOriginAbsolute)
            val tooltipBounds = PlotTooltipBounds(
                placementArea = geomBoundsAbsolute,
                handlingArea = tile.geomDrawingBounds.add(geomBoundsAbsolute.origin)
            )
            myTooltipHelper.addTileInfo(geomBoundsAbsolute, tooltipBounds, tile.targetLocators)

            @Suppress("ConstantConditionIf")
            if (DEBUG_DRAWING) {
                val rect = SvgRectElement(tooltipBounds.handlingArea)
                rect.strokeColor().set(Color.ORANGE)
                rect.strokeWidth().set(1.0)
                rect.fillOpacity().set(0.0)
                add(rect)
            }
        }

        @Suppress("ConstantConditionIf")
        if (DEBUG_DRAWING) {
            val rect = SvgRectElement(geomAreaBounds)
            rect.strokeColor().set(Color.RED)
            rect.strokeWidth().set(1.0)
            rect.fillOpacity().set(0.0)
            add(rect)
        }

        // add plot title
        if (hasTitle()) {
            val titleLabel = TextLabel(title)
            titleLabel.addClassName(Style.PLOT_TITLE)
            titleLabel.setHorizontalAnchor(HorizontalAnchor.LEFT)
            titleLabel.setVerticalAnchor(VerticalAnchor.CENTER)

            val titleSize = PlotLayoutUtil.titleDimensions(title)
            val titleBounds = DoubleRectangle(geomAreaBounds.origin.x, 0.0, titleSize.x, titleSize.y)
            titleLabel.moveTo(DoubleVector(titleBounds.left, titleBounds.center.y))
            add(titleLabel)

            @Suppress("ConstantConditionIf")
            if (DEBUG_DRAWING) {
                val rect = SvgRectElement(titleBounds)
                rect.strokeColor().set(Color.BLUE)
                rect.strokeWidth().set(1.0)
                rect.fillOpacity().set(0.0)
                add(rect)
            }
        }

        // add axis titles
        if (isAxisEnabled) {
            if (hasAxisTitleLeft()) {
                createAxisTitle(
                    axisTitleLeft,
                    Orientation.LEFT,
                    withoutTitleAndLegends,
                    geomAreaBounds
                )
            }
            if (hasAxisTitleBottom()) {
                createAxisTitle(
                    axisTitleBottom,
                    Orientation.BOTTOM,
                    withoutTitleAndLegends,
                    geomAreaBounds
                )
            }
        }

        // add legends
        if (boxesLayoutResult != null) {
            for (boxWithLocation in boxesLayoutResult.boxWithLocationList) {
                val legendBox = boxWithLocation.legendBox.createLegendBox()
                legendBox.moveTo(boxWithLocation.location)
                add(legendBox)
            }
        }
    }

    fun createTooltipSpecs(plotCoord: DoubleVector): List<TooltipSpec> {
        return myTooltipHelper.createTooltipSpecs(plotCoord)
    }

    fun getTooltipBounds(plotCoord: DoubleVector): PlotTooltipBounds? {
        return myTooltipHelper.getTooltipBounds(plotCoord)
    }

    companion object {
        private val LOG = PortableLogging.logger(Plot::class)

        private val DEF_PLOT_SIZE = DoubleVector(600.0, 400.0)
        private const val DEBUG_DRAWING = PLOT_DEBUG_DRAWING
    }
}
