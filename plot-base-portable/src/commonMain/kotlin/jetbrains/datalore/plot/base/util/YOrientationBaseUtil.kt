/*
 * Copyright (c) 2022. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.base.util

import jetbrains.datalore.plot.base.Aes
import jetbrains.datalore.plot.base.aes.AesVisitor

fun <T> Aes<T>.afterOrientation(yOrientation: Boolean): Aes<T> {
    return when (yOrientation) {
        true -> YOrientationBaseUtil.flipAes(this)
        false -> this
    }
}

fun List<Aes<*>>.afterOrientation(yOrientation: Boolean): List<Aes<*>> {
    return this.map { it.afterOrientation(yOrientation) }
}

fun Set<Aes<*>>.afterOrientation(yOrientation: Boolean): Set<Aes<*>> {
    return this.map { it.afterOrientation(yOrientation) }.toSet()
}


object YOrientationBaseUtil {
    private val AES_FLIPPER = AesFlipper()

    fun <T> flipAesKeys(map: Map<Aes<*>, T>): Map<Aes<*>, T> {
        return map.mapKeys { (aes, _) ->
            AES_FLIPPER.visit(aes)
        }
    }

    fun <T> flipAes(aes: Aes<T>): Aes<T> {
        @Suppress("UNCHECKED_CAST")
        return AES_FLIPPER.visit(aes) as Aes<T>
    }

    private class AesFlipper : AesVisitor<Aes<*>>() {

        override fun x(): Aes<*> {
            return Aes.Y
        }

        override fun y(): Aes<*> {
            return Aes.X
        }

        override fun ymin(): Aes<*> {
            return Aes.XMIN
        }

        override fun ymax(): Aes<*> {
            return Aes.XMAX
        }

        override fun xmin(): Aes<*> {
            return Aes.YMIN
        }

        override fun xmax(): Aes<*> {
            return Aes.YMAX
        }

        override fun xend(): Aes<*> {
            return Aes.YEND
        }

        override fun yend(): Aes<*> {
            return Aes.XEND
        }

        override fun symX(): Aes<*> {
            return Aes.SYM_Y
        }

        override fun symY(): Aes<*> {
            return Aes.SYM_X
        }

        override fun interceptX(): Aes<*> {
            return Aes.YINTERCEPT
        }

        override fun interceptY(): Aes<*> {
            return Aes.XINTERCEPT
        }


        //
        // The rest of Aes are not flippable.
        //

        override fun width(): Aes<*> {
            return Aes.WIDTH
        }

        override fun height(): Aes<*> {
            return Aes.HEIGHT
        }

        override fun z(): Aes<*> {
            return Aes.Z
        }

        override fun color(): Aes<*> {
            return Aes.COLOR
        }

        override fun fill(): Aes<*> {
            return Aes.FILL
        }

        override fun alpha(): Aes<*> {
            return Aes.ALPHA
        }

        override fun shape(): Aes<*> {
            return Aes.SHAPE
        }

        override fun lineType(): Aes<*> {
            return Aes.LINETYPE
        }

        override fun size(): Aes<*> {
            return Aes.SIZE
        }

        override fun stacksize(): Aes<*> {
            return Aes.STACKSIZE
        }

        override fun binwidth(): Aes<*> {
            return Aes.BINWIDTH
        }

        override fun violinwidth(): Aes<*> {
            return Aes.VIOLINWIDTH
        }

        override fun weight(): Aes<*> {
            return Aes.WEIGHT
        }

        override fun intercept(): Aes<*> {
            return Aes.INTERCEPT
        }

        override fun slope(): Aes<*> {
            return Aes.SLOPE
        }

        override fun lower(): Aes<*> {
            return Aes.LOWER
        }

        override fun middle(): Aes<*> {
            return Aes.MIDDLE
        }

        override fun upper(): Aes<*> {
            return Aes.UPPER
        }

        override fun mapId(): Aes<*> {
            return Aes.MAP_ID
        }

        override fun frame(): Aes<*> {
            return Aes.FRAME
        }

        override fun speed(): Aes<*> {
            return Aes.SPEED
        }

        override fun flow(): Aes<*> {
            return Aes.FLOW
        }

        override fun label(): Aes<*> {
            return Aes.LABEL
        }

        override fun family(): Aes<*> {
            return Aes.FAMILY
        }

        override fun fontface(): Aes<*> {
            return Aes.FONTFACE
        }

        override fun hjust(): Aes<*> {
            return Aes.HJUST
        }

        override fun vjust(): Aes<*> {
            return Aes.VJUST
        }

        override fun angle(): Aes<*> {
            return Aes.ANGLE
        }
    }
}