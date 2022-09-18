package leetcode.contest.week311;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test183_字符串的前缀分数和 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumPrefixScores(new String[]{
                "abc", "ab", "bc", "b"
        })));
        System.out.println(Arrays.toString(new Solution().sumPrefixScores(new String[]{
                "abcd"
        })));
    }

    static class Solution {
        public int[] sumPrefixScores(String[] words) {
            Trie tree = new Trie();
            for (String word : words) {
                tree.insert(word);
            }
            int[] res = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                res[i] = tree.searchWord(word);
            }
            return res;
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node current = root;
            for (char c : word.toCharArray()) {
                if (current.nodeMap.containsKey(c)) {
                    current.nodeMap.get(c).cnt = current.nodeMap.get(c).cnt + 1;
                    current = current.nodeMap.get(c);
                } else {
                    Node node = new Node();
                    node.cnt = 1;
                    current.nodeMap.put(c, node);
                    current = node;
                }
            }
            current.isEnd = true;
        }

        public int searchWord(String word) {
            int sum = 0;
            Node current = root;
            for (char c : word.toCharArray()) {
                if (current.nodeMap.containsKey(c)) {
                    sum += current.nodeMap.get(c).cnt;
                    current = current.nodeMap.get(c);
                } else {
                    return 0;
                }
            }
            return sum;
        }

        class Node {
            boolean isEnd;
            int cnt = 0;
            Map<Character, Node> nodeMap;

            public Node() {
                this.isEnd = false;
                this.nodeMap = new HashMap<>();
            }
        }
    }


}
