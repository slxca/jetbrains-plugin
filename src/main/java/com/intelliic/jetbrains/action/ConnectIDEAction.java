package com.intelliic.jetbrains.action;

import com.intelliic.jetbrains.dialog.HELLOWORLDDIALOG;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ConnectIDEAction extends AnAction {

    public ConnectIDEAction() {
        super("Connect IDE");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        HELLOWORLDDIALOG helloworlddialog = new HELLOWORLDDIALOG();
        helloworlddialog.show();
    }

}
