/*
 * Copyright (c) 2021. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot

import jetbrains.datalore.base.event.MouseEventSpec
import jetbrains.datalore.base.event.awt.AwtEventUtil
import jetbrains.datalore.base.geometry.DoubleVector
import jetbrains.datalore.base.observable.property.ReadableProperty
import jetbrains.datalore.plot.builder.PlotContainer
import jetbrains.datalore.plot.builder.assemble.PlotAssembler
import jetbrains.datalore.plot.config.LiveMapOptionsParser
import jetbrains.datalore.plot.livemap.CursorServiceConfig
import jetbrains.datalore.plot.livemap.LiveMapUtil
import jetbrains.datalore.vis.canvasFigure.CanvasFigure
import jetbrains.datalore.vis.svg.SvgSvgElement
import java.awt.Cursor
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

object AwtLiveMapFactoryUtil {
    fun buildLiveMapComponent(
        assembler: PlotAssembler,
        processedSpec: MutableMap<String, Any>,
        preferredSize: ReadableProperty<DoubleVector>,
        svgComponentFactory: (svg: SvgSvgElement) -> JComponent,
        executor: (() -> Unit) -> Unit
    ): JComponent {
        val cursorServiceConfig = CursorServiceConfig()
        injectLiveMapProvider(assembler, processedSpec, cursorServiceConfig)

        val plot = assembler.createPlot()
        val plotContainer = PlotContainer(plot, preferredSize)
        val plotComponent = AwtPlotFactory.buildPlotComponent(
            plotContainer,
            svgComponentFactory,
            executor
        )

        // Move tooltip when map moved
        plotComponent.addMouseMotionListener(object : MouseAdapter() {
            override fun mouseDragged(e: MouseEvent) {
                super.mouseDragged(e)
                executor {
                    plotContainer.mouseEventPeer.dispatch(MouseEventSpec.MOUSE_MOVED, AwtEventUtil.translate(e))
                }
            }
        })

        cursorServiceConfig.defaultSetter { plotComponent.cursor = Cursor.getDefaultCursor() }
        cursorServiceConfig.pointerSetter { plotComponent.cursor = Cursor(Cursor.HAND_CURSOR) }

        @Suppress("UNCHECKED_CAST")
//        return buildPlotLiveMapComponent(
//            plotContainer.liveMapFigures as List<CanvasFigure>,
//            plotComponent,
//            preferredSize.get()
//        )
        return AwtLiveMapPanel(
            plotContainer.liveMapFigures as List<CanvasFigure>,
            plotComponent,
            preferredSize.get()
        )
    }

    private fun injectLiveMapProvider(
        plotAssembler: PlotAssembler,
        processedPlotSpec: MutableMap<String, Any>,
        cursorServiceConfig: CursorServiceConfig
    ) {
        LiveMapOptionsParser.parseFromPlotSpec(processedPlotSpec)
            ?.let {
                LiveMapUtil.injectLiveMapProvider(
                    plotAssembler.layersByTile,
                    it,
                    cursorServiceConfig
                )
            }
    }
}