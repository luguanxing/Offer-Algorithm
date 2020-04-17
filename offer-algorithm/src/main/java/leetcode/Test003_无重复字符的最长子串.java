package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Test003_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            // 滑动窗口维护不重复子串
            int left = 0;
            int right = 0;
            int max = 0;
            Set<Character> set = new HashSet<>();
            while (left <= right && left < s.length() && right < s.length()) {
                char c = s.charAt(right);
                if (!set.contains(c)) {
                    // 集合没有字符重复，右指针向后推进
                    set.add(c);
                    right++;
                } else {
                    // 集合右重复，不断从集合左边弹出直到不重复位置
                    set.remove(s.charAt(left));
                    left++;
                }
                max = Math.max(right - left, max);
            }
            return max;
        }
    }

}
