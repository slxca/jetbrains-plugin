package com.intelliic.jetbrains;

import com.google.gson.JsonObject;
import com.intelliic.jetbrains.action.OpenConnectAction;
import com.intelliic.jetbrains.service.ActionService;
import com.intelliic.jetbrains.service.IntelliicPersistent;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.components.ApplicationComponent;
import io.javalin.Javalin;

import java.io.File;

public class Intelliic implements ApplicationComponent {

    public static Javalin javalinServer;

    public Intelliic() {}

    @Override
    public void initComponent() {
        if(!isPluginConnected()) {
            Notification notification = new Notification(
                    "com.intelliic.jetbrains.notification",
                    "Intelliic: IDE is not connected",
                    "Your IDE is not connected. No stats are tracked!",
                    NotificationType.WARNING
            );

            notification.addAction(new OpenConnectAction());
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
        return !IntelliicPersistent.getInstance().getToken().isEmpty();
    }

    public static void startHttpServer() {
        javalinServer = Javalin.create();

        javalinServer.get("/", ctx -> {
            ApplicationInfo applicationInfo = ApplicationInfo.getInstance();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", applicationInfo.getVersionName());
            jsonObject.addProperty("version", applicationInfo.getFullVersion());

            ctx.contentType("application/json").result(jsonObject.toString());
        });

        javalinServer.post("/connect", ctx -> {
            String key = ctx.body();
            IntelliicPersistent.getInstance().setToken(key);
        });

        javalinServer.start(63345);
    }

    public static void stopHttpServer() {
        javalinServer.stop();
    }
}