package com.intelliic.jetbrains.dialog;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ConnectDialog extends DialogWrapper {

    private JPanel panel1;
    private JButton cancelButton;
    private JButton OKButton;

    public ConnectDialog() {
        super((Project) null, true);
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return panel1;
    }
}
