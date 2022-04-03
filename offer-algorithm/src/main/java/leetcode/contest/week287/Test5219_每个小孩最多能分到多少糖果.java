package leetcode.contest.week287;

import java.util.Arrays;

public class Test5219_每个小孩最多能分到多少糖果 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumCandies(new int[]{5, 8, 6}, 3L));
        System.out.println(new Solution().maximumCandies(new int[]{2, 5}, 11L));
        System.out.println(new Solution().maximumCandies(new int[]{2, 5, 8}, 11L));
        System.out.println(new Solution().maximumCandies(new int[]{2, 5, 8, 6}, 11L));
        System.out.println(new Solution().maximumCandies(new int[]{2, 6, 8, 6}, 11L));
        System.out.println(new Solution().maximumCandies(new int[]{4, 7, 5}, 4L));
        System.out.println(new Solution().maximumCandies(new int[]{1, 2, 3, 4, 10}, 5L));
    }

    static class Solution {
        public int maximumCandies(int[] candies, long k) {
            int len = candies.length;
            Arrays.sort(candies);
            // 假设拆出的k堆每堆有n个，那么要求candies至少能拆出k堆，找出满足这样条件的最大n
            int maxN = candies[len - 1] + 1;
            int minN = 1;
            while (minN < maxN) {
                int midN = minN + (maxN - minN) / 2;
                if (canSplitToKHeaps(candies, midN, k)) {
                    minN = midN + 1;
                } else {
                    maxN = midN;
                }
            }
            return minN - 1;
        }

        private boolean canSplitToKHeaps(int[] candies, int midN, long k) {
            long cnt = 0;
            for (int candy : candies) {
                cnt += candy / midN;
            }
            return cnt >= k;
        }
    }

}
