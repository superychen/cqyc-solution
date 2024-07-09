package com.cqyc.jvm.utiltest.spi;

import java.util.ServiceLoader;

/**
 * @author: CQYC
 * @date: 2024-07-09-14:02
 */
public class Dog implements IShout{
    @Override
    public void shout() {
        System.out.println("wang wang");
    }


}
