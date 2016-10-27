package com.practice;

public class MyLinkedList {

    static ListNode head;
    static ListNode tail;

    public void addNode(int value) {
        ListNode temp;
        if (null == head) {
            head = new ListNode(value);
            head.setNext(null);
            tail = head;
        } else {
            temp = new ListNode(value);
            temp.next = null;
            tail.setNext(temp);
            tail = temp;
        }

    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.getNext();
        }
    }

    void reverseLinkedList() {
        ListNode prev = null, current, next = null;
        current = head;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
    }

    public class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 8; i++) {
            list.addNode(i);
        }

        list.printList(head);
        list.reverseLinkedList();
        System.out.println("Now printing reverse singly linked lists");
        list.printList(tail);

    }
}
