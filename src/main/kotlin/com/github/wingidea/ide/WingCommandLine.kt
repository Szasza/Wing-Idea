package com.github.wingidea.ide

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.local.NodeJsLocalInterpreter
import com.intellij.javascript.nodejs.interpreter.wsl.WslNodeInterpreter
import com.intellij.javascript.nodejs.npm.NpmManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.SystemInfo


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
                throw ExecutionException("NodeJS/WSL interpreter is not configured for the project, the LSP server cannot be started.")
            }

            val npmPath = NpmManager.getInstance(project).getPackage(interpreter)!!.systemDependentPath
            val cmdLine = GeneralCommandLine("")
            val nodeModuleBinPath: String

            val wingExecutable =
                if (SystemInfo.isWindows) {
                    nodeModuleBinPath = getWindowsNodeModuleBinPath(npmPath)
                    getWindowsExecutable(nodeModuleBinPath)
                } else {
                    nodeModuleBinPath = npmPath.replaceAfterLast("/", "").replaceAfterLast("\\", "").trimEnd('/','\\')
                    "wing"
                }

            val cmd = cmdLine.apply {
                withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
                withEnvironment(parentEnvironment)
                // TODO we need to check if Wing is on the path
                withCharset(Charsets.UTF_8)
                withWorkDirectory(project.basePath)
                withExePath("$nodeModuleBinPath\\$wingExecutable")
                addParameters(*commands)
            }

            return cmd
        }

        private fun getWindowsNodeModuleBinPath(npmPath: String): String {
            val npmModulesBinPathCommandLine = GeneralCommandLine(npmPath)
            npmModulesBinPathCommandLine.addParameters("config", "get", "prefix")
            val npmProcessHandler = OSProcessHandler(npmModulesBinPathCommandLine)
            val bufferedReader = npmProcessHandler.process.inputStream.bufferedReader()

            return bufferedReader.readLine()
        }

        private fun getWindowsExecutable(nodeModuleBinPath: String): String {
            val cmdLine = GeneralCommandLine("")

            cmdLine.withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
            cmdLine.withEnvironment(cmdLine.parentEnvironment)
            val executables = arrayOf("wing.cmd", "wing.ps1", "wing")

            for (executable in executables) {
                try {
                    cmdLine.withExePath("$nodeModuleBinPath\\$executable")
                    val processHandler = OSProcessHandler(cmdLine)
                    val output = processHandler.process.errorStream.bufferedReader().readLine().split(":")[0]

                    if (output == "Usage") {
                        return executable
                    }
                } catch (_: Exception) {}
            }

            throw ExecutionException("None of the Winglang executables can be executed. Please check if Wing is installed.")
        }

        fun createLsp(project: Project): GeneralCommandLine = createCommand(project, "lsp", "--no-update-check")
        fun createConsole(project: Project): GeneralCommandLine = createCommand(project, "it", "--no-open")
    }
}
