package leetcode.problems;

import java.util.Arrays;
import java.util.TreeSet;

public class Test0821_字符的最短距离 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(new Solution().shortestToChar("aaab", 'b')));
    }

    static class Solution {
        public int[] shortestToChar(String s, char c) {
            int[] res = new int[s.length()];
            Arrays.fill(res, Integer.MAX_VALUE);
            // 先从前往后扫
            int lastPos = Integer.MIN_VALUE / 2;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    lastPos = i;
                }
                res[i] = Math.min(res[i], Math.abs(i - lastPos));
            }
            // 再从后往前扫
            lastPos = Integer.MAX_VALUE / 2;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == c) {
                    lastPos = i;
                }
                res[i] = Math.min(res[i], Math.abs(i - lastPos));
            }
            return res;
        }
    }

    static class Solution_TreeSet {
        public int[] shortestToChar(String s, char c) {
            int[] res = new int[s.length()];
            TreeSet<Integer> set = new TreeSet<>();
            set.add(Integer.MIN_VALUE / 2);
            set.add(Integer.MAX_VALUE / 2);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    set.add(i);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(i)) {
                    res[i] = 0;
                    continue;
                }
                int low = Math.abs(i - set.lower(i));
                int high = Math.abs(i - set.higher(i));
                res[i] = Math.min(low, high);
            }
            return res;
        }
    }

}
