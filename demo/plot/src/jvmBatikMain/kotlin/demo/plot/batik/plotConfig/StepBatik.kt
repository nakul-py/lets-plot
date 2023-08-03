/*
 * Copyright (c) 2023. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package demo.plot.batik.plotConfig

import demo.common.batik.demoUtils.PlotSpecsDemoWindowBatik
import demo.plot.common.model.plotConfig.Step

fun main() {
    with(Step()) {
        PlotSpecsDemoWindowBatik(
            "Step plot",
            plotSpecList()
        ).open()
    }
}