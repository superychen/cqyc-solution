package com.cqyc.jvm.gctest;

import java.util.Map;

/**
 * @author: CQYC
 * @date: 2024-04-01-9:37
 */
public class AllocationEdenTest {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; //分配4MB，出现一次minor gc

        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stack = stackTrace.getValue();
            if(thread.equals(Thread.currentThread())) {
                continue;
            }
            System.out.println("\n线程：" + thread.getName() + "\n");
            for (StackTraceElement element : stack) {
                System.out.println("\t"+element+"\n");
            }

        }
    }
}
