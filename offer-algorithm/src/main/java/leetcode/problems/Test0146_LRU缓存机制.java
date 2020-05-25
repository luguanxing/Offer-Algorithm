package leetcode.problems;

import java.util.LinkedHashMap;

public class Test0146_LRU缓存机制 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    static class LRUCache {
        private Integer capacity;
        private LinkedHashMap<Integer, Integer> linkedHashMap;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.linkedHashMap = new LinkedHashMap<>();
        }

        public int get(int key) {
            // 获取时更新顺序
            if (linkedHashMap.containsKey(key)) {
                Integer value = linkedHashMap.get(key);
                linkedHashMap.remove(key);
                linkedHashMap.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (linkedHashMap.containsKey(key)) {
                // 包含则更新顺序
                linkedHashMap.remove(key);
            } else {
                // 不包含则去掉最少使用
                if (linkedHashMap.size() >= capacity) {
                    Integer firstKey = linkedHashMap.keySet().stream().findFirst().orElse(null);
                    linkedHashMap.remove(firstKey);
                }
            }
            linkedHashMap.put(key, value);
        }
    }

}
