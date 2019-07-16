package com.gs.ilp.ds;

import java.util.Random;

class BinaryTree {

	private static Random random = new Random();

	private class Node {
		Object value;
		Node left;
		Node right;

		public Node(Object value) {
			super();
			this.value = value;
		}

	}

	private Node root;

	public BinaryTree(Object[] values) {
		for (int i = 0; i < values.length; i++) {
			add(root, values[i]); // { 24, 78, 23, -90, 56, 45, 54 };
		}
	}

	private void add(Node currentNode, Object value) {
		if (currentNode == null) {
			this.root = new Node(value);
			return;
		}
		if (random.nextBoolean()) { // true : right
			if (currentNode.right != null) {
				add(currentNode.right, value);
			} else {
				currentNode.right = new Node(value);
			}

		} else { // false : left
			if (currentNode.left != null) {
				add(currentNode.left, value);
			} else {
				currentNode.left = new Node(value);
			}

		}

	}
	
	public void traverse(Node currentNode) {
		// code to print the values of the tree
		//root
	}
	
	public String toString() {
		return null;
	}

}

public class BinaryTreeExample {
	public static void main(String[] args) {

		Integer[] arr = { 24, 78, 23, -90, 56, 45, 54 };
		BinaryTree binaryTree = new BinaryTree(arr);
	//	binaryTree.traverse();
		// bin
	}

}
