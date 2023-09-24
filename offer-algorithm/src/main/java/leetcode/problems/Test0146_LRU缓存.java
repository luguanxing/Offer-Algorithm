package leetcode.problems;

import java.util.*;

public class Test0146_LRU缓存 {

    public static void main(String[] args) {

    }

    static class LRUCache {
        private MyMap myMap;

        public LRUCache(int capacity) {
            this.myMap = new MyMap(capacity);
        }

        public int get(int key) {
            return myMap.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            myMap.put(key, value);
        }

        class MyMap extends LinkedHashMap<Integer, Integer> {
            private int limit;

            public MyMap(int limit) {
                super(limit, 0.75F, true);
                this.limit = limit;
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > limit;
            }
        }
    }

    static class LRUCacheMap {
        int capacity;
        LinkedHashMap<Integer, Integer> linkedHashMap;

        public LRUCacheMap(int capacity) {
            this.capacity = capacity;
            this.linkedHashMap = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!linkedHashMap.containsKey(key)) {
                return -1;
            } else {
                int val = linkedHashMap.get(key);
                linkedHashMap.remove(key);
                linkedHashMap.put(key, val);
                return val;
            }
        }

        public void put(int key, int value) {
            if (!linkedHashMap.containsKey(key)) {
                if (linkedHashMap.size() >= capacity) {
                    linkedHashMap.remove(linkedHashMap.keySet().stream().findFirst().orElse(null));
                }
            } else {
                linkedHashMap.remove(key);
            }
            linkedHashMap.put(key, value);
        }
    }

}
