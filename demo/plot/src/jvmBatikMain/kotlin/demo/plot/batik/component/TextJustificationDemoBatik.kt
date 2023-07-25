/*
 * Copyright (c) 2022. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package demo.plot.batik.component

import demo.plot.shared.model.component.TextJustificationDemo
import demo.common.batik.demoUtils.SvgViewerDemoWindowBatik

fun main() {
    with(TextJustificationDemo()) {
        SvgViewerDemoWindowBatik(
            "Text justifications (Batik)",
            createSvgRoots(listOf(createModel()))
        ).open()
    }
}