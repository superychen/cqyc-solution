package com.cqyc.jvm.gctest;

/**
 * 引用计数器
 * @author: CQYC
 * @date: 2024-01-02-17:50
 * 引用技术算法缺陷：当两个对象循环引用时如何能被gc
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义是占点内存，一边能在gc日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC obj1 = new ReferenceCountingGC();
        ReferenceCountingGC obj2 = new ReferenceCountingGC();
        obj1.instance = obj2;
        obj2.instance = obj1;

        obj1 = null;
        obj2 = null;

        //假设这里发生GC，obj1和obj2是否能被回收？
        System.gc();

    }
}
