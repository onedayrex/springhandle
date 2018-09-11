package com.onedayrex.git.springhandle.api.guava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadRunnable implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(ThreadRunnable.class);
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            logger.info("the thread [{}] is running",Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
