package leetcode.contest.week255;

import java.util.Arrays;

public class Test5850_找出数组的最大公约数 {

    public static void main(String[] args) {
        System.out.println(new Solution().findGCD(new int[]{2, 5, 6, 9, 10}));
        System.out.println(new Solution().findGCD(new int[]{7, 5, 6, 8, 3}));
        System.out.println(new Solution().findGCD(new int[]{3, 3}));
    }

    static class Solution {
        public int findGCD(int[] nums) {
            int max = Arrays.stream(nums).max().orElse(0);
            int min = Arrays.stream(nums).min().orElse(0);
            int res = 0;
            for (int i = 1; i <= 1000; i++) {
                if (max % i == 0 && min % i == 0) {
                    res = i;
                }
            }
            return res;
        }
    }

}
