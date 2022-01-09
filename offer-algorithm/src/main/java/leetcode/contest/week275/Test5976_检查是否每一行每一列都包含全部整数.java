package leetcode.contest.week275;

public class Test5976_检查是否每一行每一列都包含全部整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkValid(new int[][]{
                {1, 2, 3}, {3, 1, 2}, {2, 3, 1}
        }));
        System.out.println(new Solution().checkValid(new int[][]{
                {1, 1, 1}, {1, 2, 3}, {1, 2, 3}
        }));
    }

    static class Solution {
        public boolean checkValid(int[][] matrix) {
            int n = matrix.length;
            // 检查每一行
            for (int[] row : matrix) {
                boolean[] flags = new boolean[n];
                for (int num : row) {
                    flags[num - 1] = true;
                }
                for (boolean flag : flags) {
                    if (!flag) {
                        return false;
                    }
                }
            }
            // 检查每一列
            for (int x = 0; x < n; x++) {
                boolean[] flags = new boolean[n];
                for (int[] row : matrix) {
                    flags[row[x] - 1] = true;
                }
                for (boolean flag : flags) {
                    if (!flag) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
