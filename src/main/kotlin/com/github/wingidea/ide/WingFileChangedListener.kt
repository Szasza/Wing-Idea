package com.github.wingidea.ide

import com.github.wingidea.ide.services.WingConsoleManager
import com.github.wingidea.lang.WingFileType
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import kotlinx.coroutines.runBlocking

class WingFileChangedListener: Disposable, FileEditorManagerListener {
    var editor: Editor? = null
    override fun dispose() {
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        val newFile = event.newFile ?: return

        startConsole(newFile, event.manager.project)
    }

    private fun startConsole(file: VirtualFile, project: Project) {
        val consoleManager = project.service<WingConsoleManager>()
        if (file.fileType !is WingFileType) return

        val path = file.path


        ApplicationManager.getApplication().executeOnPooledThread {
            if (consoleManager.path == path) {
                return@executeOnPooledThread
            }

            runBlocking {
                consoleManager.startForPath(path)
            }
        }
    }
}