/*
 * Copyright (c) 2023. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package demo.plot.batik.customErrorComponent

import org.jetbrains.letsPlot.batik.plot.component.DefaultPlotComponentProviderBatik
import javax.swing.JComponent

class MyPlotComponentProviderBatik(
    processedSpec: MutableMap<String, Any>,
    preserveAspectRatio: Boolean,
    executor: (() -> Unit) -> Unit,
    computationMessagesHandler: (List<String>) -> Unit
) : DefaultPlotComponentProviderBatik(
    processedSpec = processedSpec,
    preserveAspectRatio = preserveAspectRatio,
    executor = executor,
    computationMessagesHandler = computationMessagesHandler
) {

    override fun createPlotErrorMessageComponent(errorMessage: String): JComponent {
        return MyErrorMessageComponent(errorMessage)
    }
}