package org.example;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    private Node<T> head;
    private int size;

    SimpleLinkedList() {
        head = null;
    }

    SimpleLinkedList(T[] values) {
        for (int i = 0; i < values.length; i++) push(values[i]);
    }

    void push(T value) {
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node<>(value);
        size++;
    }

    T pop() {
        if (head == null) {
            throw new NoSuchElementException("list is empty");
        }

        T poppedValue;
        Node<T> temp = head;
        if (temp.next == null) {
            poppedValue = temp.value;
            head = null;
            size--;
            return poppedValue;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }

        poppedValue = temp.next.value;
        temp.next = null;
        size--;
        return poppedValue;
    }

    void reverse() {
        if (head == null || head.next == null) return;

        Node<T> prev = null;
        Node<T> curr = head;
        while (curr.next != null) {
            Node<T> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        curr.next = prev;

        head = curr;
    }

    T[] asArray(Class<T> clazz) {
        T[] arr = (T[]) Array.newInstance(clazz, size);

        Node<T> temp = head;
        for (int i = size - 1; temp != null; i--, temp = temp.next) {
            arr[i] = temp.value;
        }

        return arr;
    }

    int size() {
        return size;
    }

    private class Node<T> {
        private final T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }
}

