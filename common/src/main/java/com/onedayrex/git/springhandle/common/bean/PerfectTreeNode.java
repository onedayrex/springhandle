package com.onedayrex.git.springhandle.common.bean;

import java.util.LinkedList;
import java.util.List;

public class PerfectTreeNode {

    private List<Node> nodeList = new LinkedList<>();

    public void add(int data) {
        Node node = new Node();
        node.data = data;
        nodeList.add(node);
        //关联节点
        for (int i = 1; i <= nodeList.size()/2; i++) {
            nodeList.get(i - 1).left = nodeList.get(i * 2 - 1);
            //右节点有可能不存在
            if (i * 2 < nodeList.size()) {
                nodeList.get(i - 1).right = nodeList.get(i * 2);
            }
        }
    }

    /**
     * DLR
     */
    public String preOrder() {
        Node current = nodeList.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodeList.size() / 2; i++) {
        }
        return null;
    }


    private static class Node{
        private Node left;
        private Node right;
        private int data;
    }
}
