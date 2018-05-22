package com.onedayrex.git.springhandle.common.bean;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {

    @Test
    public void add() {
        int[] value = {3, 2, 5, 4, 1, 6, 9};
        TreeNode treeNode = new TreeNode();
        for (int i : value) {
            treeNode.add(i);
        }
        System.out.println(treeNode);
    }
}