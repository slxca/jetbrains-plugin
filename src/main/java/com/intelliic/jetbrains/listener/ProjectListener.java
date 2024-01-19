package com.intelliic.jetbrains.listener;

import com.intelliic.jetbrains.Intelliic;
import com.intelliic.jetbrains.Session;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;

public class ProjectListener implements ProjectManagerListener {

    @Override
    public void projectOpened(@NotNull Project project) {
        Session session = new Session(project);
        Session.Collector collector = new Session.Collector();

        Intelliic intelliic = new Intelliic();
        intelliic.setCollector(collector);
        intelliic.setSession(session);
    }
}
