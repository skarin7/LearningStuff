package com.practice.generics;

import static  org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by shankar on 5/5/17.
 */
public class MultiPramaGenericsTest<K, V > {

    K key;
    V value;

    MultiPramaGenericsTest(K key, V value) {
        this.key = key;
        this.value =value;
    }

    public MultiPramaGenericsTest() {}


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public  V printValue(V v) {
        return v;
    }

    public <U extends Number, V extends Number> boolean compare(U a, V b) {
        return a.intValue() == b.intValue();
    }

    @Test
    public void testGenericPrint() {
        MultiPramaGenericsTest<String, Integer> sampl = new
                MultiPramaGenericsTest<>();
        assertEquals("123", "" +sampl.printValue(123));
    }

    @Test
    public void testGenericMethodParams() {
        MultiPramaGenericsTest<Integer, Integer> sampl = new MultiPramaGenericsTest<>(12, 14);
        assertTrue(sampl.compare(12, 12));
    }


}
