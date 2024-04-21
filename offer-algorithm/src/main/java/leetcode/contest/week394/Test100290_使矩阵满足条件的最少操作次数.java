package leetcode.contest.week394;

public class Test100290_使矩阵满足条件的最少操作次数 {

    public static void main(String[] args) {
        // [[1,0,2],[1,0,2]]
        System.out.println(new Solution().minimumOperations(new int[][]{{1, 0, 2}, {1, 0, 2}}));
        // [[1,1,1],[0,0,0]]
        System.out.println(new Solution().minimumOperations(new int[][]{{1, 1, 1}, {0, 0, 0}}));
        // [[1],[2],[3]]
        System.out.println(new Solution().minimumOperations(new int[][]{{1}, {2}, {3}}));
    }

    /*
        考虑最后压缩成一行的情况再计算成本

        怎么算这一行？
        1. 算出每一i列的数字(x1,x2,...)和出现次数(c1,c2,...)
            如果该列都改为x1,成本是m-c1
            如果该列都改为x2,成本是m-c2
        2. 确定好列成本之后，再确定列之相邻不同的成本
            使用动态规划dp[i][j]，表示前i列以j结尾的成本，范围i是0-n，j是0-9
            显然有dp[i+1][j]=min(dp[i][k]+cost)，其中k!=j，cost是上面计算的该列都改为k的成本m-k出现的频率
     */
    static class Solution {
        public int minimumOperations(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // 如果只有一个元素，不需要操作
            if (m == 1 && n == 1) {
                return 0;
            }

            // 存储每一列数字的出现频率
            int[][] counts = new int[n][10]; // 假设grid的值在0到9之间
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    counts[j][grid[i][j]]++;
                }
            }

            // 计算将每一列转变为某个特定值的成本
            int[][] cost = new int[n][10];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 10; k++) {
                    cost[j][k] = m - counts[j][k]; // 将整列转变为值k的操作数
                }
            }

            // 动态规划数组，dp[i][j]表示处理到第i列，且该列统一为j值的最小成本
            int[][] dp = new int[n][10];
            for (int j = 0; j < 10; j++) {
                dp[0][j] = cost[0][j]; // 初始化第一列的成本
            }

            // 填充dp数组
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < 10; k++) {
                        if (j != k) { // 确保相邻列的值不同
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost[i][j]);
                        }
                    }
                }
            }

            // 最终结果是第n-1列的最小成本
            int minOps = Integer.MAX_VALUE;
            for (int j = 0; j < 10; j++) {
                minOps = Math.min(minOps, dp[n - 1][j]);
            }

            return minOps;
        }
    }


}
