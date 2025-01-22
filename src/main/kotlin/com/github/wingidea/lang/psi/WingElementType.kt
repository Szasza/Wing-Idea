package com.github.wingidea.lang.psi

import com.github.wingidea.lang.WingLanguage
import com.intellij.psi.tree.IElementType

/**
 * Defines the base class for Wing element types.
 */
class WingElementType(debugName: String) : IElementType(debugName, WingLanguage)