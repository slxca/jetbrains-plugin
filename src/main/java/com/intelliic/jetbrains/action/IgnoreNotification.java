package com.intelliic.jetbrains.action;

import com.intellij.notification.Notification;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class IgnoreNotification extends AnAction {

    private final Notification notification;

    public IgnoreNotification(Notification notification) {
        super("Dont show again");
        this.notification = notification;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        notification.expire();
    }
}
