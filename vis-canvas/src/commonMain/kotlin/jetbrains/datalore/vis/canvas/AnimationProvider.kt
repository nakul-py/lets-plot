/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.vis.canvas

interface AnimationProvider {
    fun createAnimationTimer(eventHandler: AnimationEventHandler): AnimationTimer

    interface AnimationTimer {
        fun start()
        fun stop()
    }

    interface AnimationEventHandler {
        fun onEvent(millisTime: Long): Boolean

        companion object {
            fun toHandler(predicate: (Long) -> Boolean): AnimationEventHandler {
                return object : AnimationEventHandler {
                    override fun onEvent(millisTime: Long) = predicate(millisTime)
                }
            }
        }
    }
}