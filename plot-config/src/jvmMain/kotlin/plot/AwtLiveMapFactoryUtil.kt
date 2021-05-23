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
import jetbrains.datalore.vis.svg.SvgSvgElement
import java.awt.Cursor
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

internal object AwtLiveMapFactoryUtil {
    fun buildLiveMapComponent(
        assembler: PlotAssembler,
        processedSpec: MutableMap<String, Any>,
        preferredSize: ReadableProperty<DoubleVector>,
        svgComponentFactory: (svg: SvgSvgElement) -> JComponent,
        executor: (() -> Unit) -> Unit
    ): DisposableJPanel {
        val cursorServiceConfig = CursorServiceConfig()
        injectLiveMapProvider(assembler, processedSpec, cursorServiceConfig)

        val plot = assembler.createPlot()
        val plotContainer = PlotContainer(plot, preferredSize)
        val plotComponent = AwtPlotFactoryUtil.buildPlotComponent(
            plotContainer,
            svgComponentFactory,
            executor
        )

        @Suppress("UNCHECKED_CAST")
        return AwtLiveMapPanel(
            plotContainer,
            plotComponent,
            executor,
            cursorServiceConfig
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