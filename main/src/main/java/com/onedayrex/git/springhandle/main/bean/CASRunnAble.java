package com.onedayrex.git.springhandle.main.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CASRunnAble implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(CASRunnAble.class);
    private CASUpdate casUpdate;

    public CASRunnAble(CASUpdate casUpdate) {
        this.casUpdate = casUpdate;
    }

    @Override
    public void run() {
        while (true) {
            int i = casUpdate.getAndUpdate();
//            logger.info("Thread==>[{}],Add==>[{}]", Thread.currentThread().getName(), i);
            System.out.println("Thread==>" + Thread.currentThread().getName() + ",Add==>" + i);
        }
    }
}
