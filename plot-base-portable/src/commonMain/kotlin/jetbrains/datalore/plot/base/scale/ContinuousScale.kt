/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.base.scale

import jetbrains.datalore.base.gcommon.collect.ClosedRange
import jetbrains.datalore.plot.base.Scale
import jetbrains.datalore.plot.base.Transform
import jetbrains.datalore.plot.base.scale.transform.Transforms
import jetbrains.datalore.plot.base.scale.transform.Transforms.createBreaksGenerator

internal class ContinuousScale<T> : AbstractScale<Double, T> {
    override val isContinuous: Boolean
    override val isContinuousDomain: Boolean = true
    override val domainLimits: ClosedRange<Double>?

    override var transform: Transform = Transforms.IDENTITY

    private var customBreaksGenerator: BreaksGenerator? = null

    override var breaksGenerator: BreaksGenerator
        private set(v) {
            customBreaksGenerator = v
        }
        get() {
            return if (customBreaksGenerator != null) {
                Transforms.BreaksGeneratorForTransformedDomain(transform, customBreaksGenerator!!)
            } else {
                createBreaksGenerator(transform, labelFormatter)
            }
        }

    constructor(
        name: String,
        mapper: ((Double?) -> T?),
        continuousOutput: Boolean
    ) : super(name, mapper) {
        isContinuous = continuousOutput
        domainLimits = null

        // see: https://ggplot2.tidyverse.org/reference/scale_continuous.html
        // defaults for continuous scale.
        multiplicativeExpand = 0.05
        additiveExpand = 0.0
    }

    private constructor(b: MyBuilder<T>) : super(b) {
        transform = b.myTransform
        customBreaksGenerator = b.myCustomBreaksGenerator
        isContinuous = b.myContinuousOutput
        val lower = b.myLowerLimit
        val upper = b.myUpperLimit
        domainLimits = if (lower != null || upper != null) {
            ClosedRange(
                lower ?: Double.NEGATIVE_INFINITY,
                upper ?: Double.POSITIVE_INFINITY
            )
        } else null
    }

    override fun hasBreaksGenerator() = true

    override fun isInDomainLimits(v: Any): Boolean {
        return if (v is Number) {
            val d = v.toDouble()
            domainLimits?.contains(d) ?: d.isFinite()
        } else {
            false
        }
    }

    override fun hasDomainLimits(): Boolean {
        return domainLimits != null
    }

    override fun asNumber(input: Any?): Double? {
        if (input == null || input is Double) {
            return input as Double?
        }
        throw IllegalArgumentException("Double is expected but was " + input::class.simpleName + " : " + input.toString())
    }

    override fun with(): Scale.Builder<T> {
        return MyBuilder(this)
    }


    private class MyBuilder<T>(scale: ContinuousScale<T>) : AbstractBuilder<Double, T>(scale) {
        internal var myCustomBreaksGenerator: BreaksGenerator? = scale.customBreaksGenerator
        internal val myContinuousOutput: Boolean = scale.isContinuous
        internal var myLowerLimit: Double? = scale.domainLimits?.lowerEnd
        internal var myUpperLimit: Double? = scale.domainLimits?.upperEnd

        override fun lowerLimit(v: Double): Scale.Builder<T> {
            require(!v.isNaN()) { "`lower` can't be $v" }
            myLowerLimit = v
            return this
        }

        override fun upperLimit(v: Double): Scale.Builder<T> {
            require(!v.isNaN()) { "`upper` can't be $v" }
            myUpperLimit = v
            return this
        }

        override fun limits(domainValues: List<Any>): Scale.Builder<T> {
            throw IllegalArgumentException("Can't apply discrete limits to scale with continuous domain")
        }

        override fun continuousTransform(v: Transform): Scale.Builder<T> {
            return transform(v)
        }

        override fun breaksGenerator(v: BreaksGenerator): Scale.Builder<T> {
            myCustomBreaksGenerator = v
            return this
        }

        override fun build(): Scale<T> {
            return ContinuousScale(this)
        }
    }
}
