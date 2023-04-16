package leetcode.contest.week341;

public class Test6350_找出可整除性得分最大的整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDivScore(
                new int[]{4, 7, 9, 3, 9},
                new int[]{5, 2, 3}
        ));
        System.out.println(new Solution().maxDivScore(
                new int[]{20, 14, 21, 10},
                new int[]{5, 7, 5}
        ));
        System.out.println(new Solution().maxDivScore(
                new int[]{12},
                new int[]{10, 16}
        ));
        System.out.println(new Solution().maxDivScore(
                new int[]{12},
                new int[]{10, 16, 8}
        ));
        System.out.println(new Solution().maxDivScore(
                new int[]{1},
                new int[]{1000000000}
        ));
    }

    static class Solution {
        public int maxDivScore(int[] nums, int[] divisors) {
            int maxDivisor = divisors[0];
            int maxCnt = 0;
            for (int divisor : divisors) {
                int cnt = 0;
                for (int num : nums) {
                    if (num % divisor == 0) {
                        cnt++;
                    }
                }
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    maxDivisor = divisor;
                } else if (cnt == maxCnt && divisor < maxDivisor) {
                    maxDivisor = divisor;
                }
            }
            return maxDivisor;
        }
    }

}
