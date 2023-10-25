package com.cqyc.solution.designmoshi.zerenlian;

/**
 * @author cqyc
 * @create 2023-10-25-13:48
 */
public abstract class Handler {

    private Handler handler;

    public abstract void handleRequest();

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }


}
