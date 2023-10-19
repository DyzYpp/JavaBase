package com.example.javabasedemo.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class ThreadTest {



    public static void main(String[] args) {
//        printBasketBallBySynchronized();
        printBasketBallByLockSupport();
    }

    private static volatile boolean exec = false;

    private static void printBasketBallByLockSupport() {
        Map<String, Thread> map = new ConcurrentHashMap<>();
        new Thread(() -> {
            map.put("basket", Thread.currentThread());
            for (int i = 0; i < 5; i++) {
                if (exec)  {
                    LockSupport.park();
                }
                System.out.println("basket");
                exec = true;
                LockSupport.unpark(map.get("ball"));
            }
        }).start();

        new Thread(() -> {
            map.put("ball", Thread.currentThread());
            for (int i = 0; i < 5; i++) {
                if (!exec) {
                    LockSupport.park();
                }
                System.out.println("ball");
                exec = false;
                LockSupport.unpark(map.get("basket"));
            }
        }).start();
    }

    private static void printBasketBallBySynchronized() {
        Object obj = new Object();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (obj) {
                    if (exec) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("basket");
                    exec = true;
                    obj.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (obj) {
                    if (!exec) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("ball");
                    exec = false;
                    obj.notifyAll();
                }
            }
        }).start();
    }
}
