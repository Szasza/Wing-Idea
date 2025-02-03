package com.github.wingidea.lang

import com.intellij.lang.Language

object WingLanguage: Language("Wing") {
    private fun readResolve(): Any = WingLanguage
}