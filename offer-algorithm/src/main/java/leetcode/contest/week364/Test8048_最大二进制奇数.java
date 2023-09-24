package leetcode.contest.week364;

import java.util.Arrays;

public class Test8048_最大二进制奇数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumOddBinaryNumber("010"));
        System.out.println(new Solution().maximumOddBinaryNumber("0101"));
    }

    static class Solution {
        public String maximumOddBinaryNumber(String s) {
            int len = s.length();
            int cnt1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    cnt1++;
                }
            }
            char[] chars = new char[len];
            Arrays.fill(chars, '0');
            chars[len - 1] = '1';
            for (int i = 1; i <= cnt1 - 1; i++) {
                chars[i - 1] = '1';
            }
            return new String(chars);
        }
    }

}
