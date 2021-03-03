package leetcode.problems;

import java.util.Arrays;

public class Test0338_比特位计数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(2)));
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }

    static class Solution {
        public int[] countBits(int num) {
            int[] bit = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                // 动态规划，i的二进制1个数等于i/2二进制1的个数加个位
                bit[i] = bit[i >> 1] + (i & 1);
            }
            return bit;
        }
    }

}
