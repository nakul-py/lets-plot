/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.livemap.core

import kotlin.math.roundToLong

actual open class SystemTime actual constructor() {

    actual open fun getTimeMs(): Long {
        return (System.nanoTime() / 1_000_000.0).roundToLong()
    }
}