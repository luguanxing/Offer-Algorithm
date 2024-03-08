package leetcode.problems;

import java.util.Arrays;

public class Test2575_找出字符串的可整除数组 {

    public static void main(String[] args) {
        // word = "998244353", m = 3
        System.out.println(Arrays.toString(new Solution().divisibilityArray("998244353", 3)));
        // word = "1010", m = 10
        System.out.println(Arrays.toString(new Solution().divisibilityArray("1010", 10)));
    }

    static class Solution {
        public int[] divisibilityArray(String word, int m) {
            int len = word.length();
            int[] res = new int[len];
            long cur = 0;
            for (int i = 0; i < len; i++) {
                cur = (cur * 10 + word.charAt(i) - '0') % m;
                res[i] = cur == 0 ? 1 : 0;
            }
            return res;
        }
    }

}
