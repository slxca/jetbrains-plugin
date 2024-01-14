package com.intelliic.jetbrains;

import com.intellij.notification.Notification;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class Actions {

    static class ConnectIdeAction extends AnAction {
        public ConnectIdeAction() {
            super("Connect IDE");
        }

        @Override
        public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        }
    }

    static class CloseNotificationAction extends AnAction {
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
