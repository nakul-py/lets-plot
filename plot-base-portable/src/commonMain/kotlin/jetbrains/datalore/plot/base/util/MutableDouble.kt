/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.plot.base.util

class MutableDouble(private var myValue: Double) {

    fun getAndAdd(v: Double): Double {
        val prevValue = myValue
        myValue = prevValue + v
        return prevValue
    }

    fun get(): Double {
        return myValue
    }
}
