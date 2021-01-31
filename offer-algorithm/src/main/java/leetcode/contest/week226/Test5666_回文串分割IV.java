package leetcode.contest.week226;

import java.util.ArrayList;
import java.util.List;

public class Test5666_回文串分割IV {

    public static void main(String[] args) {
        System.out.println(new Solution().checkPartitioning("abcbdd"));
        System.out.println(new Solution().checkPartitioning("bcbddxy"));
        System.out.println(new Solution().checkPartitioning("abxbaccded"));
        System.out.println(new Solution().checkPartitioning("juchzcedhfesefhdeczhcujzzvbmoeombv"));
    }

    static class Solution {
        public boolean checkPartitioning(String s) {
            int len = s.length();
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (isHui(s.substring(0, i + 1))) {
                    left.add(i);
                }
                if (isHui(s.substring(len - 1 - i, len))) {
                    right.add(len - 1 - i);
                }
            }
            for (int leftIndex : left) {
                for (int rightIndex : right) {
                    String mid = s.substring(leftIndex + 1, rightIndex);
                    if (isHui(mid)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isHui(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

}
