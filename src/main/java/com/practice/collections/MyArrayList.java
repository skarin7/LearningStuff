package com.practice.collections;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int _INTIAL_SIZE = 2;
    int ARRAY_SIZE;
    Object[] DATA_ARRAY;
    private static int pos = 0;

    public MyArrayList() {
        this.ARRAY_SIZE = _INTIAL_SIZE;
        DATA_ARRAY = new Object[this.ARRAY_SIZE];

    }

    public void add(T data) {
        if (checkIfFull()) {
            increaseSize();
            System.out.println("Increase size :: " + DATA_ARRAY.length);
        }
        DATA_ARRAY[pos++] = data;
    }

    public void removeDataAtIndex(int index) {
        if (isEmpty()) {
            System.out.println("There is no data to remove");
            return;
        }
        if (index > pos) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < this.ARRAY_SIZE - 1; i++) {
            DATA_ARRAY[i] = DATA_ARRAY[i + 1];
        }

    }

    private void increaseSize() {
        this.ARRAY_SIZE = this.ARRAY_SIZE * 2;
        DATA_ARRAY = Arrays.copyOf(DATA_ARRAY, this.ARRAY_SIZE);
    }

    public Object getData(int index) {
        return DATA_ARRAY[index];
    }

    private boolean checkIfFull() {
        if (pos == this.ARRAY_SIZE - 1)
            return true;
        return false;
    }

    private boolean isEmpty() {
        return pos == 0;
    }

    @Override
    public String toString() {
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < this.ARRAY_SIZE; i++) {
            finalString.append("[ ").append(this.DATA_ARRAY[i]).append(" ]");
        }
        return finalString.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<Integer>();
        arr.add(new Integer(10));
        arr.add(new Integer(15));
        arr.add(new Integer(100));
        System.out.println("Befpre reoving : " + arr);
        System.out.println(arr.getData(2));
        arr.removeDataAtIndex(1);
        System.out.println("After removing element at 1 pos" + arr);
    }
}
