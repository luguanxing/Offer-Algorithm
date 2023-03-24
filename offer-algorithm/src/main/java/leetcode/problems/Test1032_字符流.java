package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1032_字符流 {

    public static void main(String[] args) {
        // StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        // System.out.println(streamChecker.query('a')); // 返回 False
        // System.out.println(streamChecker.query('b')); // 返回 False
        // System.out.println(streamChecker.query('c')); // 返回 False
        // System.out.println(streamChecker.query('d')); // 返回 True ，因为 'cd' 在 words 中
        // System.out.println(streamChecker.query('e')); // 返回 False
        // System.out.println(streamChecker.query('f')); // 返回 True ，因为 'f' 在 words 中
        // System.out.println(streamChecker.query('g')); // 返回 False
        // System.out.println(streamChecker.query('h')); // 返回 False
        // System.out.println(streamChecker.query('i')); // 返回 False
        // System.out.println(streamChecker.query('j')); // 返回 False
        // System.out.println(streamChecker.query('k')); // 返回 False
        // System.out.println(streamChecker.query('l')); // 返回 True ，因为 'kl' 在 words 中
        StreamChecker streamChecker = new StreamChecker(new String[]{"abaa", "abaab", "aabbb", "bab", "ab"});
        System.out.println(streamChecker.query('a')); // 返回 False
        System.out.println(streamChecker.query('a')); // 返回 False
        System.out.println(streamChecker.query('b')); // 返回 False
        System.out.println(streamChecker.query('b')); // 返回 False
        System.out.println(streamChecker.query('b')); // 返回 True
    }

    static class StreamChecker {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        int maxLen = 0;

        public StreamChecker(String[] words) {
            for (String word : words) {
                set.add(word);
                maxLen = Math.max(maxLen, words.length);
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            // 换个维度，从已有的set中判断
            for (String word : set) {
                int len = word.length();
                if (len > sb.length()) {
                    continue;
                }
                if (sb.substring(sb.length()-len).equals(word)) {
                    return true;
                }
            }
            return false;
        }
    }


    static class StreamChecker_前缀树 {
        Trie trie = new Trie();
        int maxLen = 0;
        StringBuilder sb = new StringBuilder();

        public StreamChecker_前缀树(String[] words) {
            for (String word : words) {
                trie.insert(new StringBuilder(word).reverse().toString());
                maxLen = Math.max(maxLen, words.length);
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            for (int i = 1; i <= maxLen && sb.length() - i >= 0; i++) {
                String word = sb.substring(sb.length() - i);
                if (trie.search(new StringBuilder(word).reverse().toString())) {
                    return true;
                }
            }
            return false;
        }


        class Trie {
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
        }
    }


}
