package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test1691_堆叠长方体的最大高度 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxHeight(new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}}));
        System.out.println(new Solution().maxHeight(new int[][]{{38, 25, 45}, {76, 35, 3}}));
        System.out.println(new Solution().maxHeight(new int[][]{{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}}));
    }

    static class Solution {
        public int maxHeight(int[][] cuboids) {
            // 方块内长宽高小到大旋转，方块间按长宽高和小到大排列
            for (int[] cuboid : cuboids) {
                Arrays.sort(cuboid);
            }
            Arrays.sort(cuboids, Comparator.comparingInt(c -> Arrays.stream(c).sum()));
            // dp[i]表示以第i个方块放在最下面时的最大高度
            // dp[i] = max(长宽均小于cuboids[i]的dp[j]) + cuboids[i][2]
            int len = cuboids.length;
            int[] dp = new int[len];
            for (int i = 0; i < len; i++) {
                dp[i] = cuboids[i][2];
                for (int j = 0; j < i; j++) {
                    if (cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                        dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                    }
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }

}
