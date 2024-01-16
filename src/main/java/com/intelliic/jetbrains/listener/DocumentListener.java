package com.intelliic.jetbrains.listener;

import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.vcs.update.UpdatedFilesListener;

import java.util.Set;

public class DocumentListener implements com.intellij.openapi.editor.event.DocumentListener {

    public void listener(DocumentEvent event) {
        System.out.printf(String.valueOf(event.getDocument().getLineCount()));
    }
}
