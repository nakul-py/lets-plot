/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.common.text

import jetbrains.datalore.base.unsupported.UNSUPPORTED

actual object DateTimeFormatUtil {
    actual fun formatDateUTC(instant: Number, pattern: String): String {
        UNSUPPORTED("DateTimeFormatUtil.formatDateUTC")
    }
}
