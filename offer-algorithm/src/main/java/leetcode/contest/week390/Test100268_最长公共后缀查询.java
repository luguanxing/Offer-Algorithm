package leetcode.contest.week390;

import java.util.*;

public class Test100268_最长公共后缀查询 {

    public static void main(String[] args) {
        // wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"]
        System.out.println(Arrays.toString(new Solution().stringIndices(new String[]{"abcd", "bcd", "xbcd"}, new String[]{"cd", "bcd", "xyz"})));
        // wordsContainer = ["abcdefgh","poiuygh","ghghgh"], wordsQuery = ["gh","acbfgh","acbfegh"]
        System.out.println(Arrays.toString(new Solution().stringIndices(new String[]{"abcdefgh", "poiuygh", "ghghgh"}, new String[]{"gh", "acbfgh", "acbfegh"})));
        System.out.println(Arrays.toString(new Solution().stringIndices(new String[]{"abcde", "abcde"}, new String[]{"abcde", "bcde", "cde", "de", "e"})));
        System.out.println(Arrays.toString(new Solution().stringIndices(new String[]{"uggkuk","uakagg","kfugafu"}, new String[]{"ukugka","gkfagug","kfukfkff","faaaaguau"})));
    }

    static class Solution {
        String[] wordsContainer;
        String[] wordsQuery;
        Map<String, Integer> wordIndexMap = new HashMap<>();
        Set<Integer> fullSet = new HashSet<>();

        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            this.wordsContainer = wordsContainer;
            this.wordsQuery = wordsQuery;
            for (int i = 0; i < wordsContainer.length; i++) {
                if (wordIndexMap.containsKey(wordsContainer[i])) {
                    continue;
                }
                wordIndexMap.put(wordsContainer[i], i);
                fullSet.add(i);
            }

            // 构建后缀树
            SuffixTree suffixTree = new SuffixTree();
            for (int i = 0; i < wordsContainer.length; i++) {
                suffixTree.addString(wordsContainer[i], i);
            }

            // 结果数组
            int[] ans = new int[wordsQuery.length];

            for (int i = 0; i < wordsQuery.length; i++) {
                String query = wordsQuery[i];
                // 查找与query具有最长公共后缀的字符串的索引
                ans[i] = suffixTree.query(query);
            }

            return ans;
        }


        class SuffixTree {
            public void addString(String s, int index) {
                String revStr = new StringBuilder(s).reverse().toString();
                insert(revStr, index);
            }


            public int query(String query) {
                String revStr = new StringBuilder(query).reverse().toString();
                Set<Integer> indexSet = new HashSet<>();
                for (int i = 1; i <= revStr.length(); i++) {
                    Node node = startsWith(revStr.substring(0, i));
                    if (node != null) {
                        indexSet = node.indexSet;
                    } else {
                        break;
                    }
                }
                List<String> list = new ArrayList<>();
                if (indexSet.isEmpty()) {
                    indexSet = fullSet;
                }
                for (int i : indexSet) {
                    list.add(wordsContainer[i]);
                }
                // 找出长度最短的，长度相同找最先出现的
                list.sort((o1, o2) -> {
                    if (o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    }
                    return Integer.compare(wordIndexMap.get(o1), wordIndexMap.get(o2));
                });
                return wordIndexMap.get(list.get(0));
            }


            class Node {
                boolean isEnd;
                TreeSet<Integer> indexSet;
                Map<Character, Node> nodeMap;

                public Node() {
                    this.isEnd = false;
                    this.nodeMap = new HashMap<>();
                    this.indexSet = new TreeSet<>();
                }
            }

            Node root;


            public SuffixTree() {
                root = new Node();
            }

            public void insert(String word, int index) {
                Node current = root;
                for (char c : word.toCharArray()) {
                    if (current.nodeMap.containsKey(c)) {
                        current = current.nodeMap.get(c);
                    } else {
                        Node node = new Node();
                        current.nodeMap.put(c, node);
                        current = node;
                    }
                    current.indexSet.add(index);
                }
                current.isEnd = true;
            }


            public Node startsWith(String prefix) {
                Node current = root;
                for (char c : prefix.toCharArray()) {
                    if (current.nodeMap.containsKey(c)) {
                        current = current.nodeMap.get(c);
                    } else {
                        return null;
                    }
                }
                return current;
            }
        }


    }

    class Solution_暴力 {
        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            int[] ans = new int[wordsQuery.length];
            for (int i = 0; i < wordsQuery.length; i++) {
                String query = wordsQuery[i];
                int maxSuffixLength = -1;
                int ansIndex = -1;
                int shortestLength = Integer.MAX_VALUE;
                for (int j = 0; j < wordsContainer.length; j++) {
                    String word = wordsContainer[j];
                    int commonSuffixLength = getCommonSuffixLength(word, query);
                    if (commonSuffixLength > maxSuffixLength ||
                            (commonSuffixLength == maxSuffixLength && word.length() < shortestLength)) {
                        maxSuffixLength = commonSuffixLength;
                        ansIndex = j;
                        shortestLength = word.length();
                    }
                }
                ans[i] = ansIndex;
            }
            return ans;
        }

        private int getCommonSuffixLength(String word, String query) {
            int i = word.length() - 1;
            int j = query.length() - 1;
            int length = 0;
            while (i >= 0 && j >= 0 && word.charAt(i) == query.charAt(j)) {
                length++;
                i--;
                j--;
            }
            return length;
        }
    }


}
