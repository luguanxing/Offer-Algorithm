package leetcode.contest.week416;

import java.util.*;

public class Test100428_统计重新排列后包含另一个字符串的子字符串数目I {

    public static void main(String[] args) {
        System.out.println(new Solution().validSubstringCount("bcca", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "aaabc"));
        System.out.println(new Solution().validSubstringCount("bbbbbbbbbbbbbbb", "bb"));
    }

    static class Solution {
        public long validSubstringCount(String word1, String word2) {
            int len1 = word1.length();
            // 记下word2特征和所差字符个数
            int[] target = new int[26];
            int diffCharCnt = 0;
            for (char c : word2.toCharArray()) {
                int idx = c - 'a';
                target[idx]++;
                if (target[idx] == 1) {
                    diffCharCnt += target[idx];
                } else {
                    diffCharCnt++;
                }
            }
            // 枚举左边，维持右边窗口，直到覆盖所需的字符或达到字符串末尾
            int[] window = new int[26];
            int l = 0, r = 0;
            long res = 0;
            int currentDiffCharCnt = diffCharCnt;
            while (l < len1) {
                // 扩大窗口右边直到满足特征
                while (r < len1 && currentDiffCharCnt > 0) {
                    char c = word1.charAt(r++);
                    int idx = c - 'a';
                    if (target[idx] > 0) {
                        window[idx]++;
                        if (window[idx] <= target[idx]) {
                            currentDiffCharCnt--;
                        }
                    }
                }
                // 此时r右侧均满足条件
                if (currentDiffCharCnt == 0) {
                    res += len1 - r + 1;
                }
                // 移动窗口左边
                char c = word1.charAt(l++);
                int idx = c - 'a';
                if (target[idx] > 0) {
                    if (window[idx] <= target[idx]) {
                        currentDiffCharCnt++;
                    }
                    window[idx]--;
                }
            }
            return res;
        }
    }

}
