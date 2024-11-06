package com.practice;

import java.util.*;

public class LRUCacheDriver {

    //fixed size cache
    //when cache is full, evict the unused item in the array
    // Cache should work for all types values (Object)

    static class LRUCache<K, V> {
        int CACHE_SIZE = 10;
        final Map<K,V> cache;
        final Deque<K> trackUsage;

       public LRUCache() {
            this.cache = new HashMap<>();
            this.trackUsage = new LinkedList<>();
        }

        public LRUCache(int cacheSize) {
           this();
           this.CACHE_SIZE = cacheSize;
        }

       public V getItem(K key) {
            //check if the key is present
            // return -1 if not present
            //if yes, add that key to front of th queue

            if(cache.containsKey(key)) {
                trackUsage.remove(key);
                trackUsage.addFirst(key);
                return cache.get(key);
            }
            return null;
        }

        void putItem(K key, V value) {
            //check if the size if full, then event the oldest items in the queue
            // else add item to cache and to the queue
            if(cache.size() >= CACHE_SIZE) {
                System.out.println("Cache is full, evicting the older item...");
                K itemToEvict = trackUsage.removeLast();
                cache.remove(itemToEvict);
            }
            addItem(key, value);
        }

        private void addItem(K key, V value) {
            System.out.println(" Adding item = " + key + "  to the cache...");
            cache.put(key, value);
            trackUsage.offer(key);
        }

        void printCacheItems() {
            System.out.println(" Printing the cache..\n");
            trackUsage.forEach(key -> {
                System.out.println(" Key=" + key +" ," + " Value=" + cache.get(key));
            });
        }
    }


    public static void main(String[] args) {
        LRUCacheDriver driver = new LRUCacheDriver();
        int cacheSize = 5;
        LRUCache<String, String> cacheData = new LRUCacheDriver.LRUCache(cacheSize);
        int limt = 6;
        for (int i = 0; i < limt; i++) {
            cacheData.putItem("item" + i, "price" + i);
        }

        String itemToCheck = "item1";
        System.out.println(" Find cache for the item " + itemToCheck + " is " + cacheData.getItem(itemToCheck));
        cacheData.printCacheItems();
    }
}
