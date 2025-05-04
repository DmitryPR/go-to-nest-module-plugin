package net.eventpanel

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.ui.popup.ListPopup
import com.intellij.openapi.ui.popup.PopupStep
import com.intellij.openapi.ui.popup.util.BaseListPopupStep
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.FilenameIndex

class GoToNestModuleAction : AnAction("Go To NestJS Module") {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return

        val moduleFiles = FilenameIndex.getAllFilesByExt(project, "ts")
            .filter { it.name.endsWith(".module.ts") && it.path.contains("/src/modules/") }

        if (moduleFiles.isEmpty()) {
            Messages.showInfoMessage(project, "No modules found in /src/modules/", "Go To NestJS Module")
            return
        }

        val popupItems = moduleFiles.map { it.name to it }.sortedBy { it.first }

        val step = object : BaseListPopupStep<Pair<String, VirtualFile>>("Select a NestJS Module", popupItems) {
            override fun getTextFor(value: Pair<String, VirtualFile>): String = value.first

            override fun onChosen(selectedValue: Pair<String, VirtualFile>, finalChoice: Boolean): PopupStep<*>? {
                FileEditorManager.getInstance(project).openFile(selectedValue.second, true)
                return FINAL_CHOICE
            }

            override fun isSpeedSearchEnabled(): Boolean = true
        }

        val popup: ListPopup = JBPopupFactory.getInstance().createListPopup(step)
        popup.showInFocusCenter()
    }
}