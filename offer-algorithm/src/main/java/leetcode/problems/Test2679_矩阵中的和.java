package leetcode.problems;

import java.util.Arrays;

public class Test2679_矩阵中的和 {

    public static void main(String[] args) {
        System.out.println(new Solution().matrixSum(new int[][]{{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}}));
        System.out.println(new Solution().matrixSum(new int[][]{{1}}));
    }

    static class Solution {
        public int matrixSum(int[][] nums) {
            int height = nums.length;
            int width = nums[0].length;
            int res = 0;
            for (int[] row : nums) {
                Arrays.sort(row);
            }
            for (int x = 0; x < width; x++) {
                int max = nums[0][x];
                for (int y = 0; y < height; y++) {
                    max = Math.max(max, nums[y][x]);
                }
                res += max;
            }
            return res;
        }
    }

}
