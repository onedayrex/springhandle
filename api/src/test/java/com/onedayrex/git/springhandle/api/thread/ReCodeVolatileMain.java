package com.onedayrex.git.springhandle.api.thread;

public class ReCodeVolatileMain {

    public static void main(String[] args) {
        ReCodeVolatile reCodeVolatile = new ReCodeVolatile();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reCodeVolatile.write();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reCodeVolatile.read();
            }
        });
        thread.start();
        thread1.start();
    }
}
