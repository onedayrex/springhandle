package com.onedayrex.git.springhandle.stack;

import java.io.Serializable;

public class SeqStack<T> implements Stack<T>,Serializable {

    private static final long serialVersionUID = -4957038644396708077L;

    private int top = -1;

    /**
     * 存放数据内容
     */
    private T[] array;

    private int size = 0;

    /**
     * 默认容量10
     */
    private int capacity = 10;

    public SeqStack(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public SeqStack() {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (array.length <= size) {
            //扩容
            this.ensureCapacity(capacity * 2 + 1);
        }
        array[++top] = data;
        size++;
    }

    private void ensureCapacity(int i) {
        if (capacity > i) {
            return;
        }
        T[] oldArray = array;
        array = (T[]) new Object[i];
        System.arraycopy(oldArray, 0, array, 0, oldArray.length);
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        size--;
        return array[top--];
    }

    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }
}
