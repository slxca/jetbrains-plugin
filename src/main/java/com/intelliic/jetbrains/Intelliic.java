package com.intelliic.jetbrains;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.ApplicationComponent;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Intelliic implements ApplicationComponent {

    public Session session;
    public Session.Collector collector;

    public Intelliic() {
        initHttpServer();

        Notification notification = new Notification(
                "com.intelliic.jetbrains.notification",
                "Intelliic: IDE is not connected",
                "Your IDE is not connected. No stats are tracked!",
                NotificationType.WARNING
        );

        notification.addAction(new Actions.ConnectIdeAction());
        notification.addAction(new Actions.CloseNotificationAction(notification));

        Notifications.Bus.notify(notification);
    }

    public static void initHttpServer() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 63345), 0);
            httpServer.createContext("/", new WebHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException ignored) {}
    }

    public Session getSession() {
        return session;
    }

    public Session.Collector getCollector() {
        return collector;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setCollector(Session.Collector collector) {
        this.collector = collector;
    }
}