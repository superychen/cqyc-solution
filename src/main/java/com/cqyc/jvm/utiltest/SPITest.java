package com.cqyc.jvm.utiltest;

import com.cqyc.jvm.utiltest.spi.IShout;

import java.util.ServiceLoader;

/**
 * @author: CQYC
 * @date: 2024-07-09-14:05
 */
public class SPITest {

    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout shout : shouts) {
            shout.shout();
        }
    }
}
