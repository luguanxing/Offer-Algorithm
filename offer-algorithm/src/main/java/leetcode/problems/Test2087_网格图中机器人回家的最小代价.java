package leetcode.problems;

public class Test2087_网格图中机器人回家的最小代价 {

    public static void main(String[] args) {
        // startPos = [1, 0], homePos = [2, 3], rowCosts = [5, 4, 3], colCosts = [8, 2, 6, 7]
        System.out.println(new Solution().minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}));
        // startPos = [0, 0], homePos = [0, 0], rowCosts = [5], colCosts = [26]
        System.out.println(new Solution().minCost(new int[]{0, 0}, new int[]{0, 0}, new int[]{5}, new int[]{26}));
    }

    static class Solution {
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            // 不用DFS或DP，因为走向目标经过的行+列是唯一的，绕路只会增加开销，直接贪心计算
            int startY = startPos[0], startX = startPos[1];
            int targetY = homePos[0], targetX = homePos[1];
            int cost = 0;
            int y = startY;
            int x = startX;
            while (y < targetY) {
                y++;
                cost += rowCosts[y];
            }
            while (y > targetY) {
                y--;
                cost += rowCosts[y];
            }
            while (x < targetX) {
                x++;
                cost += colCosts[x];
            }
            while (x > targetX) {
                x--;
                cost += colCosts[x];
            }
            return cost;
        }
    }

}
