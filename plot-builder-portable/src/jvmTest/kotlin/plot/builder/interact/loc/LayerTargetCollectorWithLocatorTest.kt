/*
 * Copyright (c) 2020. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.builder.interact.loc

import org.jetbrains.letsPlot.commons.geometry.DoubleRectangle
import org.jetbrains.letsPlot.commons.geometry.DoubleVector
import org.jetbrains.letsPlot.commons.values.Color
import jetbrains.datalore.plot.base.Aes
import jetbrains.datalore.plot.base.DataFrame
import jetbrains.datalore.plot.base.GeomKind
import jetbrains.datalore.plot.base.interact.GeomTargetCollector.TooltipParams
import jetbrains.datalore.plot.base.interact.GeomTargetLocator
import jetbrains.datalore.plot.base.interact.MappedDataAccess
import jetbrains.datalore.plot.builder.interact.GeomInteraction
import jetbrains.datalore.plot.builder.interact.GeomInteractionBuilder
import org.mockito.Mockito
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class LayerTargetCollectorWithLocatorTest {

    @Test
    fun `add point to targets`() {
        val targetLocator = addPointToTargets(point = POINT, radius = 10.0, color = Color.BLACK)
        val lookupResult = targetLocator.search(POINT)
        assertNotNull(lookupResult)
    }

    @Test
    fun `invisible point should not be added to targets`() {
        // assert zero radius
        run {
            val targetLocator = addPointToTargets(point = POINT, radius = 0.0, color = Color.BLACK)
            val lookupResult = targetLocator.search(POINT)
            assertNull(lookupResult)
        }

        // assert alpha
        run {
            val targetLocator = addPointToTargets(point = POINT, radius = 10.0, color = Color.TRANSPARENT)
            val lookupResult = targetLocator.search(POINT)
            assertNull(lookupResult)
        }
    }

    @Test
    fun `add rectangle to targets`() {
        val targetLocator = addRectangleToTargets(
            rect = DoubleRectangle(POINT, dimension = DoubleVector(10.0, 10.0)),
            color = Color.BLACK
        )
        val lookupResult = targetLocator.search(POINT)
        assertNotNull(lookupResult)
    }

    @Test
    fun `invisible rect should not be added to targets`() {
        // assert zero dimension
        run {
            val targetLocator = addRectangleToTargets(
                rect = DoubleRectangle(POINT, dimension = DoubleVector.ZERO),
                color = Color.BLACK
            )
            val lookupResult = targetLocator.search(POINT)
            assertNull(lookupResult)
        }

        // assert alpha
        run {
            val targetLocator = addRectangleToTargets(
                rect = DoubleRectangle(POINT, dimension = DoubleVector(10.0, 10.0)),
                color = Color.TRANSPARENT
            )
            val lookupResult = targetLocator.search(POINT)
            assertNull(lookupResult)
        }
    }

    companion object {
        val POINT = DoubleVector.ZERO

        private fun addPointToTargets(point: DoubleVector, radius: Double, color: Color): GeomTargetLocator {
            return createTargetCollectorWithLocator(GeomKind.POINT).apply {
                addPoint(
                    index = 0,
                    point = point,
                    radius = radius,
                    tooltipParams = TooltipParams(
                        markerColors = listOf(color)
                    )
                )
            }
        }

        private fun addRectangleToTargets(rect: DoubleRectangle, color: Color): GeomTargetLocator {
            return createTargetCollectorWithLocator(GeomKind.RECT).apply {
                addRectangle(
                    index = 0,
                    rectangle = rect,
                    tooltipParams = TooltipParams(
                        markerColors = listOf(color)
                    )
                )
            }
        }

        private fun createGeomInteractionBuilder(area: Boolean): GeomInteraction {
            return GeomInteractionBuilder.DemoAndTest(Aes.values())
                .bivariateFunction(area)
                .ignoreInvisibleTargets(true)
                .build()
        }

        private fun createTargetCollectorWithLocator(geomKind: GeomKind): LayerTargetCollectorWithLocator {
            val builder = createGeomInteractionBuilder(area = geomKind == GeomKind.RECT)
            val contextualMapping = builder.createContextualMapping(
                dataAccess = Mockito.mock(MappedDataAccess::class.java),
                dataFrame = DataFrame.Builder().build()
            )
            return LayerTargetCollectorWithLocator(
                geomKind = geomKind,
                lookupSpec = builder.createLookupSpec(),
                contextualMapping = contextualMapping
            )
        }
    }
}