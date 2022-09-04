package leetcode.contest.week309;

import java.util.Arrays;

public class Test6167_检查相同字母间的距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(new Solution().checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    static class Solution {
        public boolean checkDistances(String s, int[] distance) {
            int[] map = new int[26];
            int[] d = new int[26];
            Arrays.fill(map, -1);
            Arrays.fill(d, -1);
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (map[c] == -1) {
                    map[c] = i;
                } else {
                    d[c] = i - map[c] - 1;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (d[i] != -1 && d[i] != distance[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
