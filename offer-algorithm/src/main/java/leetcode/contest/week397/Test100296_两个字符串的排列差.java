package leetcode.contest.week397;

public class Test100296_两个字符串的排列差 {

    public static void main(String[] args) {
        System.out.println(new Solution().findPermutationDifference("abc", "bac"));
        System.out.println(new Solution().findPermutationDifference("abcde", "edbac"));
    }

    static class Solution {
        public int findPermutationDifference(String s, String t) {
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map1[c - 'a'] = i;
            }
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map2[c - 'a'] = i;
            }
            int res = 0;
            for (int i = 0; i < 26; i++) {
                res += Math.abs(map1[i] - map2[i]);
            }
            return res;
        }
    }

}
