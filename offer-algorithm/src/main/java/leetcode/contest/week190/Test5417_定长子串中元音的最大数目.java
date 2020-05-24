package leetcode.contest.week190;

public class Test5417_定长子串中元音的最大数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("abciiidef", 3));
        System.out.println(new Solution().maxVowels("aeiou", 2));
        System.out.println(new Solution().maxVowels("leetcode", 3));
        System.out.println(new Solution().maxVowels("rhythms", 4));
        System.out.println(new Solution().maxVowels("tryhard", 4));
    }

    static class Solution {
        public int maxVowels(String s, int k) {
            // 构造元音数组
            boolean[] flags = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c) {
                    flags[i] = true;
                }
            }
            // 找区间k内为true的最大值
            int sum = 0;
            for (int i = 0; i < k; i++) {
                if (flags[i]) {
                    sum++;
                }
            }
            int max = sum;
            for (int i = k; i < flags.length; i++) {
                if (flags[i]) {
                    sum++;
                }
                if (flags[i - k]) {
                    sum--;
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }

}
