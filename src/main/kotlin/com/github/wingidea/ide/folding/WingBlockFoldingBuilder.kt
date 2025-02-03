package com.github.wingidea.ide.folding

import com.github.wingidea.lang.psi.WingBlockStatement
import com.github.wingidea.lang.psi.WingResourceImplementation
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class WingBlockFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val blocks = PsiTreeUtil.findChildrenOfAnyType(
            root,
            WingBlockStatement::class.java,
            WingResourceImplementation::class.java,
        )
        return blocks.map { FoldingDescriptor(it, it.textRange) }.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String = "{...}"

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false
}