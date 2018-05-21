package com.onedayrex.git.springhandle.main.bean;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CASMain {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        CASUpdate casUpdate = new CASUpdate(1);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new CASRunnAble(casUpdate));
        }
        countDownLatch.await();
    }
}
