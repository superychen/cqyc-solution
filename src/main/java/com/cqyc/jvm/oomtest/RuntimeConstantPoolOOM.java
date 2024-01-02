package com.cqyc.jvm.oomtest;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法区和运行时常量池溢出
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 * String::intern()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的
 * 字符串，则返回代表池中这个字符串的String对象的引用；否则，会将此String对象包含的字符串添加
 * 到常量池中，并且返回此String对象的引用。
 * @author: CQYC
 * @date: 2023-12-29-17:07
 */
public class RuntimeConstantPoolOOM {
    /**
     * 这段适合jdk6之前，因为自JDK 7起，原本存放在永久代的字符串常量池被移至Java堆之中，所以在JDK 7及以上版
     * 本，限制方法区的容量对该测试用例来说是毫无意义的
     * @param args
     */
    public static void main(String[] args) {
        //使用set保持着常量池引用，避免full gc回收常量池行为
        Set<String> set = new HashSet<>();
        //在short范围内足以让6MB的permsize产生oom
        short i = 0;
//        while (true) {
//            set.add(String.valueOf(i++).intern());
//        }

        
        //jdk1.6，下面两段返回都是false，jdk1.7以上，是返回true、false
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        //这里Java字符串已经在堆中常量池引用了，不符合首次遇到原则，这里返回false
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
