package com.onedayrex.git.springhandle.common.bean;

public class TreeNode {
    private Node root;

    public class Node{
        private Node parent;
        private int value;
        private Node left;
        private Node right;

        public Node getParent() {
            return parent;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (root == null) {
            root = node;
            return;
        }
        Node parent = root;
        while (true) {
            if (parent.value <= node.value) {
                //比父节点大，向右走
                if (parent.right == null) {
                    parent.right = node;
                    node.parent = parent;
                    break;
                }else {
                    parent = parent.right;
                    continue;
                }
            }else {
                //比父节点小，向左走
                if (parent.left == null) {
                    parent.left = node;
                    node.parent = parent;
                    break;
                }else {
                    parent = parent.left;
                    continue;
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (true) {
            if (current == null) {
                //tree is empty
                return null;
            }
            if (current.value == key) {
                return current;
            } else if (current.value < key) {
                //right
                current = current.right;
            }else {
                //left
                current = current.left;
            }
        }
    }

}
