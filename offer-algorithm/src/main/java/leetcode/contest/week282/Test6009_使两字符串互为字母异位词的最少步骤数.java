package leetcode.contest.week282;

public class Test6009_使两字符串互为字母异位词的最少步骤数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSteps("leetcode", "coats"));
        System.out.println(new Solution().minSteps("night", "thing"));
    }

    static class Solution {
        public int minSteps(String s, String t) {
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (char c : s.toCharArray()) {
                map1[c - 'a']++;
            }
            for (char c : t.toCharArray()) {
                map2[c - 'a']++;
            }
            int res = 0;
            for (int i = 0; i < 26; i++) {
                res += Math.abs(map1[i] - map2[i]);
            }
            return res;
        }
    }

}
