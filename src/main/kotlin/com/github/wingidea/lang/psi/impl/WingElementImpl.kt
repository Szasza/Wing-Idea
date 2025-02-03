package com.github.wingidea.lang.psi.impl

import com.github.wingidea.lang.psi.WingElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

/**
 * Defines the base class for Wing elements.
 */
open class WingElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), WingElement