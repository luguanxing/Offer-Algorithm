package leetcode.contest.week327;

public class Test6284_使字符串总不同字符的数目相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().isItPossible("ac", "b"));
        System.out.println(new Solution().isItPossible("abcc", "aab"));
        System.out.println(new Solution().isItPossible("abcde", "fghij"));
    }

    static class Solution {
        public boolean isItPossible(String word1, String word2) {
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (char c : word1.toCharArray()) {
                map1[c - 'a']++;
            }
            for (char c : word2.toCharArray()) {
                map2[c - 'a']++;
            }
            for (int c1 = 'a'; c1 <= 'z'; c1++) {
                for (int c2 = 'a'; c2 <= 'z'; c2++) {
                    if (isOk(map1.clone(), c1, map2.clone(), c2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isOk(int[] map1, int c1, int[] map2, int c2) {
            int i1 = c1 - 'a';
            int i2 = c2 - 'a';
            if (map1[i1] <= 0 || map2[i2] <= 0) {
                return false;
            }
            map1[i1]--;
            map2[i1]++;
            map2[i2]--;
            map1[i2]++;
            int cnt1 = 0;
            int cnt2 = 0;
            for (int c = 'a'; c <= 'z'; c++) {
                if (map1[c - 'a'] > 0) {
                    cnt1++;
                }
                if (map2[c - 'a'] > 0) {
                    cnt2++;
                }
            }
            return cnt1 == cnt2;
        }
    }

}
