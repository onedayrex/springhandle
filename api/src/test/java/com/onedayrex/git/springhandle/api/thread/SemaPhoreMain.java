package com.onedayrex.git.springhandle.api.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaPhoreMain {

    public static void main(String[] args) {
        //开一个固定只有300个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(300);
        //最多只能让20个线程同时获取资源
        final Semaphore semaphore = new Semaphore(20);
        //模拟同时有500个请求进来
        for (int i = 0; i < 9999999; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    //获取一个许可
                    semaphore.acquire();
                    execute(threadNum);
                    //释放一个许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void execute(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum" + threadNum);
        Thread.sleep(1000);
    }
}
