package com.cqyc.solution.designmoshi.zerenlian;

/**
 * @author cqyc
 * @create 2023-10-25-13:53
 */
public class ConcreteHandler extends Handler{

    @Override
    public void handleRequest() {
        Handler handler = getHandler();
        if(handler != null) {
            System.out.println("当前处理者不为空");
            handler.handleRequest();
        } else {
            System.out.println("处理者在处理真正的逻辑，比如吃猪蹄！！");
        }
    }
}
