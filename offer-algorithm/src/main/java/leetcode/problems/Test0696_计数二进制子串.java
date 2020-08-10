package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0696_计数二进制子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().countBinarySubstrings("00110011"));
        System.out.println(new Solution().countBinarySubstrings("10101"));
        System.out.println(new Solution().countBinarySubstrings("000111000"));
        System.out.println(new Solution().countBinarySubstrings("00100"));
        System.out.println(new Solution().countBinarySubstrings("00110"));
    }

    static class Solution {
        public int countBinarySubstrings(String s) {
            // 先将连续的0和连续的1压缩成数字
            List<Integer> list = new ArrayList<>();
            char currentChar = s.charAt(0);
            int currentCnt = 1;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == currentChar) {
                    currentCnt++;
                } else {
                    list.add(currentCnt);
                    currentCnt = 1;
                    currentChar = c;
                }
            }
            list.add(currentCnt);
            // 求两两数字之间的最小值
            int res = 0;
            for (int i = 1; i < list.size(); i++) {
                res += Math.min(list.get(i), list.get(i - 1));
            }
            return res;
        }
    }

    static class Solution_记忆化 {
        public int countBinarySubstrings(String s) {
            int cnt0 = s.charAt(0) == '0' ? 1 : 0;
            int cnt1 = s.charAt(0) == '0' ? 0 : 1;
            int res = 0;
            char last = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (last != c) {
                    last = c;
                    if (c == '0') {
                        cnt0 = 0;
                    } else {
                        cnt1 = 0;
                    }

                }
                if (c == '0') {
                    cnt0++;
                    if (cnt0 <= cnt1) {
                        res++;
                    }
                } else {
                    cnt1++;
                    if (cnt1 <= cnt0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
