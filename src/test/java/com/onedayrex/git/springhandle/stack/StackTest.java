package com.onedayrex.git.springhandle.stack;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StackTest {
    private static final Logger logger = LoggerFactory.getLogger(StackTest.class);

    @Test
    public void add() {
        Stack<String> stack = new SeqStack<>();
        String[] str = {"1", "2", "5", "7"};
        for (String s : str) {
            stack.add(s);
        }
        logger.info("create stack==>{}", Arrays.toString(str));
    }

    @Test
    public void pop() {

    }

    @Test
    public void peek() {
    }

    @Test
    public void isEmpty() {
    }
}