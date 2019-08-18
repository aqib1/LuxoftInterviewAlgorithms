package java.utils.BT.io;
import java.util.Objects;

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
