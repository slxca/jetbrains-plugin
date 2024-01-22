package com.intelliic.jetbrains.action;

import com.intelliic.jetbrains.dialog.SettingsDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class OpenSettings extends AnAction {

    public OpenSettings() {
        super("Settings");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        SettingsDialog settingsDialog = new SettingsDialog();
        settingsDialog.show();
    }

}
