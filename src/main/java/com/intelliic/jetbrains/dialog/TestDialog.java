package com.intelliic.jetbrains.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class TestDialog extends DialogWrapper {

    public TestDialog() {
        super(true);
        setTitle("Test Dialog");
        init();
    }


    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());



        return dialogPanel;
    }
}
