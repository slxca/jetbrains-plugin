package com.intelliic.jetbrains;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "IntelliicConfiguration", storages = {@Storage("intelliic_settings.xml")})
public class Configuration implements PersistentStateComponent<Configuration.IntelliicState> {
    public static class IntelliicState {
        private String token = null;

        @Nullable
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    private IntelliicState intelliicState = new IntelliicState();

    @Nullable
    @Override
    public IntelliicState getState() {
        return intelliicState;
    }

    @Override
    public void loadState(@NotNull IntelliicState config) {
        intelliicState = config;
    }

    public String getToken() {
        return intelliicState.getToken();
    }

    public void setToken(String value) {
        intelliicState.setToken(value);
    }
}