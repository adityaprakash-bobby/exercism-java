package org.example;

class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        if (head == null) {
            head = new Element<>(value, null, null);
            return;
        }

        Element<T> curr = head;
        while (curr.next != null) curr = curr.next;

        curr.next = new Element<>(value, curr, null);
    }

    T pop() {
        if (head == null) return null;

        Element<T> curr = head;
        T retValue;
        while (curr.next != null) curr = curr.next;

        if (curr == head) {
            retValue = curr.value;
            head = null;

            return retValue;
        }

        Element<T> prev = curr.prev;
        prev.next = null;

        retValue = curr.value;
        curr = null;

        return retValue;
    }

    void unshift(T value) {
        if (head == null) {
            head = new Element<>(value, null, null);
            return;
        }

        Element<T> newHead = new Element<>(value, null, head);
        head.prev = newHead;
        head = newHead;
    }

    T shift() {
        if (head == null) return null;

        Element<T> demotedHead = head;
        head = head.next;

        T retValue = demotedHead.value;
        demotedHead = null;

        return retValue;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}

