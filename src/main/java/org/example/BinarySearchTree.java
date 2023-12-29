package org.example;

import java.util.*;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;


    private Node<T> insertRecurseUtil(Node<T> node, T value) {
        if (node == null) {
            node = new Node<>(value);
            return node;
        }

        if (node.value.compareTo(value) >= 0) {
            node.left = insertRecurseUtil(node.left, value);
        } else {
            node.right = insertRecurseUtil(node.right, value);
        }

        return node;
    }

    void insert(T value) {
        if (root == null) {
            root = insertRecurseUtil(null, value);
            return;
        }

        insertRecurseUtil(root, value);
    }

    private void inorderTraversal(Node<T> node, List<T> list) {
        if (node.getLeft() != null) inorderTraversal(node.getLeft(), list);
        list.add(node.getData());
        if (node.getRight() != null) inorderTraversal(node.getRight(), list);
    }

    List<T> getAsSortedList() {
        List<T> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    List<T> getAsLevelOrderList() {
        if (root == null) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> curr = queue.poll();
            result.add(curr.getData());

            if (curr.getLeft() != null) queue.offer(curr.getLeft());
            if (curr.getRight() != null) queue.offer(curr.getRight());
        }

        return result;
    }

    Node<T> getRoot() {
        return root;
    }

    static class Node<T> {

        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return value;
        }


    }
}
