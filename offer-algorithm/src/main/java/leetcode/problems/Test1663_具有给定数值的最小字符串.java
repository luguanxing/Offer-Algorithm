package leetcode.problems;

import java.util.Arrays;

public class Test1663_具有给定数值的最小字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().getSmallestString(3, 27));
        System.out.println(new Solution().getSmallestString(5, 73));
    }

    static class Solution {
        public String getSmallestString(int n, int k) {
            char[] chars = new char[n];
            Arrays.fill(chars, 'a');
            k -= n;
            int idx = n - 1;
            while (k > 0) {
                int diff = Math.min(k, 25);
                chars[idx--] += diff;
                k -= diff;
            }
            return new String(chars);
        }
    }

}
