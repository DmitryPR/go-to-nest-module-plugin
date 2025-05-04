package com.example

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope

class GoToNestModuleAction : AnAction("Go To NestJS Module") {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val input = Messages.showInputDialog(
            project,
            "Enter module name (without .module.ts):",
            "Go To NestJS Module",
            Messages.getQuestionIcon()
        ) ?: return

        val searchFileName = "$input.module.ts"
        val files = FilenameIndex.getVirtualFilesByName(searchFileName, GlobalSearchScope.projectScope(project))
        val targetFile = files.find { it.path.contains("/src/modules/") }

        if (targetFile != null) {
            openFileInEditor(project, targetFile)
        } else {
            Messages.showInfoMessage(project, "Module '\$searchFileName' not found in /src/modules/", "Not Found")
        }
    }

    private fun openFileInEditor(project: Project, file: VirtualFile) {
        FileEditorManager.getInstance(project).openFile(file, true)
    }
}