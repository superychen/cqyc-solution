package com.cqyc.jvm.utiltest;

/**
 * @author: CQYC
 * @date: 2024-04-08-15:28
 */
public class JConsole_DeadLock {

    /**
     * 线程死锁等待演示
     */
    static class SynAddRunalbe implements Runnable {
        int a, b;
        public SynAddRunalbe(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    /**
     * 这段代码开了200个线程去分别计算1+2以及2+1的值，理论上for循环都是可省略的，两个线程也
     * 可能会导致死锁，不过那样概率太小，需要尝试运行很多次才能看到死锁的效果。如果运气不是特别
     * 差的话，上面带for循环的版本最多运行两三次就会遇到线程死锁，程序无法结束。造成死锁的根本原
     * 因是Integer.valueOf()方法出于减少对象创建次数和节省内存的考虑，会对数值为-128～127之间的
     * Integer对象进行缓存[2]，如果valueOf()方法传入的参数在这个范围之内，就直接返回缓存中的对象。
     * 也就是说代码中尽管调用了200次Integer.valueOf()方法，但一共只返回了两个不同的Integer对象。假如
     * 某个线程的两个synchronized块之间发生了一次线程切换，那就会出现线程A在等待被线程B持有的
     * Integer.valueOf(1)，线程B又在等待被线程A持有的Integer.valueOf(2)，结果大家都跑不下去的情况
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunalbe(1, 2)).start();
            new Thread(new SynAddRunalbe(2, 1)).start();
        }
    }


}
