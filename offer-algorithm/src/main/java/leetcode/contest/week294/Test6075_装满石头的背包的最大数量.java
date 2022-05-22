package leetcode.contest.week294;

import java.util.Arrays;

public class Test6075_装满石头的背包的最大数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumBags(
                new int[]{2, 3, 4, 5},
                new int[]{1, 2, 4, 4},
                2
        ));
        System.out.println(new Solution().maximumBags(
                new int[]{10, 2, 2},
                new int[]{2, 2, 0},
                100
        ));
        System.out.println(new Solution().maximumBags(
                new int[]{10, 2, 2},
                new int[]{2, 2, 0},
                8
        ));
    }

    static class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int len = capacity.length;
            // 计算每个袋子还能装多少石头
            int[] lefts = new int[len];
            for (int i = 0; i < len; i++) {
                lefts[i] = capacity[i] - rocks[i];
            }
            Arrays.sort(lefts);
            // 贪心计算
            int res = 0;
            for (int left : lefts) {
                if (left == 0) {
                    res++;
                    continue;
                }
                if (left > additionalRocks) {
                    break;
                }
                additionalRocks -= left;
                res++;
            }
            return res;
        }
    }

}
