package com.intelliic.jetbrains.listener;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import org.jetbrains.annotations.NotNull;

public class DocumentListener implements com.intellij.openapi.editor.event.DocumentListener {

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        Document document = event.getDocument();

        //System.out.println(document.getLineCount());

        Project[] projects = ProjectManager.getInstance().getOpenProjects();
        for (Project project : projects) {
            //System.out.println(project);
        }
    }
}
