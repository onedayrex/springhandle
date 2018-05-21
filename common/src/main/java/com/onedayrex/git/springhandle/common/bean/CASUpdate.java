package com.onedayrex.git.springhandle.common.bean;

import sun.misc.Unsafe;

import java.io.Serializable;
import java.lang.reflect.Field;

public class CASUpdate implements Serializable {
    private static Unsafe unsafe;
    private static final long serialVersionUID = -1080083493576046952L;
    private static long valueOffSet;

    private volatile int value;


    public CASUpdate(int value) {
        this.value = value;
    }
    private static Unsafe getUnsafe() throws Throwable {

        Class<?> unsafeClass = Unsafe.class;

        for (Field f : unsafeClass.getDeclaredFields()) {

            if ("theUnsafe".equals(f.getName())) {

                f.setAccessible(true);

                return (Unsafe) f.get(null);

            }

        }
        throw new IllegalAccessException("no declared field: theUnsafe");

    }

    static {
        try {
            unsafe = getUnsafe();
            valueOffSet = unsafe.objectFieldOffset(CASUpdate.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    private boolean compareAndSet(int expect, int desc) {
        return unsafe.compareAndSwapInt(this, valueOffSet, expect, desc);
    }

    public int getAndUpdate() {
        //获取原值
        int expt,next;
        do {
            expt = value;
            next = this.next(expt);
        } while (!compareAndSet(expt, next));
        return next;
    }

    private synchronized int next(int expt) {
        return ++expt;
    }

}
