package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0127_单词接龙 {

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength(
                "hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")
        ));
        System.out.println(new Solution().ladderLength(
                "hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")
        ));
        System.out.println(new Solution().ladderLength(
                "hit", "dog", Arrays.asList("hit", "dog")
        ));
    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, List<String>> reachMap = new HashMap<>();
            Set<String> set = new HashSet<>(wordList);
            set.add(beginWord);
            List<String> list = new ArrayList<>(set);
            // 构建可达地图
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    String word1 = list.get(i);
                    String word2 = list.get(j);
                    int diff = 0;
                    for (int k = 0; k < word1.length(); k++) {
                        if (word1.charAt(k) != word2.charAt(k)) {
                            diff++;
                        }
                    }
                    if (diff == 1) {
                        List<String> list1 = reachMap.getOrDefault(word1, new ArrayList<>());
                        List<String> list2 = reachMap.getOrDefault(word2, new ArrayList<>());
                        list1.add(word2);
                        list2.add(word1);
                        reachMap.put(word1, list1);
                        reachMap.put(word2, list2);
                    }
                }
            }
            // BFS遍历
            Set<String> visitedWord = new HashSet<>();
            Queue<String> wordQueue = new ArrayDeque<>();
            Queue<Integer> cntQueue = new ArrayDeque<>();
            wordQueue.add(beginWord);
            cntQueue.add(1);
            while (!wordQueue.isEmpty()) {
                String currentWord = wordQueue.poll();
                Integer currentCnt = cntQueue.poll();
                visitedWord.add(currentWord);
                List<String> reachableList = reachMap.getOrDefault(currentWord, new ArrayList<>());
                for (String nextWord : reachableList) {
                    if (nextWord.equals(endWord)) {
                        return currentCnt + 1;
                    }
                    if (!visitedWord.contains(nextWord)) {
                        wordQueue.add(nextWord);
                        cntQueue.add(currentCnt + 1);
                    }
                }
            }
            return 0;
        }
    }

}
