/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package jetbrains.datalore.vis.svg

class SvgStyleElement(val resource: SvgCssResource) : SvgElement() {

    override val elementName = "style"

    init {
        setContent(resource.css())
    }

    fun setContent(content: String) {
        val children = children()
        while (!children.isEmpty()) {
            children.removeAt(0)
        }
        val textNode = SvgTextNode(content)
        children.add(textNode)
        setAttribute("type", "text/css")
    }
}