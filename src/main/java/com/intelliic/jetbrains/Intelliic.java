package com.intelliic.jetbrains;

import com.intelliic.jetbrains.service.ActionService;
import com.intelliic.jetbrains.service.PersistentService;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.ApplicationComponent;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Intelliic implements ApplicationComponent {

    public Intelliic() {}

    @Override
    public void initComponent() {
        initHttpServer();

        if(!isPluginConnected()) {
            Notification notification = new Notification(
                    "com.intelliic.jetbrains.notification",
                    "Intelliic: IDE is not connected",
                    "Your IDE is not connected. No stats are tracked!",
                    NotificationType.WARNING
            );

            notification.addAction(new ActionService.ConnectIdeAction());
            notification.addAction(new ActionService.CloseNotificationAction(notification));

            Notifications.Bus.notify(notification);
        }
    }

    public static boolean isCliInstalled() {
        String cliFilePath = System.getProperty("user.home").replaceAll("\\\\", "/") + "/.intelliic/intelliic-cli.exe";
        File cliFile = new File(cliFilePath);
        return cliFile.exists();
    }

    public static boolean isPluginConnected() {
        return !PersistentService.getInstance().getToken().isEmpty();
    }

    public static void initHttpServer() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 63345), 0);
            httpServer.createContext("/", new WebHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException ignored) {}
    }
}