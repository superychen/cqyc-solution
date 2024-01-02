package com.cqyc.jvm.oomtest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author: CQYC
 * @date: 2024-01-02-16:37
 * 使用cglib 來动态创建新类型，从而模拟堆中方法区发生oom异常
 */
public class CglibMethodAreaOom {

    /**
     * 此方法适用于1.6、1.7，在1.8因为直接使用的是Metaspace，很难出现内存溢出
     * 下面是1.8中元空间大小设置参数
     * -XX：MaxMetaspaceSize：设置元空间最大值，默认是-1，即不限制，或者说只受限于本地内存大小。
     * ·-XX：MetaspaceSize：指定元空间的初始空间大小，以字节为单位，达到该值就会触发垃圾收集进行类型卸载，同时收集器会对该值进行调整
     * -XX：MinMetaspaceFreeRatio：作用是在垃圾收集之后控制最小的元空间剩余容量的百分比，可减少因为元空间不足导致的垃圾收集的频率
     * @param args
     */
    public static void main(String[] args) {
       while(true) {
           Enhancer enhancer = new Enhancer();
           enhancer.setSuperclass(OOMObject.class);
           enhancer.setUseCache(false);
           enhancer.setCallback(new MethodInterceptor() {
               @Override
               public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                   return methodProxy.invokeSuper(o, objects);
               }
           });
           enhancer.create();
       }
    }

    static class OOMObject {
    }

}
