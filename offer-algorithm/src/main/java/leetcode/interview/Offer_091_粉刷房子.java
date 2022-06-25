package leetcode.interview;

public class Offer_091_粉刷房子 {

    public static void main(String[] args) {
        System.out.println(new Solution().minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(new Solution().minCost(new int[][]{{7, 6, 2}}));
    }

    static class Solution {
        public int minCost(int[][] costs) {
            int len = costs.length;
            // dpColor[i]表示以Color结尾长度为i的最小价格
            int[] dpRed = new int[len];
            int[] dpBlue = new int[len];
            int[] dpGreen = new int[len];
            dpRed[0] = costs[0][0];
            dpBlue[0] = costs[0][1];
            dpGreen[0] = costs[0][2];
            // dpColor[i] = min(dp不同颜色[i-1]) + cost[i][color]
            for (int i = 1; i < len; i++) {
                dpRed[i] = Math.min(dpBlue[i - 1], dpGreen[i - 1]) + costs[i][0];
                dpBlue[i] = Math.min(dpRed[i - 1], dpGreen[i - 1]) + costs[i][1];
                dpGreen[i] = Math.min(dpRed[i - 1], dpBlue[i - 1]) + costs[i][2];
            }
            return Math.min(dpRed[len - 1], Math.min(dpBlue[len - 1], dpGreen[len - 1]));
        }
    }

}
