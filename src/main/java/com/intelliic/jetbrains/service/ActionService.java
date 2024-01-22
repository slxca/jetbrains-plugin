package com.intelliic.jetbrains.service;

import com.intelliic.jetbrains.dialog.ConnectDialog;
import com.intelliic.jetbrains.dialog.SettingsDialog;
import com.intellij.notification.Notification;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ActionService {

    public ActionService() {}

    public static class ConnectIdeAction extends AnAction {
        public ConnectIdeAction() {
            super("Connect IDE");
        }

        @Override
        public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
            ConnectDialog connectDialog = new ConnectDialog();
            connectDialog.show();
        }
    }

    public static class CloseNotificationAction extends AnAction {
        private final Notification notification;
        public CloseNotificationAction(Notification notification) {
            super("Ignore");
            this.notification = notification;
        }

        @Override
        public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
            notification.expire();
        }
    }

    public static class OpenSettingsDialogAction extends AnAction {
        public OpenSettingsDialogAction() {
            super("Intelliic Settings");
        }

        @Override
        public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
            SettingsDialog settingsDialog = new SettingsDialog();
            settingsDialog.show();
        }
    }
}
