package com.github.wingidea.lang

import com.github.wingidea.WingIcons
import com.intellij.openapi.fileTypes.LanguageFileType

object WingFileType: LanguageFileType(WingLanguage) {
    override fun getName() = "Wing"
    override fun getDescription() = "Wing language file"
    override fun getDefaultExtension() = "w"
    override fun getIcon() = WingIcons.FILE
}