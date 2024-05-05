package leetcode.contest.week396;

import java.util.*;

public class Test100275_K周期字符串需要的最少操作次数 {

    public static void main(String[] args) {
        // word = "leetcodeleet", k = 4
        System.out.println(new Solution().minimumOperationsToMakeKPeriodic("leetcodeleet", 4));
        // word = "leetcoleet", k = 2
        System.out.println(new Solution().minimumOperationsToMakeKPeriodic("leetcoleet", 2));
    }

    static class Solution {
        public int minimumOperationsToMakeKPeriodic(String word, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i += k) {
                String key = word.substring(i, i + k);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int max = map.values().stream().max(Comparator.comparingInt(Integer::intValue)).get();
            return word.length() / k - max;
        }
    }

}
