package leetcode.interview;

import java.util.*;

public class Test16_25_LRU缓存 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }

    static class LRUCache {
        LinkedHashMap<Integer, Integer> map;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            System.out.println("get [" + key +"] ->" + map);
            return val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
                return;
            }
            if (map.size() >= capacity) {
                map.remove(map.keySet().stream().findFirst().get());
            }
            map.put(key, value);
            System.out.println("put [" + key + "," + value +"] ->" + map);
        }
    }


}
