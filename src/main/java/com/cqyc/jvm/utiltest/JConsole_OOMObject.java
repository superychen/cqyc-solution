package com.cqyc.jvm.utiltest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CQYC
 * @date: 2024-04-08-15:10
 */
public class JConsole_OOMObject {

    /**
     * 内存占位符对象，一个OOMObject大约占64KB
     * 这段代码的作用是以64KB/50ms的速度向Java堆中填充数据，一共填充1000次，使用JConsole
     * 的“内存”页签进行监视，观察曲线和柱状指示图的变化。
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
        // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }
    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

}
