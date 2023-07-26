package com.github.olivernybroe.wingidea.ide.editor

import com.github.olivernybroe.wingidea.isWingFile
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.fileEditor.FileEditorState
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.jcef.JBCefBrowserBuilder
import java.beans.PropertyChangeListener
import javax.swing.JComponent


class WingPreviewEditorProvider: FileEditorProvider {
    override fun accept(project: Project, virtualFile: VirtualFile): Boolean = virtualFile.isWingFile

    override fun createEditor(project: Project, virtualFile: VirtualFile): FileEditor = WingFileEditor(virtualFile)

    override fun getEditorTypeId(): String = "Wing Editor"

    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.PLACE_AFTER_DEFAULT_EDITOR
}

class WingFileEditor(private val virtualFile: VirtualFile) : FileEditor, UserDataHolderBase() {
    private var browser = JBCefBrowserBuilder().setUrl("localhost:3000").build()

    override fun dispose() {
        Disposer.dispose(browser)
    }

    override fun getComponent(): JComponent = browser.component

    override fun getPreferredFocusedComponent(): JComponent = browser.component

    override fun getName(): String = "Wing Preview"

    override fun getFile(): VirtualFile = virtualFile

    override fun setState(state: FileEditorState) {
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun isValid(): Boolean {
        return true
    }

    override fun addPropertyChangeListener(listener: PropertyChangeListener) {
    }

    override fun removePropertyChangeListener(listener: PropertyChangeListener) {
    }

}
