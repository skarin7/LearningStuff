package com.practice.latest.codingpatterns;

import java.util.PriorityQueue;

public class MaxMinHeapExamples {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((t1, t2) -> t2 - t1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((t1, t2) -> t1 - t2);
        int[] data = new int[] {100, 23,5,15,26};

        for (int i = 0; i< data.length; i++) {
            maxHeap.add(data[i]);
            minHeap.add(data[i]);
        }
        while (maxHeap.iterator().hasNext()) {
            System.out.printf("\n MaxHeap Peek is \n" + maxHeap.peek());
            maxHeap.poll();
        }

        while (minHeap.iterator().hasNext()) {
            System.out.printf(" \n MinHeap Peek is \n" + minHeap.peek());
            minHeap.poll();
        }

    }
}
