package com.github.wingidea.ide

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.local.NodeJsLocalInterpreter
import com.intellij.javascript.nodejs.interpreter.wsl.WslNodeInterpreter
import com.intellij.javascript.nodejs.npm.NpmManager
import com.intellij.openapi.project.Project


/**
 * Defines small wrapper functions around GeneralCommandLine to run wing commands.
 *
 * @see [GeneralCommandLine]
 */
class WingCommandLine {

    companion object {
        private fun createCommand(project: Project, vararg commands: String): GeneralCommandLine {
            val interpreter = NodeJsInterpreterManager.getInstance(project).interpreter
            if (interpreter !is NodeJsLocalInterpreter && interpreter !is WslNodeInterpreter) {
                // shouldn't happen, checked in PrismaLspServerSupportProvider
                throw ExecutionException("NodeJS/WSL interpreter is not configured for the project, the LSP server cannot be started.")
            }

            val npmPath = NpmManager.getInstance(project).getPackage(interpreter)!!.systemDependentPath
            val nodeBinPath = npmPath.replaceAfterLast("/", "").replaceAfterLast("\\", "").trimEnd('/','\\')
            val cmdLine = GeneralCommandLine("wing")
            val envPath = cmdLine.parentEnvironment["PATH"]

            return cmdLine.apply {
                withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
                withEnvironment(parentEnvironment)
                withEnvironment("PATH", "$envPath:$nodeBinPath")
                withCharset(Charsets.UTF_8)
                withWorkDirectory(project.basePath)
                addParameters(*commands)
            }
        }

        fun createLsp(project: Project): GeneralCommandLine = createCommand(project, "lsp", "--no-update-check")
        fun createConsole(project: Project): GeneralCommandLine = createCommand(project, "it", "--no-open")
    }
}
