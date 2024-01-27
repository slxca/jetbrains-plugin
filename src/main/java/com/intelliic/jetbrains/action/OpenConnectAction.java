package com.intelliic.jetbrains.action;

import com.intelliic.jetbrains.Intelliic;
import com.intelliic.jetbrains.dialog.ConnectDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class OpenConnectAction extends AnAction {

    public OpenConnectAction() {
        super("Connect IDE");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        Intelliic.startHttpServer();

        ConnectDialog connectDialog = new ConnectDialog();
        connectDialog.setSize(530, 300);
        connectDialog.setTitle("Connect new IDE");
        connectDialog.setModal(true);
        connectDialog.setVisible(true);
    }
}
