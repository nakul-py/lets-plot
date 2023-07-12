/*
 * Copyright (c) 2021. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.livemap.mapengine

import org.jetbrains.letsPlot.commons.geometry.DoubleVector
import org.jetbrains.letsPlot.core.canvas.CanvasProvider
import org.jetbrains.letsPlot.core.canvas.Context2d
import jetbrains.livemap.ClientPoint
import jetbrains.livemap.core.graphics.RenderObject
import jetbrains.livemap.mapengine.viewport.Viewport

open class MapRenderContext internal constructor(
    open val viewport: Viewport,
    val canvasProvider: CanvasProvider
) {

    fun draw(context: Context2d, origin: ClientPoint, renderObject: RenderObject) {
        draw(context, origin.x, origin.y, renderObject)
    }

    fun draw(context: Context2d, origin: DoubleVector, renderObject: RenderObject) {
        draw(context, origin.x, origin.y, renderObject)
    }

    private fun draw(context: Context2d, x: Double, y: Double, renderObject: RenderObject) {
        context.save()
        context.translate(x, y)
        renderObject.render(context)
        context.restore()
    }
}