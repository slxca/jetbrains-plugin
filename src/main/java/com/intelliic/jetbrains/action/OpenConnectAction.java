package com.intelliic.jetbrains.action;

import com.intelliic.jetbrains.dialog.ConnectDialog;
import com.intelliic.jetbrains.utils.HttpServer;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class OpenConnectAction extends AnAction {

    public OpenConnectAction() {
        super("Connect IDE");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        HttpServer.startHttpServer();

        ConnectDialog connectDialog = new ConnectDialog();
        connectDialog.setResizable(false);
        connectDialog.setTitle("Connect new IDE");
        connectDialog.setSize(530, 300);
        connectDialog.show();
    }
}
