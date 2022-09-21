package leetcode.problems;

import java.util.*;

public class Test0854_相似度为K的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().kSimilarity("ab", "ba"));
        System.out.println(new Solution().kSimilarity("abc", "bca"));
        System.out.println(new Solution().kSimilarity("abcd", "badc"));
        System.out.println(new Solution().kSimilarity("abcd", "bacd"));
    }

    static class Solution {
        public int kSimilarity(String s1, String s2) {
            Queue<String> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            queue.add(s1);
            int step = 0;
            while (!queue.isEmpty()) {
                List<String> currents = new ArrayList<>(queue);
                queue.clear();
                for (String current : currents) {
                    if (current.equals(s2)) {
                        return step;
                    }
                    List<String> nexts = tryNextSwap(current, s2);
                    for (String next : nexts) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private List<String> tryNextSwap(String current, String target) {
            List<String> nexts = new ArrayList<>();
            char[] chars1 = current.toCharArray();
            char[] chars2 = target.toCharArray();
            int idx = 0;
            while (idx < current.length() && chars1[idx] == chars2[idx]) {
                idx++;
            }
            // 需要找到和chars2[idx]相等的字符串
            for (int i = 0; i < current.length(); i++) {
                if (i == idx) {
                    continue;
                }
                if (chars1[i] != chars2[i] && chars1[i] == chars2[idx]) {
                    // 交换chars1[idx]和chars1[i]
                    char[] nextChars = chars1.clone();
                    nextChars[idx] = chars1[i];
                    nextChars[i] = chars1[idx];
                    nexts.add(new String(nextChars));
                }
            }
            return nexts;
        }
    }

}
