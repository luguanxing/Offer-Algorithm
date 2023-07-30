package leetcode.contest.week356;

import java.util.*;

public class Test6918_包含三个字符串的最短字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumString("abc", "bca", "aaa"));
        System.out.println(new Solution().minimumString("ab", "ba", "aba"));
    }

    static class Solution {
        public String minimumString(String a, String b, String c) {
            // 找出所有可能的组合
            String[] strs = {
                    getCommonString(getCommonString(a, b), c),
                    getCommonString(getCommonString(a, c), b),
                    getCommonString(getCommonString(b, a), c),
                    getCommonString(getCommonString(b, c), a),
                    getCommonString(getCommonString(c, a), b),
                    getCommonString(getCommonString(c, b), a)
            };
            // 选择最短的，并且在字典顺序上最小的那个
            Arrays.sort(strs, (s1, s2) -> {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            });
            return strs[0];
        }

        // 方法来合并两个字符串，并保留最短且字典序最小的字符串
        private String getCommonString(String a, String b) {
            if (a.contains(b)) return a;
            if (b.contains(a)) return b;
            for (int i = b.length(); i > 0; i--) {
                if (a.endsWith(b.substring(0, i))) {
                    return a + b.substring(i);
                }
            }
            return a + b;
        }
    }

}
