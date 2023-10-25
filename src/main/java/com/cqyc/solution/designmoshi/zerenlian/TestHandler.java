package com.cqyc.solution.designmoshi.zerenlian;

/**
 * @author cqyc
 * @create 2023-10-25-13:56
 */
public class TestHandler {

    public static void main(String[] args) {
        ConcreteHandler handler1 = new ConcreteHandler();
        ConcreteHandler handler2 = new ConcreteHandler();
        ConcreteHandler handler3 = new ConcreteHandler();
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.handleRequest();
    }

}
