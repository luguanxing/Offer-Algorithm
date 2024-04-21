package leetcode.contest.week394;

import java.util.Arrays;

public class Test100291_统计特殊字母的数量II {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSpecialChars("aaAbcBC"));
        System.out.println(new Solution().numberOfSpecialChars("abc"));
        System.out.println(new Solution().numberOfSpecialChars("AbBCab"));
    }

    static class Solution {
        public int numberOfSpecialChars(String word) {
            int[] lowerMaxIndex = new int[26];
            int[] upperMinIndex = new int[26];
            Arrays.fill(lowerMaxIndex, -1);
            Arrays.fill(upperMinIndex, Integer.MAX_VALUE);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLowerCase(c)) {
                    lowerMaxIndex[c - 'a'] = Math.max(lowerMaxIndex[c - 'a'], i);
                } else {
                    upperMinIndex[c - 'A'] = Math.min(upperMinIndex[c - 'A'], i);
                }
            }
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                if (lowerMaxIndex[i] != -1 && upperMinIndex[i] != Integer.MAX_VALUE && lowerMaxIndex[i] < upperMinIndex[i]) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
