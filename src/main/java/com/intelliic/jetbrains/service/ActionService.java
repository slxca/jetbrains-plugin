package com.intelliic.jetbrains.service;

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
}
