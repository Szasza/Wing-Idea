package com.github.wingidea.lang.lexer

import com.github.wingidea.lang.parser.WingParserDefinition
import com.intellij.testFramework.ParsingTestCase
import org.junit.Ignore

@Ignore
class WingStructParsingTest : ParsingTestCase("", "w", WingParserDefinition()) {
    fun testParser() = doTest(true)
    override fun getTestDataPath() = "src/test/testData/parser/struct"
    override fun skipSpaces() = true
    override fun includeRanges() = true
}