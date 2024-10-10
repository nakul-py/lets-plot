/*
 * Copyright (c) 2024. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package org.jetbrains.letsPlot.core.spec.vegalite

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.letsPlot.commons.intern.json.JsonSupport.parseJson
import org.jetbrains.letsPlot.core.plot.base.Aes
import org.jetbrains.letsPlot.core.plot.base.GeomKind
import org.jetbrains.letsPlot.core.spec.*
import org.jetbrains.letsPlot.core.spec.Option.GeomName.fromGeomKind
import org.jetbrains.letsPlot.core.spec.Option.Layer
import org.jetbrains.letsPlot.core.spec.Option.Mapping.toOption
import org.jetbrains.letsPlot.core.spec.Option.Meta
import org.jetbrains.letsPlot.core.spec.Option.Plot
import org.jetbrains.letsPlot.core.spec.Option.PlotBase
import org.jetbrains.letsPlot.core.spec.Option.Pos
import org.jetbrains.letsPlot.core.spec.Option.Stat
import org.jetbrains.letsPlot.core.spec.back.SpecTransformBackendUtil
import org.junit.Test
import java.util.Map.entry

class BarMarkTransformTest {

    @Test
    fun typeAsString() {
        val vegaSpec = parseJson(
            """
                |{
                |  "mark": "bar",
                |  
                |  "data": { "values": [ { "a": 1 } ]  },
                |  "encoding": { "x": { "field": "a" } }
                |}
        """.trimMargin()
        ).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(
                PlotBase.DATA, mapOf(
                    "a" to listOf(1.0)
                )
            ),
            entry(PlotBase.MAPPING, mapOf("x" to "a")),
            entry(Meta.DATA_META, mapOf(
                Meta.MappingAnnotation.TAG to listOf(
                    mapOf(
                        Meta.MappingAnnotation.AES to toOption(Aes.X),
                        Meta.MappingAnnotation.ANNOTATION to Meta.MappingAnnotation.AS_DISCRETE,
                        Meta.MappingAnnotation.PARAMETERS to mapOf(
                            Meta.MappingAnnotation.LABEL to "a",
                            Meta.MappingAnnotation.ORDER to 1
                        )
                    )
                )
            )),
            entry(Layer.STAT, StatKind.IDENTITY.name.lowercase())
        )
    }

    @Test
    fun typeAsObject() {
        val vegaSpec = parseJson(
            """
                |{
                |  "mark": { "type": "bar" },
                |  
                |  "data": { "values": [ { "a": 1 } ]  },
                |  "encoding": { "x": { "field": "a" } }
                |}
        """.trimMargin()
        ).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(
                PlotBase.DATA, mapOf(
                    "a" to listOf(1.0)
                )
            ),
            entry(PlotBase.MAPPING, mapOf("x" to "a")),
            entry(Meta.DATA_META, mapOf(
                Meta.MappingAnnotation.TAG to listOf(
                    mapOf(
                        Meta.MappingAnnotation.AES to toOption(Aes.X),
                        Meta.MappingAnnotation.ANNOTATION to Meta.MappingAnnotation.AS_DISCRETE,
                        Meta.MappingAnnotation.PARAMETERS to mapOf(
                            Meta.MappingAnnotation.LABEL to "a",
                            Meta.MappingAnnotation.ORDER to 1
                        )
                    )
                )
            )),
            entry(Layer.STAT, StatKind.IDENTITY.name.lowercase())
        )
    }


    @Test
    fun relativeBarWidth() {
        val vegaSpec = parseJson(
            """
                |{
                |  "layer": [ {"mark": { "type": "bar", "width": { "band": 0.5 } } }],
                |  
                |  "data": { "values": [ { "a": 1 } ]  },
                |  "encoding": { "x": { "field": "a" } }
                |}
        """.trimMargin()
        ).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)
        assertThat(plotSpec.getMap(PlotBase.DATA)).isNull()
        assertThat(plotSpec.getMap(PlotBase.MAPPING)).isNull()
        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(PlotBase.MAPPING, mapOf("x" to "a")),
            entry(Meta.DATA_META, mapOf(Meta.MappingAnnotation.TAG to listOf(
                mapOf(
                    Meta.MappingAnnotation.AES to toOption(Aes.X),
                    Meta.MappingAnnotation.ANNOTATION to Meta.MappingAnnotation.AS_DISCRETE,
                    Meta.MappingAnnotation.PARAMETERS to mapOf(
                        Meta.MappingAnnotation.LABEL to "a",
                        Meta.MappingAnnotation.ORDER to 1
                    )
                )
            ))),
            entry(PlotBase.DATA, mapOf(
                "a" to listOf(1.0)
            )),
            entry(toOption(Aes.WIDTH), 0.5),
            entry(Layer.STAT, StatKind.IDENTITY.name.lowercase())
        )
    }

    @Test
    fun simpleHistogram() {
        val vegaSpec = parseJson(
            """
                |{
                |  "data": {"values": [ 
                |    {"v": 0}, {"v": 1}, {"v": 1}, {"v": 2}, {"v": 2}, {"v": 2}, {"v": 2}, {"v": 3}, {"v": 3}, {"v": 4} 
                |  ]},
                |  "mark": "bar",
                |  "encoding": {
                |    "x": {"bin": true, "field": "v", "type": "quantitative"},
                |    "y": {"aggregate": "count"}
                |  }
                |}
            """.trimMargin()
        ).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getMap(PlotBase.DATA)).isNull()
        assertThat(plotSpec.getMap(PlotBase.MAPPING)).isNull()
        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.HISTOGRAM)),
            entry(Layer.STAT, StatKind.BIN.name.lowercase()),
            entry(Meta.DATA_META, empty()),
            entry(
                PlotBase.DATA, mapOf(
                    "..count.." to listOf( 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 4.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0),
                    "v" to listOf( -0.023555555555555552, 0.11599999999999999, 0.25555555555555554, 0.3951111111111111, 0.5346666666666666, 0.6742222222222222, 0.8137777777777777, 0.9533333333333333, 1.0928888888888888, 1.2324444444444442, 1.3719999999999999, 1.5115555555555555, 1.651111111111111, 1.7906666666666664, 1.930222222222222, 2.0697777777777775, 2.2093333333333334, 2.3488888888888884, 2.4884444444444442, 2.628, 2.767555555555555, 2.907111111111111, 3.046666666666667, 3.186222222222222, 3.3257777777777777, 3.4653333333333327, 3.6048888888888886, 3.7444444444444445, 3.8839999999999995, 4.023555555555555)
                )
            ),
            entry(PlotBase.MAPPING, mapOf("x" to "v")),
        )
    }

    @Test
    fun barWithAggrCount() {
        val vegaSpec = parseJson(
            """
                |{
                |  "data": {"values": [ 
                |    {"v": 0, "g": 2}, {"v": 1, "g": 2}, {"v": 1, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 3, "g": 2}, {"v": 3, "g": 2}, {"v": 4, "g": 2} 
                |  ]},
                |  "mark": "bar",
                |  "encoding": {
                |    "x": {"field": "v"},
                |    "y": {"field": "g", "aggregate": "count"}
                |  }
                |}
            """.trimMargin()
        ).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getMap(PlotBase.DATA)).isNull()
        assertThat(plotSpec.getMap(PlotBase.MAPPING)).isNull()
        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(Meta.DATA_META, mapOf(
                Meta.MappingAnnotation.TAG to listOf(
                    mapOf(
                        Meta.MappingAnnotation.AES to toOption(Aes.X),
                        Meta.MappingAnnotation.ANNOTATION to Meta.MappingAnnotation.AS_DISCRETE,
                        Meta.MappingAnnotation.PARAMETERS to mapOf(
                            Meta.MappingAnnotation.LABEL to "v",
                            Meta.MappingAnnotation.ORDER to 1
                        )
                    )
                )
            )),
            entry(
                PlotBase.DATA, mapOf(
                    "g" to listOf(1.0, 2.0, 4.0, 2.0, 1.0),
                    "v" to listOf(0.0, 1.0, 2.0, 3.0, 4.0),
                )
            ),
            entry(PlotBase.MAPPING, mapOf(
                toOption(Aes.X) to "v",
                toOption(Aes.Y) to "g"
            )),
            entry(Layer.STAT, StatKind.COUNT.name.lowercase())
        )
    }


    @Test
    fun barWithAggrSum() {
        val vegaSpec = parseJson(
            """
                |{
                |  "data": {"values": [ 
                |    {"v": 0, "g": 2}, {"v": 1, "g": 2}, {"v": 1, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 3, "g": 2}, {"v": 3, "g": 2}, {"v": 4, "g": 2} 
                |  ]},
                |  "mark": "bar",
                |  "encoding": {
                |    "x": {"field": "v"},
                |    "y": {"field": "g", "aggregate": "sum"}
                |  }
                |}
            """.trimMargin()
        ).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getMap(PlotBase.DATA)).isNull()
        assertThat(plotSpec.getMap(PlotBase.MAPPING)).isNull()
        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(Meta.DATA_META, mapOf(
                Meta.MappingAnnotation.TAG to listOf(
                    mapOf(
                        Meta.MappingAnnotation.AES to toOption(Aes.X),
                        Meta.MappingAnnotation.ANNOTATION to Meta.MappingAnnotation.AS_DISCRETE,
                        Meta.MappingAnnotation.PARAMETERS to mapOf(
                            Meta.MappingAnnotation.LABEL to "v",
                            Meta.MappingAnnotation.ORDER to 1
                        )
                    )
                )
            )),
            entry(
                PlotBase.DATA, mapOf<String, List<Any?>>(
                    "..ymax.." to listOf(2.0, 2.0, 2.0, 2.0, 2.0),
                    "..ymin.." to listOf(2.0, 2.0, 2.0, 2.0, 2.0),
                    "v" to listOf(0.0, 1.0, 2.0, 3.0, 4.0),
                    "g" to listOf(2.0, 4.0, 8.0, 4.0, 2.0),
                )
            ),
            entry(PlotBase.MAPPING, mapOf(
                toOption(Aes.X) to "v",
                toOption(Aes.Y) to "g")
            ),
            entry(Layer.STAT, StatKind.SUMMARY.name.lowercase()),
            entry(Stat.Summary.FUN, Stat.Summary.Functions.SUM)
        )
    }

    @Test
    fun barWithAggrMean() {
        val vegaSpec = parseJson(
            """
                |{
                |  "data": {"values": [ 
                |    {"v": 0, "g": 2}, {"v": 1, "g": 2}, {"v": 1, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 2, "g": 2}, {"v": 3, "g": 2}, {"v": 3, "g": 2}, {"v": 4, "g": 2} 
                |  ]},
                |  "mark": "bar",
                |  "encoding": {
                |    "x": {"field": "v"},
                |    "y": {"field": "g", "aggregate": "mean"}
                |  }
                |}
            """.trimMargin()
        ).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getMap(PlotBase.DATA)).isNull()
        assertThat(plotSpec.getMap(PlotBase.MAPPING)).isNull()
        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(Meta.DATA_META, mapOf(
                Meta.MappingAnnotation.TAG to listOf(
                    mapOf(
                        Meta.MappingAnnotation.AES to toOption(Aes.X),
                        Meta.MappingAnnotation.ANNOTATION to Meta.MappingAnnotation.AS_DISCRETE,
                        Meta.MappingAnnotation.PARAMETERS to mapOf(
                            Meta.MappingAnnotation.LABEL to "v",
                            Meta.MappingAnnotation.ORDER to 1
                        )
                    )
                )
            )),
            entry(
                PlotBase.DATA, mapOf<String, List<Any?>>(
                    "..ymax.." to listOf(2.0, 2.0, 2.0, 2.0, 2.0),
                    "..ymin.." to listOf(2.0, 2.0, 2.0, 2.0, 2.0),
                    "v" to listOf(0.0, 1.0, 2.0, 3.0, 4.0),
                    "g" to listOf(2.0, 2.0, 2.0, 2.0, 2.0),
                )
            ),
            entry(PlotBase.MAPPING, mapOf(
                toOption(Aes.X) to "v",
                toOption(Aes.Y) to "g")
            ),
            entry(Layer.STAT, StatKind.SUMMARY.name.lowercase()),
            entry(Stat.Summary.FUN, Stat.Summary.Functions.MEAN)
        )
    }

    @Test
    fun defaultBarStatIsIdentity() {
        val vegaSpec = parseJson("""
            |{
            |    "description": "A simple bar chart with embedded data.",
            |    "data": {
            |        "values": [
            |        {"a": "A", "b": 28}, 
            |        {"a": "B", "b": 55}, 
            |        {"a": "C", "b": 43},
            |        {"a": "D", "b": 91}, 
            |        {"a": "E", "b": 81}, 
            |        {"a": "F", "b": 53},
            |        {"a": "G", "b": 19}, 
            |        {"a": "H", "b": 87}, 
            |        {"a": "I", "b": 52}
            |        ]
            |    },
            |    "mark": "bar",
            |    "encoding": {
            |        "x": {"field": "a", "type": "nominal", "axis": {"labelAngle": 0}},
            |        "y": {"field": "b", "type": "quantitative"}
            |    }
            |}
        """.trimMargin()).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getMap(PlotBase.DATA)).isNull()
        assertThat(plotSpec.getMap(PlotBase.MAPPING)).isNull()
        assertThat(plotSpec.getMaps(Plot.LAYERS)!![0].typed<String, Any?>()).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(Meta.DATA_META, empty()),
            entry(
                PlotBase.DATA, mapOf(
                    "a" to listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"),
                    "b" to listOf(28.0, 55.0, 43.0, 91.0, 81.0, 53.0, 19.0, 87.0, 52.0)
                )
            ),
            entry(PlotBase.MAPPING, mapOf(
                toOption(Aes.X) to "a",
                toOption(Aes.Y) to "b"
            )),
            entry(Layer.STAT, StatKind.IDENTITY.name.lowercase())
        )
    }

    @Test
    fun barColorMustBeMappedToFill() {
        val vegaSpec = parseJson("""
            |{
            |    "data": {
            |        "values": [ {"a": "A"} ]
            |    },
            |    "mark": "bar",
            |    "encoding": {
            |        "x": {"field": "a"},
            |        "color": {"field": "a"}
            |    }
            |}
        """.trimMargin()).asMutable()

        val plotSpec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(plotSpec.getString(Plot.LAYERS, 0, PlotBase.MAPPING, toOption(Aes.COLOR)))
            .isEqualTo("a")

        assertThat(plotSpec.getString(Plot.LAYERS, 0, PlotBase.MAPPING, toOption(Aes.FILL)))
            .isEqualTo("a")
    }

    @Test
    fun positionAndStat() {
        val vegaSpec = parseJson(
            """
            |{
            |  "data": { "url": "data/population.json"},
            |  "encoding": {
            |    "y": {"field": "age"}
            |  },
            |  "layer": [{
            |    "mark": "bar",
            |    "encoding": {
            |      "x": {
            |        "aggregate": "sum", "field": "people",
            |        "stack":  "normalize"
            |      },
            |      "color": {
            |        "field": "sex"
            |      }
            |    }
            |  }]
            |}
        """.trimMargin()
        ).asMutable()

        val spec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(spec.getMap(Plot.LAYERS, 0)).contains(
            entry(Layer.STAT, StatKind.SUMMARY.name.lowercase()),
            entry(Stat.Summary.FUN, Stat.Summary.Functions.SUM),
            entry(Layer.POS, mapOf(Pos.NAME to PosProto.FILL)),
            entry(Layer.ORIENTATION, "y"),
            entry(
                PlotBase.MAPPING,
                mapOf(
                    toOption(Aes.X) to "people",
                    toOption(Aes.Y) to "age",
                    toOption(Aes.FILL) to "sex",
                    toOption(Aes.COLOR) to "sex",
                ),
            ),
        )
    }

    @Test
    fun posDodge() {
        val vegaSpec = parseJson(
            """
                |{
                |  "data": {
                |    "values": [
                |      {"category":"A", "group": "x", "value":0.1},
                |      {"category":"A", "group": "y", "value":0.6},
                |      {"category":"A", "group": "z", "value":0.9},
                |      {"category":"B", "group": "x", "value":0.7},
                |      {"category":"B", "group": "y", "value":0.2},
                |      {"category":"B", "group": "z", "value":1.1},
                |      {"category":"C", "group": "x", "value":0.6},
                |      {"category":"C", "group": "y", "value":0.1},
                |      {"category":"C", "group": "z", "value":0.2}
                |    ]
                |  },
                |  "mark": {
                |    "type": "bar"
                |   },
                |  "encoding": {
                |    "x": {"field": "category"},
                |    "y": {"field": "value", "type": "quantitative"},
                |    "color": { "field": "group" },
                |    "xOffset": {"field": "group"}
                |  }
                |}
            """.trimMargin()).asMutable()

        val spec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(spec.getMap(Plot.LAYERS, 0)).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(PlotBase.DATA, mapOf(
                "category" to listOf("A", "A", "A", "B", "B", "B", "C", "C", "C"),
                "group" to listOf("x", "y", "z", "x", "y", "z", "x", "y", "z"),
                "value" to listOf(0.1, 0.6, 0.9, 0.7, 0.2, 1.1, 0.6, 0.1, 0.2),
            )),
            entry(Layer.POS, mapOf(Pos.NAME to PosProto.DODGE)),
            entry(Meta.DATA_META, empty()),
            entry(Layer.STAT, StatKind.IDENTITY.name.lowercase()),
            entry(
                PlotBase.MAPPING,
                mapOf(
                    toOption(Aes.X) to "category",
                    toOption(Aes.Y) to "value",
                    toOption(Aes.FILL) to "group",
                    toOption(Aes.COLOR) to "group",
                ),
            ),
        )
    }

    @Test
    fun posIdentity() {
        val vegaSpec = parseJson(
            """
                |{
                |  "data": {
                |    "values": [
                |      {"category":"A", "group": "x", "value":0.1},
                |      {"category":"A", "group": "y", "value":0.6},
                |      {"category":"A", "group": "z", "value":0.9},
                |      {"category":"B", "group": "x", "value":0.7},
                |      {"category":"B", "group": "y", "value":0.2},
                |      {"category":"B", "group": "z", "value":1.1},
                |      {"category":"C", "group": "x", "value":0.6},
                |      {"category":"C", "group": "y", "value":0.1},
                |      {"category":"C", "group": "z", "value":0.2}
                |    ]
                |  },
                |  "mark": {
                |    "type": "bar", "opacity": 0.2
                |   },
                |  "encoding": {
                |    "x": {"field": "category"},
                |    "y": {"field": "value", "type": "quantitative", "stack":  null},
                |    "color": { "field": "group" }
                |  }
                |}
            """.trimMargin()).asMutable()

        val spec = SpecTransformBackendUtil.processTransform(vegaSpec)

        assertThat(spec.getMap(Plot.LAYERS, 0)).containsOnly(
            entry(Layer.GEOM, fromGeomKind(GeomKind.BAR)),
            entry(PlotBase.DATA, mapOf(
                "category" to listOf("A", "A", "A", "B", "B", "B", "C", "C", "C"),
                "group" to listOf("x", "y", "z", "x", "y", "z", "x", "y", "z"),
                "value" to listOf(0.1, 0.6, 0.9, 0.7, 0.2, 1.1, 0.6, 0.1, 0.2),
            )),
            entry(Layer.POS, mapOf(Pos.NAME to PosProto.IDENTITY)),
            entry(toOption(Aes.ALPHA), 0.2),
            entry(Meta.DATA_META, empty()),
            entry(Layer.STAT, StatKind.IDENTITY.name.lowercase()),
            entry(
                PlotBase.MAPPING,
                mapOf(
                    toOption(Aes.X) to "category",
                    toOption(Aes.Y) to "value",
                    toOption(Aes.FILL) to "group",
                    toOption(Aes.COLOR) to "group",
                ),
            ),
        )
    }


}