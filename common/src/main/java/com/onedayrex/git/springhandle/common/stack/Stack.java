package com.onedayrex.git.springhandle.common.stack;

public interface Stack<T> {

    public void add(T data);

    public T pop();

    public T peek();

    public boolean isEmpty();
}
