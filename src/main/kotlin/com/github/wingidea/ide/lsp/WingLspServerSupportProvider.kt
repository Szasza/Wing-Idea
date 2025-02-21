package com.github.wingidea.ide.lsp

import com.github.wingidea.ide.WingCommandLine
import com.github.wingidea.isWingFile
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

@Suppress("UnstableApiUsage")
class WingLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.isWingFile) {
            serverStarter.ensureServerStarted(WingLspServerDescriptor(project))
        }
    }
}

@Suppress("UnstableApiUsage")
private class WingLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "Wing") {
    override fun isSupportedFile(file: VirtualFile) = file.extension == "w"
    override fun createCommandLine() = WingCommandLine.createLsp(project)
}