package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test1044_最长重复子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestDupSubstring("banana"));
        System.out.println(new Solution().longestDupSubstring("abcd"));
    }

    static class Solution {
        public String longestDupSubstring(String s) {
            for (int len = s.length(); len > 0; len--) {
                // 收集所有长度为len的子串
                Set<String> set = new HashSet<>();
                for (int index = 0; index + len <= s.length(); index++) {
                    String subStr = s.substring(index, index + len);
                    if (set.contains(subStr)) {
                        return subStr;
                    }
                    set.add(subStr);
                }
            }
            return "";
        }
    }

}
