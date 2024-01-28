package com.intelliic.jetbrains;

import com.intellij.openapi.project.Project;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Session {

    public UUID sessionId;
    public Date creationTime;
    public Project project;

    public Session(Project project) {
        this.sessionId = UUID.randomUUID();
        this.creationTime = new Date();
        this.project = project;
    }
}
