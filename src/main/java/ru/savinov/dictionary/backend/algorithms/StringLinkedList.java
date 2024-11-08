package ru.savinov.dictionary.backend.algorithms;

/**
 * размером 5 (высота) на 10 (ширина),
 */
public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement != null) && (currentElement != last)) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node newNode = new Node();
        newNode.value = value;
        if (first.value == null) {
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}



