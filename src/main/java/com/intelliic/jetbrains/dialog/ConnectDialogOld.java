package com.intelliic.jetbrains.dialog;

import com.intelliic.jetbrains.utils.HttpServer;
import com.intellij.openapi.util.IconLoader;
import com.vladsch.flexmark.util.html.ui.Color;

import javax.swing.*;
import java.awt.event.*;

public class ConnectDialogOld extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JPasswordField passwordField1;
    private JTextArea youCanAlsoManuallyTextArea;
    private JList list1;

    public ConnectDialogOld() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        HttpServer.stopHttpServer();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        HttpServer.stopHttpServer();
        dispose();
    }

    public static void main(String[] args) {
        ConnectDialogOld dialog = new ConnectDialogOld();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // place custom component creation code here
    }
}
