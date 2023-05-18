/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.livemap.geometry

import jetbrains.datalore.base.typedGeometry.minus
import jetbrains.livemap.Client
import jetbrains.livemap.World
import jetbrains.livemap.core.Transforms
import jetbrains.livemap.core.ecs.AbstractSystem
import jetbrains.livemap.core.ecs.EcsComponentManager
import jetbrains.livemap.core.ecs.EcsEntity
import jetbrains.livemap.core.layers.ParentLayerComponent
import jetbrains.livemap.core.layers.ParentLayerComponent.Companion.tagDirtyParentLayer
import jetbrains.livemap.core.multitasking.MicroTask
import jetbrains.livemap.core.multitasking.MicroThreadComponent
import jetbrains.livemap.core.multitasking.map
import jetbrains.livemap.mapengine.LiveMapContext
import jetbrains.livemap.mapengine.placement.WorldOriginComponent


class WorldGeometry2ScreenUpdateSystem(
    private val myQuantIterations: Int,
    componentManager: EcsComponentManager
) : AbstractSystem<LiveMapContext>(componentManager) {

    private fun createScalingTask(entity: EcsEntity, zoom: Int): MicroTask<Unit> {
        val worldOrigin = entity.get<WorldOriginComponent>().origin
        val zoomProjection = Transforms.zoom<World, Client> { zoom }
        return MicroTasks
            .transform(entity.get<WorldGeometryComponent>().geometry!!) {
                zoomProjection.apply(it - worldOrigin)
            }
            .map { screenGeometry ->
                runLaterBySystem(entity) { theEntity ->
                    tagDirtyParentLayer(theEntity)
                    theEntity.provide(::ScreenGeometryComponent).apply {
                        geometry = screenGeometry
                        this.zoom = zoom
                    }
                }
            }
    }

    override fun updateImpl(context: LiveMapContext, dt: Double) {
        val viewport = context.mapRenderContext.viewport

        if (context.camera.isZoomLevelChanged) {
            getEntities(COMPONENT_TYPES).forEach {
                it.setComponent(
                    MicroThreadComponent(
                        createScalingTask(it, viewport.zoom),
                        myQuantIterations
                    )
                )
            }
        }
    }

    companion object {
        private val COMPONENT_TYPES = listOf(
            WorldOriginComponent::class,
            WorldGeometryComponent::class,
            ParentLayerComponent::class
        )
    }
}
