package com.onedayrex.git.springhandle.common.bean;

public class TreeNode {
    private Node root;

    private class Node{
        private Node parent;
        private int value;
        private Node left;
        private Node right;

    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (root == null) {
            root = node;
            return;
        }
        node.parent = root;
        addNode(node);
    }

    private void addNode(Node node) {
        if (node.parent.value <= node.value) {
            //比父节点大，向右走
            if (node.parent.right == null) {
                node.parent.right = node;
            }else {
                node.parent = node.parent.right;
                addNode(node);
            }
        }else {
            //比父节点小，向左走
            if (node.parent.left == null) {
                node.parent.left = node;
            }else {
                node.parent = node.parent.left;
                addNode(node);
            }
        }
    }
}
