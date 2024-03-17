package leetcode.contest.week389;

import java.util.*;

public class Test100255_成为K特殊字符串需要删除的最少字符数 {

    public static void main(String[] args) {
        // word = "aabcaba", k = 0
        System.out.println(new Solution().minimumDeletions("aabcaba", 0));
        // word = "dabdcbdcdcd", k = 2
        System.out.println(new Solution().minimumDeletions("dabdcbdcdcd", 2));
        // word = "aaabaaa", k = 2
        System.out.println(new Solution().minimumDeletions("aaabaaa", 2));
        System.out.println(new Solution().minimumDeletions("yzyyzzzyyzz", 0));
        System.out.println(new Solution().minimumDeletions("vnnppvvbbn", 0));
    }

    static class Solution {
        public int minimumDeletions(String word, int k) {
            // 统计每个字符的频率
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            // 按频率排序
            List<Integer> frequencies = new ArrayList<>(freqMap.values());
            Collections.sort(frequencies);

            // 枚举保留的最低频次
            int res = Integer.MAX_VALUE;
            for (int minFreq : frequencies) {
                // 保留频次在[minFreq, minFreq+k]的字符，其余删除
                int cnt = 0;
                for (int freq : frequencies) {
                    if (freq < minFreq) {
                        cnt += freq;
                    } else if (freq > minFreq + k) {
                        cnt += freq - minFreq - k;
                    }
                }
                res = Math.min(res, cnt);
            }
            return res;
        }
    }

}
