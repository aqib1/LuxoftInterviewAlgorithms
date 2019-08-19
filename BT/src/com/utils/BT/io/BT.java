package com.utils.BT.io;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BT<V> {
	private Node<V> root;

	public BT() {

	}

	public BT(V value, int key) {
		addRoot(value, key);

	}

	private void addRoot(V value, int key) {
		if (Objects.isNull(root)) {
			root = new Node<>(value, key);
		} else {
			addChildNodes(root, value, key);
		}
	}

	public void add(int key, V value) {
		addRoot(value, key);
	}

	private void addChildNodes(Node<V> root, V value, int key) {
		if (key > root.key) {
			// right tree
			if (Objects.isNull(root.rightNode)) {
				root.rightNode = new Node<>(value, key);
			} else {
				addChildNodes(root.rightNode, value, key);
			}
		} else {
			// left tree
			if (Objects.isNull(root.leftNode)) {
				root.leftNode = new Node<>(value, key);
			} else {
				addChildNodes(root.leftNode, value, key);
			}
		}

	}

	public Node<V> findNode(int key) {
		return find(root, key);
	}

	private Node<V> find(Node<V> node, int key) {
		if (Objects.isNull(node))
			return null;
		if (key == node.key) {
			return node;
		} else if (key > node.key) {
			return find(node.rightNode, key);
		} else {
			return find(node.leftNode, key);
		}
	}

	public void traverseBT(BTTraversal btTraversal, BT<V>.Node<V> newRoot) {
		switch (btTraversal) {
		case LEVEL_ORDER:
			levelOrderTraversal(newRoot);
			break;
		case IN_ORDER:
			inOrderTraversal(newRoot);
			break;
		case POST_ORDER:
			postOrderTraversal(newRoot);
			break;
		case PRE_ORDER:
			preOrderTraversal(newRoot);
			break;
		case SPIRAL_TRAVERSAL:
			spiralTraversal(newRoot);
			break;
		default:
			break;
		}
	}

	private void spiralTraversal(BT<V>.Node<V> newRoot) {
		Stack<BT<V>.Node<V>> leftToRight = new Stack<>();
		Stack<BT<V>.Node<V>> rightToLeft = new Stack<>();
		rightToLeft.push(newRoot);
		while (!rightToLeft.isEmpty()) {
			BT<V>.Node<V> node = rightToLeft.pop();
			if (!Objects.isNull(node)) {
				System.out.println(node);
				leftToRight.push(node.leftNode);
				leftToRight.push(node.rightNode);
				while (!leftToRight.isEmpty()) {
					BT<V>.Node<V> n = leftToRight.pop();
					if (!Objects.isNull(n)) {
						System.out.println(n);
						rightToLeft.push(n.rightNode);
						rightToLeft.push(n.leftNode);
					}
				}
			}
		}

	}

	private void preOrderTraversal(BT<V>.Node<V> newRoot) {
		// PRE-ORDER (ROOT - LEFT - RIGHT)
		if (!Objects.isNull(newRoot)) {
			System.out.println(newRoot);
			preOrderTraversal(newRoot.leftNode);
			preOrderTraversal(newRoot.rightNode);
		}

	}

	private void postOrderTraversal(BT<V>.Node<V> newRoot) {
		// POST-ORDER (LEFT - RIGHT - ROOT)
		if (!Objects.isNull(newRoot)) {
			postOrderTraversal(newRoot.leftNode);
			postOrderTraversal(newRoot.rightNode);
			System.out.println(newRoot);
		}

	}

	private void inOrderTraversal(BT<V>.Node<V> newRoot) {
		// IN-ORDER (LEFT - ROOT- RIGHT)
		if (!Objects.isNull(newRoot)) {
			inOrderTraversal(newRoot.leftNode);
			System.out.println(newRoot);
			inOrderTraversal(newRoot.rightNode);
		}
	}

	public void traverseBT(BTTraversal btTraversal) {
		traverseBT(btTraversal, root);
	}

	private void levelOrderTraversal(BT<V>.Node<V> newRoot) {
		Queue<Node<V>> queue = new LinkedList<BT<V>.Node<V>>();
		queue.add(newRoot);

		while (!queue.isEmpty()) {
			Node<V> node = queue.poll();
			System.out.println(node);

			if (!Objects.isNull(node.leftNode))
				queue.add(node.leftNode);

			if (!Objects.isNull(node.rightNode))
				queue.add(node.rightNode);
		}
	}

	class Node<M> {
		private int key;
		private M value;
		private Node<M> leftNode;
		private Node<M> rightNode;

		public Node() {
		}

		public Node(M value, int key) {
			this.value = value;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", leftNode=" + leftNode + ", rightNode=" + rightNode
					+ "]";
		}

	}
}
