package com.practice.latest;

import java.util.Arrays;

public class MyBloomFilter {
    int k = 10;
    byte[] bloomIndexer;
    MyBloomFilter() {
        this.bloomIndexer = new byte[k];
    }

    void addItem(Integer x) {
        //pass it through set of hash functions and set the final result module of k
        hashAndPlace(x);

    }

    private void hashAndPlace(Integer x) {
        int position1 = hash1(x);
        bloomIndexer[position1] = 1;
        int position2 = hash2(x);
        bloomIndexer[position2] = 1;
        int position3 = hash3(x);
        bloomIndexer[position3] = 1;
        System.out.printf("Item: " + x + " added at positions: " + position1 + ", " + position2 + ", " + position3 );
    }


    boolean checkIfExists(Integer x) {
        int position1 = hash1(x);
        int position2 = hash2(x);
        int position3 = hash3(x);
        System.out.printf(" \n Hash indexes for Item: " + x + " are at positions: " + position1 + ", " + position2 + ", " + position3 );
        if(bloomIndexer[position1] == 1 || bloomIndexer[position2] ==1 || bloomIndexer [position3] ==1 ) {
            return true;
        }
        if (bloomIndexer[position1] != 1 || bloomIndexer[position2] != 1 || bloomIndexer[position3] != 1) {
            return false;
        }

        return false;
    }

    private Integer hash1(Integer x) {
        return  ((x*100) %11)%k;
    }

    private Integer hash2(Integer x) {
        return  ((x*10) %13)%k;
    }

    private Integer hash3(Integer x) {
        return  ((x*1000) %17)%k;
    }

    public static void main(String[] args) {
        //Driver
        MyBloomFilter mbf = new MyBloomFilter();
        int[] data = {4,55,69,78};
        Arrays.stream(data).forEach(mbf::addItem);
        int itemToSearch = 129;
        boolean result = mbf.checkIfExists(itemToSearch);
        System.out.printf("membership test for item:  " + itemToSearch + " is " + result);
    }
}
