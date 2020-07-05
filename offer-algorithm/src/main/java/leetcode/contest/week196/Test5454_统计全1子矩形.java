package leetcode.contest.week196;

import java.util.Arrays;

public class Test5454_统计全1子矩形 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {1, 0, 1},
                        {1, 1, 0},
                        {1, 1, 0},
                }
        ));
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {0, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 1, 1, 0},
                }
        ));
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {1, 1, 1, 1, 1, 1},
                }
        ));
        System.out.println(new Solution().numSubmat(
                new int[][]{
                        {1, 0, 1},
                        {0, 1, 0},
                        {1, 0, 1},
                }
        ));
    }

    static class Solution {
        public int numSubmat(int[][] mat) {
            int height = mat.length;
            int width = mat[0].length;
            int res = 0;
            for (int y = 0; y < height; y++) {
                // 复制出该行，因为后续需要修改数据
                int[] line = Arrays.copyOf(mat[y], width);
                // 先计算1*1的矩形
                res += getRowCount(line);
                // 计算第y行到height行之间的矩形，列之间使用与进行压缩成一行
                for (int bottom = y + 1; bottom < height; bottom++) {
                    for (int x = 0; x < width; x++) {
                        line[x] &= mat[bottom][x];
                    }
                    res += getRowCount(line);
                }
            }
            return res;
        }

        private int getRowCount(int[] nums) {
            // 获取该行连续1的个数
            int sum = nums[0];
            int cur = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 1) {
                    cur++;
                    sum += cur;
                } else {
                    cur = 0;
                }
            }
            return sum;
        }
    }

}
