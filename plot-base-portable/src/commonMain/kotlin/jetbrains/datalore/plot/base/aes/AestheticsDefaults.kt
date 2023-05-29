/*
 * Copyright (c) 2020. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.base.aes

import jetbrains.datalore.base.typedKey.TypedKeyHashMap
import jetbrains.datalore.base.values.Color
import jetbrains.datalore.plot.base.Aes
import jetbrains.datalore.plot.base.render.point.NamedShape

open class AestheticsDefaults {

    private val myDefaults = TypedKeyHashMap().apply {
        for (aes in Aes.values()) {
            // Safe cast because AesInitValue.get(aes) is guaranteed to return correct type.
            @Suppress("UNCHECKED_CAST")
            put(aes as Aes<Any>, AesInitValue[aes])
        }
    }
    private val myDefaultsInLegend = TypedKeyHashMap()

    protected fun <T> update(aes: Aes<T>, defaultValue: T): AestheticsDefaults {
        myDefaults.put(aes, defaultValue)
        return this
    }

    protected fun <T> updateInLegend(aes: Aes<T>, defaultValue: T): AestheticsDefaults {
        myDefaultsInLegend.put(aes, defaultValue)
        return this
    }

    fun <T> defaultValue(aes: Aes<T>): T {
        return myDefaults[aes]
    }

    fun <T> defaultValueInLegend(aes: Aes<T>): T {
        return if (myDefaultsInLegend.containsKey(aes)) {
            myDefaultsInLegend[aes]
        } else {
            defaultValue(aes)
        }
    }

    companion object {
        fun point(): AestheticsDefaults {
            return base()
                .update(Aes.SIZE, 2.0)
                .updateInLegend(Aes.SIZE, 5.0)
        }

        fun path(): AestheticsDefaults {
            return base()
        }

        fun line(): AestheticsDefaults {
            return path()
        }

        fun abline(): AestheticsDefaults {
            return path()
        }

        fun hline(): AestheticsDefaults {
            return path()
        }

        fun vline(): AestheticsDefaults {
            return path()
        }

        fun smooth(): AestheticsDefaults {
            return path()
                .update(Aes.COLOR, Color.MAGENTA)
                .update(Aes.FILL, Color.BLACK)
        }

        fun bar(): AestheticsDefaults {
            return base()
                .update(Aes.WIDTH, 0.9)
                .update(Aes.COLOR, Color.TRANSPARENT)    // no outline (transparent)
        }

        fun histogram(): AestheticsDefaults {
            return base()
                .update(Aes.COLOR, Color.TRANSPARENT)    // no outline (transparent)
        }

        fun dotplot(): AestheticsDefaults {
            return AestheticsDefaults()
                .update(Aes.COLOR, Color.TRANSPARENT)    // no outline (transparent)
                .updateInLegend(Aes.SIZE, 5.0)
        }

        fun tile(): AestheticsDefaults {
            return AestheticsDefaults()
                .update(Aes.COLOR, Color.TRANSPARENT)    // no outline (transparent)
        }

        fun bin2d(): AestheticsDefaults {
            return tile()
        }

        fun errorBar(): AestheticsDefaults {
            return AestheticsDefaults()
                .update(Aes.COLOR, Color.BLACK)
                .update(Aes.WIDTH, 0.45)
                .update(Aes.HEIGHT, 0.45)
        }

        fun crossBar(): AestheticsDefaults {
            return AestheticsDefaults()
                .update(Aes.WIDTH, 0.9)
                .update(Aes.COLOR, Color.BLACK)
                .update(Aes.FILL, Color.WHITE)
        }

        fun lineRange(): AestheticsDefaults {
            return path()
        }

        fun pointRange(): AestheticsDefaults {
            return path()
        }

        fun polygon(): AestheticsDefaults {
            return base()
                .update(Aes.COLOR, Color.TRANSPARENT)    // no outline (transparent)
        }

        fun map(): AestheticsDefaults {
            return base()
                .update(Aes.SIZE, 0.2)                    // outline thickness
                .update(Aes.COLOR, Color.GRAY)
                .update(Aes.FILL, Color.TRANSPARENT)
        }

        fun boxplot(): AestheticsDefaults {
            return crossBar()
        }

        fun areaRidges(): AestheticsDefaults {
            return base()
                .update(Aes.COLOR, Color.BLACK)
                .update(Aes.FILL, Color.parseHex("#8CBBE4"))
        }

        fun violin(): AestheticsDefaults {
            return AestheticsDefaults()
                .update(Aes.COLOR, Color.BLACK)
                .update(Aes.FILL, Color.WHITE)
        }

        fun ydotplot(): AestheticsDefaults {
            return AestheticsDefaults()
                .update(Aes.COLOR, Color.TRANSPARENT)    // no outline (transparent)
                .updateInLegend(Aes.SIZE, 5.0)
        }

        fun livemap(): AestheticsDefaults {
            return base()
        }

        fun ribbon(): AestheticsDefaults {
            return base()
        }

        fun area(): AestheticsDefaults {
            return base()
        }

        fun density(): AestheticsDefaults {
            return area()
                .update(Aes.FILL, Color.TRANSPARENT)
        }

        fun contour(): AestheticsDefaults {
            return path()
        }

        fun contourf(): AestheticsDefaults {
            return base()
                .update(Aes.SIZE, 0.0)
        }

        fun density2d(): AestheticsDefaults {
            return contour()
        }

        fun density2df(): AestheticsDefaults {
            return contourf()
        }

        fun jitter(): AestheticsDefaults {
            return point()
        }

        fun qq(): AestheticsDefaults {
            return point()
        }

        fun qq2(): AestheticsDefaults {
            return point()
        }

        fun qq_line(): AestheticsDefaults {
            return path()
        }

        fun qq2_line(): AestheticsDefaults {
            return path()
        }

        fun freqpoly(): AestheticsDefaults {
            return area()
        }

        fun step(): AestheticsDefaults {
            return path()
        }

        fun rect(): AestheticsDefaults {
            return polygon()
        }

        fun segment(): AestheticsDefaults {
            return path()
        }

        fun text(): AestheticsDefaults {
            return base()
                .update(Aes.SIZE, 7.0)
                .update(Aes.COLOR, Color.parseHex("#3d3d3d")) // dark gray
                .updateInLegend(Aes.FILL, Color.TRANSPARENT)
        }

        fun label(): AestheticsDefaults {
            return text()
                .update(Aes.FILL, Color.WHITE)
        }

        fun raster(): AestheticsDefaults {
            return base()
        }

        fun image(): AestheticsDefaults {
            return base()
        }

        fun pie(): AestheticsDefaults {
            return base()
                .update(Aes.SIZE, 10.0)
                .updateInLegend(Aes.SIZE, 1.0)
                .updateInLegend(Aes.FILL, Color.TRANSPARENT)
                .updateInLegend(Aes.COLOR, Color.TRANSPARENT)
        }

        fun lollipop(): AestheticsDefaults {
            return point()
                .update(Aes.SHAPE, NamedShape.STICK_CIRCLE)
                .update(Aes.STROKE, 1.0)
        }

        private fun base(): AestheticsDefaults {
            return AestheticsDefaults()
        }
    }
}
