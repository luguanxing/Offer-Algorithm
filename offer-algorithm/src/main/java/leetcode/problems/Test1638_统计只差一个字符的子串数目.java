package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test1638_统计只差一个字符的子串数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aba", "baba"));
        System.out.println(new Solution().countSubstrings("ab", "bb"));
        System.out.println(new Solution().countSubstrings("a", "a"));
        System.out.println(new Solution().countSubstrings("abe", "bbc"));
        System.out.println(new Solution().countSubstrings("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "abababababababababababababababababababababababababababababababababababababababababababababababababab"));
    }

    static class Solution {
        public int countSubstrings(String s, String t) {
            Set<Character> tSet = new HashSet<>();
            for (char c : t.toCharArray()) {
                tSet.add(c);
            }
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String subStr = s.substring(i, j);
                    for (int k = 0; k < subStr.length(); k++) {
                        for (char c : tSet) {
                            char[] subStrChars = subStr.toCharArray();
                            if (c == subStrChars[k]) {
                                continue;
                            }
                            subStrChars[k] = c;
                            // 从t不断的找
                            String newStr = new String(subStrChars);
                            int idx = 0;
                            while (t.indexOf(newStr, idx) >= 0) {
                                idx = t.indexOf(newStr, idx) + 1;
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }

}
