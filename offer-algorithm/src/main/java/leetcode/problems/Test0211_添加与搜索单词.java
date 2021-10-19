package leetcode.problems;

import java.util.*;

public class Test0211_添加与搜索单词 {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    static class WordDictionary {
        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
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
            List<Node> currentNodes = new ArrayList<>();
            currentNodes.add(root);
            for (char c : word.toCharArray()) {
                List<Node> nextNodes = new ArrayList<>();
                if (c != '.') {
                    // 不是.需要精确匹配下个节点
                    for (Node currentNode : currentNodes) {
                        if (currentNode.nodeMap.containsKey(c)) {
                            nextNodes.add(currentNode.nodeMap.get(c));
                        }
                    }
                } else {
                    // 遇到.所有节点都符合条件
                    for (Node node : currentNodes) {
                        nextNodes.addAll(node.nodeMap.values());
                    }
                }
                currentNodes = nextNodes;
            }
            boolean res = false;
            for (Node currentNode : currentNodes) {
                res = res || currentNode.isEnd;
            }
            return res;
        }

        class Node {
            boolean isEnd;
            Map<Character, Node> nodeMap;

            public Node() {
                this.isEnd = false;
                this.nodeMap = new HashMap<>();
            }
        }
    }

}
