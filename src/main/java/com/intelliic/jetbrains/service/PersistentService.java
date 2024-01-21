package com.intelliic.jetbrains.service;

import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;

@Service
@State(name = "IntelliicPersistent", storages = {@Storage("intelliic_settings.xml")})
public final class PersistentService implements PersistentStateComponent<PersistentService.State> {

    public static class State {
        public String token = "";
    }

    private final State intelliicState = new State();

    public static PersistentService getInstance() {
        return ServiceManager.getService(PersistentService.class);
    }

    @Override
    public State getState() {
        return intelliicState;
    }

    @Override
    public void loadState(@NotNull State state) {
        XmlSerializerUtil.copyBean(state, intelliicState);
    }

    public void setToken(String value) {
        intelliicState.token = value;
    }

    public String getToken() {
        return intelliicState.token;
    }
}