package com.onedayrex.git.springhandle.common.bean;

import org.junit.Test;

public class PerfectTreeNodeTest {

    @Test
    public void add() {
        int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        PerfectTreeNode perfectTreeNode = new PerfectTreeNode();
        for (int i : value) {
            perfectTreeNode.add(i);
        }
        System.out.println(perfectTreeNode);
    }
}