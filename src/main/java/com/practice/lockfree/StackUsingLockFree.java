package com.practice.lockfree;

import java.util.concurrent.atomic.AtomicReference;

public class StackUsingLockFree<T> {

    AtomicReference<Node<T>> stackHead = new AtomicReference<>();

    class Node<T> {
        private T value;
        private Node<T> next;
        Node(T value , Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(T value) {
        Node<T> newHead = new Node<>(value, null);
        while (true) {
            Node<T> currentHead = stackHead.get(); // Read the current head
            newHead.next = currentHead; // Set the new head's next to the current head

            // Try to update the head to the new node
            if (stackHead.compareAndSet(currentHead, newHead)) {
                return; // Successfully pushed, exit the method
            }
            // If the update fails, the loop repeats and retries
        }
    }

    public T pop() {
        while (true) {
            //allows the operation to keep trying untill the compare and set return true.
            // otherwise there is a chance that it might update wrong data
            Node<T> currentHead = stackHead.get();
            if (currentHead == null) {
                return null; // Stack is empty
            }
            if (stackHead.compareAndSet(currentHead, currentHead.next)) {
                return currentHead.value; // Successfully popped
            }
        }
    }

    public void print() {
        Node<T> tNode = stackHead.get();
        while (tNode != null) {
            System.out.println(tNode.value);
            tNode = tNode.next;
        }
    }

    public static void main(String[] args) {
        StackUsingLockFree<String> stringStackUsingLockFree = new StackUsingLockFree<>();
        stringStackUsingLockFree.push("Hello");
        stringStackUsingLockFree.push("World");
        stringStackUsingLockFree.push("123");

        stringStackUsingLockFree.print();

    }


}
