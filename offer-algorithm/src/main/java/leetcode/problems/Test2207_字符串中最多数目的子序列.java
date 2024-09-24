package leetcode.problems;

public class Test2207_字符串中最多数目的子序列 {

    public static void main(String[] args) {
        // text = "abdcdbc", pattern = "ac"
        System.out.println(new Solution().maximumSubsequenceCount("abdcdbc", "ac"));
        // text = "aabb", pattern = "ab"
        System.out.println(new Solution().maximumSubsequenceCount("aabb", "ab"));
        System.out.println(new Solution().maximumSubsequenceCount("iekbksdsmuuzwxbpmcngsfkjvpzuknqguzvzik", "mp"));
        System.out.println(new Solution().maximumSubsequenceCount("mpmp", "mp"));
        System.out.println(new Solution().maximumSubsequenceCount("fwymvreuftzgrcrxczjacqovduqaiig", "yy"));
    }

    static class Solution {
        public long maximumSubsequenceCount(String text, String pattern) {
            // 直接贪心，要么pattern[0]放最前，要么pattern[1]放最后
            String text1 = pattern.charAt(0) + text;
            String text2 = text + pattern.charAt(1);
            // 计算最佳结果
            long max = Math.max(getPatternCount(text1, pattern), getPatternCount(text2, pattern));
            return max;
        }

        private long getPatternCount(String text, String pattern) {
            long res = 0;
            int cnt1 = 0;
            for (char c : text.toCharArray()) {
                if (c == pattern.charAt(1)) {
                    res += cnt1;
                }
                if (c == pattern.charAt(0)) {
                    cnt1++;
                }
            }
            return res;
        }
    }

}
