package leetcode.problems;

import java.util.*;

public class Test3137_K周期字符串需要的最少操作次数 {

    public static void main(String[] args) {
        // word = "leetcodeleet", k = 4
        System.out.println(new Solution().minimumOperationsToMakeKPeriodic("leetcodeleet", 4));
        // word = "leetcoleet", k = 2
        System.out.println(new Solution().minimumOperationsToMakeKPeriodic("leetcoleet", 2));
    }

    static class Solution {
        public int minimumOperationsToMakeKPeriodic(String word, int k) {
            // 统计每个节的词频
            Map<String, Integer> map = new HashMap<>();
            int len = word.length();
            for (int i = 0; i < len / k; i++) {
                String subStr = word.substring(i * k, (i + 1) * k);
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
            // 找频率最大的来替换
            int maxFreq = map.values().stream().max(Integer::compareTo).get();
            return len / k - maxFreq;
        }
    }

}
