package com.cqyc.jvm.utiltest;


/**
 * @author: CQYC
 * @date: 2024-04-08-14:32
 */
public class JHSDB_TestCase {

    static class Test {
        //这里会存在方法区中
        static ObjectHolder staticObj = new ObjectHolder();
        //这里会放在java堆中
        ObjectHolder instanceObj = new ObjectHolder();
        void foo() {
            //这里会放到局部变量表中
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设一个断点
        }
    }
    private static class ObjectHolder {}

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();

    }

}
