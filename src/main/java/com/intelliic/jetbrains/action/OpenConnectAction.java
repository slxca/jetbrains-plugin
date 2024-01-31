package com.intelliic.jetbrains.action;

import com.intelliic.jetbrains.dialog.ConnectDialog;
import com.intelliic.jetbrains.dialog.ConnectDialogOld;
import com.intelliic.jetbrains.dialog.TestDialog;
import com.intelliic.jetbrains.utils.HttpServer;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OpenConnectAction extends AnAction {

    public OpenConnectAction() {
        super("Connect IDE");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        HttpServer.startHttpServer();

        ConnectDialogOld dialog = new ConnectDialogOld();
        dialog.pack();
        dialog.setVisible(true);
    }
}
