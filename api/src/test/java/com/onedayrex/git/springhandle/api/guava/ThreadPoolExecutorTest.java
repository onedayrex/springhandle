package com.onedayrex.git.springhandle.api.guava;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolExecutorTest.class);

    //主线程
    public void main(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.execute(new ThreadRunnable());
        threadPoolExecutor.execute(new ThreadRunnable());
        threadPoolExecutor.execute(new ThreadRunnable());
        logger.info("---先开三个---");
        logger.info("核心线程数" + threadPoolExecutor.getCorePoolSize());
        logger.info("线程池数" + threadPoolExecutor.getPoolSize());
        logger.info("队列任务数" + threadPoolExecutor.getQueue().size());
        threadPoolExecutor.execute(new ThreadRunnable());
        threadPoolExecutor.execute(new ThreadRunnable());
        threadPoolExecutor.execute(new ThreadRunnable());
        logger.info("---再开三个---");
        logger.info("核心线程数" + threadPoolExecutor.getCorePoolSize());
        logger.info("线程池数" + threadPoolExecutor.getPoolSize());
        logger.info("队列任务数" + threadPoolExecutor.getQueue().size());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("----8秒之后----");
        logger.info("核心线程数" + threadPoolExecutor.getCorePoolSize());
        logger.info("线程池数" + threadPoolExecutor.getPoolSize());
        logger.info("队列任务数" + threadPoolExecutor.getQueue().size());
    }

    /**
     * 使用SynchronousQueue作为work队列
     * 当前线程数<核心线程数
     * 结果:线程数<核心线程数，会直接开新线程执行，不会放到队列中
     *
     * 核心线程数<线程数<最大线程数 会直接开出超时线程执行，执行完成后超时5秒的超时线程被回收
     *
     * 最大线程数<线程数 抛出异常
     */
    @Test
    public void sync_thread_lt_coreThread() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6,10,5, TimeUnit.SECONDS,new SynchronousQueue<>());
        this.main(threadPoolExecutor);
    }

    /**
     * 使用LinkedBlockingDeque作为work队列
     * 核心线程<当前线程<最大线程
     * 结果：超过核心线程数会放到work队列中，等待核心线程可用后再执行
     *
     * 当work队列没有设置大小时，则不受影响，但是当work队列设置大小，并且线程数超过了最大线程+队列，则会抛出异常
     */
    @Test
    public void link_thread_gt_coreThread_lt_maxThread() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,4,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2));
        this.main(threadPoolExecutor);
    }


}
