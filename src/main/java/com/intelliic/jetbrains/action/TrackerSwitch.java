package com.intelliic.jetbrains.action;

import com.intelliic.jetbrains.service.IntelliicPersistent;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.intellij.openapi.actionSystem.Toggleable;
import org.jetbrains.annotations.NotNull;

public class TrackerSwitch extends ToggleAction {

    private boolean isSelected = IntelliicPersistent.getInstance().getTrackingEnabled();

    public TrackerSwitch() {
        super("Enable Tracking");
    }

    @Override
    public void actionPerformed(final @NotNull AnActionEvent e) {
        final boolean state = !isSelected(e);
        setSelected(e, state);
        final Presentation presentation = e.getPresentation();
        Toggleable.setSelected(presentation, state);
    }

    @Override
    public boolean isSelected(@NotNull AnActionEvent e) {
        return isSelected;
    }

    @Override
    public void setSelected(@NotNull AnActionEvent e, boolean state) {
        IntelliicPersistent.getInstance().setTrackingEnabled(state);
        this.isSelected = state;
    }
}