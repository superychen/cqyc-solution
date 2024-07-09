package com.cqyc.jvm.utiltest.spi;

/**
 * @author: CQYC
 * @date: 2024-07-09-14:02
 */
public class Cat implements IShout{
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
