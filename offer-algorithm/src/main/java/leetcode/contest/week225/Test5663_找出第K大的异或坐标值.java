package leetcode.contest.week225;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5663_找出第K大的异或坐标值 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 2}, {1, 6}};
        System.out.println(new Solution().kthLargestValue(matrix, 1));
        System.out.println(new Solution().kthLargestValue(matrix, 2));
        System.out.println(new Solution().kthLargestValue(matrix, 3));
        System.out.println(new Solution().kthLargestValue(matrix, 4));
        int[][] mat = new int[][]{{8, 10, 5, 8, 5, 7, 6, 0, 1, 4, 10, 6, 4, 3, 6, 8, 7, 9, 4, 2}};
        System.out.println(new Solution().kthLargestValue(mat, 2));
    }

    static class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int height = matrix.length;
            int width = matrix[0].length;
            List<Integer> res = new ArrayList<>();
            int[][] dp = new int[height][width];
            dp[0][0] = matrix[0][0];
            res.add(dp[0][0]);
            for (int y = 1; y < height; y++) {
                dp[y][0] = matrix[y][0] ^ dp[y - 1][0];
                res.add(dp[y][0]);
            }
            for (int x = 1; x < width; x++) {
                dp[0][x] = matrix[0][x] ^ dp[0][x - 1];
                res.add(dp[0][x]);
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    dp[y][x] = dp[y - 1][x] ^ dp[y][x - 1] ^ dp[y - 1][x - 1] ^ matrix[y][x];
                    res.add(dp[y][x]);
                }
            }
            Collections.sort(res);
            return res.get(res.size() - k);
        }
    }

}
