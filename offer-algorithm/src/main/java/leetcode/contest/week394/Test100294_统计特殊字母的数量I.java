package leetcode.contest.week394;

public class Test100294_统计特殊字母的数量I {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSpecialChars("aaAbcBC"));
        System.out.println(new Solution().numberOfSpecialChars("abc"));
        System.out.println(new Solution().numberOfSpecialChars("abBCab"));
    }

    static class Solution {
        public int numberOfSpecialChars(String word) {
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (char c : word.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    map1[c - 'A']++;
                } else {
                    map2[c - 'a']++;
                }
            }
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                if (map1[i] > 0 && map2[i] > 0) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
