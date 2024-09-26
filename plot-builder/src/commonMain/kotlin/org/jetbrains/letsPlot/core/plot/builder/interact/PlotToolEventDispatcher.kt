/*
 * Copyright (c) 2024. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package org.jetbrains.letsPlot.core.plot.builder.interact

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.jetbrains.letsPlot.commons.debounce
import org.jetbrains.letsPlot.commons.geometry.DoubleRectangle
import org.jetbrains.letsPlot.commons.registration.Registration
import org.jetbrains.letsPlot.core.interact.DrawRectFeedback
import org.jetbrains.letsPlot.core.interact.PanGeomFeedback
import org.jetbrains.letsPlot.core.interact.PanGeomFeedback.PanningMode
import org.jetbrains.letsPlot.core.interact.RollbackAllChangesFeedback
import org.jetbrains.letsPlot.core.interact.WheelZoomFeedback
import org.jetbrains.letsPlot.core.interact.event.ToolEventDispatcher
import org.jetbrains.letsPlot.core.interact.event.ToolEventDispatcher.Companion.ORIGIN_FIGURE_IMPLICIT
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.EVENT_INTERACTION_NAME
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.EVENT_INTERACTION_ORIGIN
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.EVENT_NAME
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.EVENT_RESULT_DATA_BOUNDS
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.INTERACTION_ACTIVATED
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.INTERACTION_DEACTIVATED
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.ROLLBACK_ALL_CHANGES
import org.jetbrains.letsPlot.core.interact.event.ToolEventSpec.SELECTION_CHANGED
import org.jetbrains.letsPlot.core.interact.event.ToolInteractionSpec
import org.jetbrains.letsPlot.core.interact.event.ToolInteractionSpec.ZoomBoxMode
import org.jetbrains.letsPlot.core.plot.builder.PlotInteractor


internal class PlotToolEventDispatcher(
    private val plotInteractor: PlotInteractor
) : ToolEventDispatcher {

    private val interactionsByOrigin: MutableMap<
            String,                 // origin
            MutableList<InteractionInfo>> = HashMap()

    private lateinit var toolEventCallback: (Map<String, Any>) -> Unit

    override fun initToolEventCallback(callback: (Map<String, Any>) -> Unit) {
        check(!this::toolEventCallback.isInitialized) { "Repeated initialization of 'toolEventCallback'." }
        toolEventCallback = callback
    }

    override fun activateInteractions(origin: String, interactionSpecList: List<Map<String, Any>>) {
        interactionSpecList.forEach { interactionSpec ->
            activateInteraction(origin, interactionSpec)
        }
    }

    private fun activateInteraction(origin: String, interactionSpec: Map<String, Any>) {
        deactivateOverlappingInteractions(origin, interactionSpec)

        val interactionName = interactionSpec.getValue(ToolInteractionSpec.NAME) as String
        val fireSelectionChangedDebounced =
            debounce<DoubleRectangle>(DEBOUNCE_DELAY_MS, CoroutineScope(Dispatchers.Default)) { dataBounds ->
                println("Debounced interaction: $interactionName, dataBounds: $dataBounds")
                val dataBoundsLTRB = listOf(dataBounds.left, dataBounds.top, dataBounds.right, dataBounds.bottom)
                fireSelectionChanged(origin, interactionName, dataBoundsLTRB)
            }

        val feedback = when (interactionName) {
            ToolInteractionSpec.DRAG_PAN -> PanGeomFeedback(
                onCompleted = { dataBounds, flipped, panningMode ->
                    println("Pan tool: apply $dataBounds, flipped: $flipped, mode: $panningMode")
                    // flip panning mode maybe
                    @Suppress("NAME_SHADOWING")
                    val panningMode = if (!flipped) {
                        panningMode
                    } else when (panningMode) {
                        PanningMode.FREE -> panningMode
                        PanningMode.HORIZONTAL -> PanningMode.VERTICAL
                        PanningMode.VERTICAL -> PanningMode.HORIZONTAL
                    }
                    val dataBoundsLTRB = when (panningMode) {
                        PanningMode.FREE -> listOf(dataBounds.left, dataBounds.top, dataBounds.right, dataBounds.bottom)
                        PanningMode.HORIZONTAL -> listOf(dataBounds.left, null, dataBounds.right, null)
                        PanningMode.VERTICAL -> listOf(null, dataBounds.top, null, dataBounds.bottom)
                    }
                    fireSelectionChanged(origin, interactionName, dataBoundsLTRB)
                }
            )

            ToolInteractionSpec.BOX_ZOOM -> {
                val centerStart = interactionSpec[ToolInteractionSpec.ZOOM_BOX_MODE] == ZoomBoxMode.CENTER_START
                DrawRectFeedback(centerStart) { dataBounds ->
                    println("client: data $dataBounds")
                    val dataBoundsLTRB = listOf(dataBounds.left, dataBounds.top, dataBounds.right, dataBounds.bottom)
                    fireSelectionChanged(origin, interactionName, dataBoundsLTRB)
                }
            }

            ToolInteractionSpec.WHEEL_ZOOM -> WheelZoomFeedback(
                onCompleted = { dataBounds ->
                    fireSelectionChangedDebounced(dataBounds)
                }
            )

            ToolInteractionSpec.ROLLBACK_ALL_CHANGES -> RollbackAllChangesFeedback(
                onAction = {
                    toolEventCallback.invoke(
                        mapOf(
                            EVENT_NAME to ROLLBACK_ALL_CHANGES,
                            EVENT_INTERACTION_ORIGIN to origin,
                            EVENT_INTERACTION_NAME to interactionName,
                        )
                    )
                }
            )

            else -> {
                // ToDo: send an error event
                throw IllegalStateException("Unsupported interaction: $interactionName")
            }
        }

        val feedbackRegistration = plotInteractor.startToolFeedback(feedback)
        interactionsByOrigin.getOrPut(origin) { ArrayList() }.add(
            InteractionInfo(
                interactionSpec = interactionSpec,
                feedbackReg = feedbackRegistration
            )
        )

        toolEventCallback.invoke(
            mapOf(
                EVENT_NAME to INTERACTION_ACTIVATED,
                EVENT_INTERACTION_ORIGIN to origin,
                EVENT_INTERACTION_NAME to interactionName
            )
        )
    }

    private fun fireSelectionChanged(
        origin: String,
        interactionName: String,
        dataBoundsLTRB: List<Double?>
    ) {
        toolEventCallback.invoke(
            mapOf(
                EVENT_NAME to SELECTION_CHANGED,
                EVENT_INTERACTION_ORIGIN to origin,
                EVENT_INTERACTION_NAME to interactionName,
                EVENT_RESULT_DATA_BOUNDS to dataBoundsLTRB
            )
        )
    }

    override fun deactivateInteractions(origin: String) {
        interactionsByOrigin.remove(origin)?.forEach { interactionInfo ->
            interactionInfo.feedbackReg.dispose()
            toolEventCallback.invoke(
                mapOf(
                    EVENT_NAME to INTERACTION_DEACTIVATED,
                    EVENT_INTERACTION_ORIGIN to origin,
                    EVENT_INTERACTION_NAME to interactionInfo.interactionName
                )
            )
        }
    }

    override fun deactivateAllSilently(): Map<String, List<Map<String, Any>>> {
        val deactivatedInteractions = interactionsByOrigin.mapValues { (_, interactionInfoList) ->
            interactionInfoList.map {
                it.feedbackReg.dispose()
                it.interactionSpec
            }
        }
        interactionsByOrigin.clear()
        return deactivatedInteractions
    }

    private fun deactivateOverlappingInteractions(
        originBeingActivated: String,
        interactionSpecBeingActivated: Map<String, Any>
    ) {
        // Special case
        if (originBeingActivated == ORIGIN_FIGURE_IMPLICIT) {
            // 'implicit' interactions are always compatible
            return
        }

        // For now just deactivate all active interactions
        ArrayList(interactionsByOrigin.keys)
            .filterNot { origin -> origin == originBeingActivated }
            .filterNot { origin -> origin == ORIGIN_FIGURE_IMPLICIT } // 'implicit' interactions are always compatible
            .forEach { origin -> deactivateInteractions(origin) }
    }

    private class InteractionInfo(
        val interactionSpec: Map<String, Any>,
        val feedbackReg: Registration
    ) {
        val interactionName = interactionSpec.getValue(ToolInteractionSpec.NAME) as String
    }

    companion object {
        private const val DEBOUNCE_DELAY_MS = 30L
    }
}