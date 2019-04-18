package com.onedayrex.git.springhandle.api.thread;

public class ReCodeVolatile {

    int a = 0;
    boolean flag = false;


    public void write() {
        a = 1;
        flag = true;
        System.out.println(a);
    }

    public void read() {
        if (flag) {
            int i = a + a;
            System.out.println(i);
        }
    }
}
