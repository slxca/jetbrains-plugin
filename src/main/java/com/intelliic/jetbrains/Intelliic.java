package com.intelliic.jetbrains;

import com.intelliic.jetbrains.action.IgnoreNotification;
import com.intelliic.jetbrains.action.OpenConnectAction;
import com.intelliic.jetbrains.service.IntelliicPersistent;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.ApplicationComponent;

import java.io.File;

public class Intelliic implements ApplicationComponent {

    public Intelliic() {}

    @Override
    public void initComponent() {
        if(!isPluginConnected()) {
            if(!IntelliicPersistent.getInstance().getHideNotification()) {
                Notification notification = new Notification(
                        "com.intelliic.jetbrains.notification",
                        "Intelliic: IDE is not connected",
                        "Your IDE is not connected. No stats are tracked!",
                        NotificationType.WARNING
                );

                notification.addAction(new OpenConnectAction());
                notification.addAction(new IgnoreNotification(notification));

                Notifications.Bus.notify(notification);
            }
        }
    }

    public static boolean isCliInstalled() {
        String cliFilePath = System.getProperty("user.home").replaceAll("\\\\", "/") + "/.intelliic/intelliic-cli.exe";
        File cliFile = new File(cliFilePath);
        return cliFile.exists();
    }

    public static boolean isPluginConnected() {
        return !IntelliicPersistent.getInstance().getToken().isEmpty();
    }
}