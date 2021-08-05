package implementations;

import interfaces.AbstractBinarySearchTree;

import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private E key;
    private Node<E> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node<E> root) {
        this.copy(root);
    }

    private void copy(Node<E> root) {
        if (root == null) {
            return;
        }
        this.insert(root.value);
        this.copy(root.leftChild);
        this.copy(root.rightChild);
    }

    @Override
    public void insert(E element) {
        if (getRoot() == null) {
            this.root = new Node<>(element, null, null);
        }

        insert(element, getRoot());
    }

    private void insert(E element, Node<E> node) {
        if (node.value.compareTo(element) == 0) {
            return;
        }
        if (node.value.compareTo(element) > 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(element, null, null);
            } else {
                insert(element, node.leftChild);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(element, null, null);
            } else {
                insert(element, node.rightChild);
            }
        }
    }

    @Override
    public boolean contains(E element) {
        return search(element) != null;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> result = this.root;

        if (result.value == null) {
            return null;
        }

        Node<E> search = search(element, result);

        return new BinarySearchTree<>(search);
    }

    private Node<E> search(E element, Node<E> node) {

        if (node.value == element) {
            return new Node<>(node.value, node.leftChild, node.rightChild);
        }

        if (node.value.compareTo(element) < 0) {
            return search(element, node.rightChild);
        }
        return search(element, node.leftChild);

    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.root.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.root.rightChild;
    }

    @Override
    public E getValue() {
        return this.key;
    }
}
