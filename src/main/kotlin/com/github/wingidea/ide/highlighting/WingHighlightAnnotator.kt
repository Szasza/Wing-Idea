package com.github.wingidea.ide.highlighting

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.github.wingidea.lang.psi.*
import com.github.wingidea.lang.psi.WingElementTypes.*
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey

/**
 * Annotates with PSI aware syntax highlighting.
 * For basic syntax highlighting see [com.github.wingidea.ide.highlighting.WingSyntaxHighlighter].
 */
class WingHighlightAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element.elementType) {
            IDENTIFIER -> highlightIdentifier(holder, element)
        }
    }

    private fun highlightIdentifier(holder: AnnotationHolder, element: PsiElement) {
        val parent = element.parent ?: return

        when (parent) {
            is WingMethodDefinition -> newAnnotation(holder, element, WingColors.METHOD_DEFINITION_NAME)
            is WingEnumField -> newAnnotation(holder, element, WingColors.ENUM_FIELD)
            is WingClassField -> newAnnotation(holder, element, WingColors.CLASS_FIELD)
            is WingReferenceExpression -> {
                // If element is a call on method or field `something.method()` or `something.field`
                if (element.prevSibling is WingAccessor) {
                    if (parent.parent is WingCallExpression) {
                        newAnnotation(holder, element, WingColors.METHOD_DEFINITION_NAME)
                    } else {
                        newAnnotation(holder, element, WingColors.CLASS_FIELD)
                    }
                } else if (parent.parent is WingCallExpression) {
                    newAnnotation(holder, element, WingColors.METHOD_DEFINITION_NAME)
                }
            }
        }
    }

    private fun newAnnotation(
        holder: AnnotationHolder, element: PsiElement, textAttributesKey: TextAttributesKey
    ) {
        newAnnotationBuilder(holder)
            .textAttributes(textAttributesKey)
            .range(element)
            .create()
    }

    private fun newAnnotationBuilder(holder: AnnotationHolder) =
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)

}