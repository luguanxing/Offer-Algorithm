package leetcode.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现字典树
 */
public class TrieTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    static class Trie {
        class Node {
            boolean isEnd;
            Map<Character, Node> nodeMap;

            public Node() {
                this.isEnd = false;
                this.nodeMap = new HashMap<>();
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node current = root;
            for (char c : word.toCharArray()) {
                if (current.nodeMap.containsKey(c)) {
                    current = current.nodeMap.get(c);
                } else {
                    Node node = new Node();
                    current.nodeMap.put(c, node);
                    current = node;
                }
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            Node current = root;
            for (char c : word.toCharArray()) {
                if (current.nodeMap.containsKey(c)) {
                    current = current.nodeMap.get(c);
                } else {
                    return false;
                }
            }
            return current.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node current = root;
            for (char c : prefix.toCharArray()) {
                if (current.nodeMap.containsKey(c)) {
                    current = current.nodeMap.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
