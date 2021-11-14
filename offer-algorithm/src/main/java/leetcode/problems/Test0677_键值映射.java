package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0677_键值映射 {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));
    }

    static class MapSum {
        TrieNode root;
        Map<String, Integer> map = new HashMap();

        public MapSum() {
            this.root = new TrieNode(0);
        }

        public void insert(String key, int val) {
            if (map.containsKey(key)) {
                // 修正已有结果
                int oldVal = map.get(key);
                realInsert(key, -1 * oldVal);
            }
            realInsert(key, val);
            map.put(key, val);
        }

        public void realInsert(String key, int val) {
            TrieNode current = root;
            for (char c : key.toCharArray()) {
                if (current.children.containsKey(c)) {
                    current.children.get(c).addCnt(val);
                    current = current.children.get(c);
                } else {
                    TrieNode node = new TrieNode(val);
                    current.children.put(c, node);
                    current = node;
                }
            }
        }

        public int sum(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (current.children.containsKey(c)) {
                    current = current.children.get(c);
                } else {
                    TrieNode node = new TrieNode(0);
                    current.children.put(c, node);
                    current = node;
                }
            }
            return current.cnt;
        }


        class TrieNode {
            int cnt = 0;
            Map<Character, TrieNode> children;

            public TrieNode(int cnt) {
                this.children = new HashMap<>();
                this.cnt = cnt;
            }

            public void addCnt(int cnt) {
                this.cnt += cnt;
            }
        }
    }

}
