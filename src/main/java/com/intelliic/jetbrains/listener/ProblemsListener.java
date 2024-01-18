package com.intelliic.jetbrains.listener;

import com.intellij.analysis.problemsView.Problem;
import org.jetbrains.annotations.NotNull;

public class ProblemsListener implements com.intellij.analysis.problemsView.ProblemsListener {


    @Override
    public void problemAppeared(@NotNull Problem problem) {
        //System.out.println("APPEARED");
    }

    @Override
    public void problemDisappeared(@NotNull Problem problem) {
        //System.out.println("DISAPPEARED");
    }

    @Override
    public void problemUpdated(@NotNull Problem problem) {
        //System.out.println("UPDATED");
    }
}
