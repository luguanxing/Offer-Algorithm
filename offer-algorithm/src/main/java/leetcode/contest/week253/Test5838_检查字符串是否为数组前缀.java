package leetcode.contest.week253;

public class Test5838_检查字符串是否为数组前缀 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPrefixString(
                "iloveleetcode", new String[]{"i", "love", "leetcode", "apples"}
        ));
        System.out.println(new Solution().isPrefixString(
                "iloveleetcode", new String[]{"apples", "i", "love", "leetcode"}
        ));
    }

    static class Solution {
        public boolean isPrefixString(String s, String[] words) {
            for (String word : words) {
                if (s.isEmpty()) {
                    return true;
                }
                if (s.startsWith(word)) {
                    s = s.substring(word.length());
                } else {
                    return false;
                }
            }
            if (s.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

}
