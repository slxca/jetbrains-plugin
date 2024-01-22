package com.intelliic.jetbrains;

import com.intelliic.jetbrains.service.IntelliicPersistent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PluginStartup implements StartupActivity.Background {

    private UUID sessionId;
    private Date sessionDate;
    private Date lastActivity;

    @Override
    public void runActivity(@NotNull Project project) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {

            System.out.println(IntelliicPersistent.getInstance().getTrackingEnabled());
            System.out.println(IntelliicPersistent.getInstance().getToken());
        }, 0, 5, TimeUnit.SECONDS);
    }

}
