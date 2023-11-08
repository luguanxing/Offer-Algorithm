package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test2609_最长平衡子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheLongestBalancedSubstring("01000111"));
        System.out.println(new Solution().findTheLongestBalancedSubstring("00111"));
        System.out.println(new Solution().findTheLongestBalancedSubstring("111"));
        System.out.println(new Solution().findTheLongestBalancedSubstring("101"));
        System.out.println(new Solution().findTheLongestBalancedSubstring("00101"));
        System.out.println(new Solution().findTheLongestBalancedSubstring("001011"));
    }

    static class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            int max = 0;
            int cnt0 = 0;
            int cnt1 = 0;
            boolean lastIs0 = false;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    if (!lastIs0) {
                        cnt0 = 0;
                    }
                    cnt0++;
                    cnt1 = 0;
                    lastIs0 = true;
                } else {
                    cnt1++;
                    max = Math.max(max, Math.min(cnt0, cnt1) * 2);
                    lastIs0 = false;
                }
            }
            return max;
        }
    }

    static class Solution2 {
        public int findTheLongestBalancedSubstring(String s) {
            List<int[]> list = new ArrayList<>();
            for (char c : s.toCharArray()) {
                if (list.isEmpty()) {
                    list.add(new int[]{c - '0', 1});
                } else {
                    int[] last = list.get(list.size() - 1);
                    if (last[0] == (c - '0')) {
                        last[1]++;
                    } else {
                        list.add(new int[]{(c - '0'), 1});
                    }
                }
            }
            int max = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)[0] == 1) {
                    max = Math.max(max, Math.min(list.get(i - 1)[1], list.get(i)[1]) * 2);
                }
            }
            return max;
        }
    }

}
