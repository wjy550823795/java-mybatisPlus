package com.sys.entity;

public class Node {
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }
        public void addNode(int data) {
            if (data < this.data) {
                if (this.left == null) {
                    this.left=new Node(data);
                } else {
                    this.left.addNode(data);
                }
            } else if (data >= this.data) {
                if (this.right == null) {
                    this.right=new Node(data);
                } else {
                    this.right.addNode(data);
                }
            }
        }
        //二叉树的中序遍历
        public void printNode() {
            if (this.left != null) {
                this.left.printNode();
            }
            System.out.println(this.data + " ");
            if (this.right != null) {
                this.right.printNode();
            }
        }
}
