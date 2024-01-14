package com.intelliic.jetbrains;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.util.Disposer;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Intelliic implements ApplicationComponent {

    public Intelliic() {}

    public void initComponent() {
        initListeners();
        initHttpServer();

        Notification notification = new Notification(
                "com.intelliic.jetbrains.notification",
                "IDE is not connected",
                "Your IDE is not connected. No stats are tracked!",
                NotificationType.WARNING
        );

        notification.addAction(new Actions.ConnectIdeAction());
        notification.addAction(new Actions.CloseNotificationAction(notification));

        Notifications.Bus.notify(notification);
    }

    public static void initListeners() {
        ApplicationManager.getApplication().invokeLater(() -> {
            Disposable disposable = Disposer.newDisposable("intelliic_debug");
        });
    }

    public static void initHttpServer() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 63345), 0);
            httpServer.createContext("/", new WebHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            return;
        }
    }
}