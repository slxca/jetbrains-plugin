package com.intelliic.jetbrains.listener;

import com.intelliic.jetbrains.Intelliic;
import com.intellij.diagnostic.IdePerformanceListener;
import com.intellij.diagnostic.ThreadDump;
import com.sun.management.OperatingSystemMXBean;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.lang.management.ManagementFactory;

public class PerformanceListener implements IdePerformanceListener {


    @Override
    public void dumpedThreads(@NotNull File file, @NotNull ThreadDump threadDump) {
        System.out.println(threadDump);
    }

    @Override
    public void uiResponded(long latencyMs) {
        //System.out.println(latencyMs);

        OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double cpuLoad = osBean.getSystemCpuLoad();
        System.out.println("IDE CPU Usage: " + (cpuLoad * 100) + "%");

        long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long totalMemory = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;

        System.out.println("IDE RAM Usage: " + usedMemory + " MB (" + usedMemory + "/" + totalMemory + " (" + freeMemory + "))");

        long physicalMemorySize = osBean.getTotalMemorySize() / (1024 * 1024);
        long physicalFreeMemorySize = osBean.getFreeMemorySize() / (1024 * 1024);
        long physicalUsesMemorySize =  physicalMemorySize - physicalFreeMemorySize;

        System.out.println("System RAM Usage: " + physicalUsesMemorySize + " MB (" + physicalUsesMemorySize + "/" + physicalMemorySize + " (" + physicalFreeMemorySize + "))");

        System.out.println("---------------------------------");

        Intelliic intelliic = new Intelliic();
        System.out.println(intelliic.getCollector());
        System.out.println(intelliic.getSession());

        System.out.println("---------------------------------");

    }
}

