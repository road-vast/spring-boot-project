package com.itcast.springboot.Main;

import com.itcast.springboot.thread.MyThread;

public class MyMain {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("初级用户", 10);
        MyThread mt2 = new MyThread("高级用户", 20);
        mt1.start();
        mt2.start();
    }
}
