package com.practice.latest;

import java.util.BitSet;

public class BloomFilterWithBitSet {

    static class MyBloom {
        BitSet bitSet;
        int DEFAULT_NUM_HASHES = 3;

        int bloom_bit_size;
        MyBloom(int numOfHashes, int bloom_bit_size) {
            this.bloom_bit_size = bloom_bit_size;
            this.bitSet = new BitSet(bloom_bit_size);
        }

        void addMember(String data) {
            //calculate hashes from number of hash functions and add bit set
            for (int i=0; i< DEFAULT_NUM_HASHES; i++) {
                int hash = getHash(data, i);
                bitSet.set(hash);
            }
        }

        private int getHash(String data, int seed) {
            int hash = data.hashCode() ^ (seed * 31);
            return Math.abs(hash) % bloom_bit_size; //cap it to the bit array size
        }


        boolean isMemberExists(String data) {
            System.out.println("BitSet data is" + bitSet.toString());
            for (int i=0; i< DEFAULT_NUM_HASHES; i++) {
                int hash = getHash(data, i);
                System.out.println(" Hash for data " + hash + " and seed is " + i);
                if(!bitSet.get(hash)) {
                    return false;
                }

            }

            return true;
        }


    }


    public static void main(String[] args) {
        MyBloom bloom = new MyBloom(5, 50);
        bloom.addMember("shankar");
        bloom.addMember("Aadhya");
        bloom.addMember("Pallavi");

        System.out.println("isMemberExists : " + bloom.isMemberExists("Aadhya"));
    }
}
