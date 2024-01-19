package com.intelliic.jetbrains;

import com.intellij.openapi.project.Project;

import java.util.Date;
import java.util.UUID;

public class Session {

    public UUID sessionId;
    public Date creationTime;
    public Project project;

    public Session(Project project) {
        this.sessionId = UUID.randomUUID();
        this.creationTime = new Date();
        this.project = project;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Project getProject() {
        return project;
    }

    public static class Collector {



    }
}
