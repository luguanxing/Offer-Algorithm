package leetcode.problems;

public class Test0085_最大矩形 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximalRectangle(
                new char[][]{}
        ));
        System.out.println(new Solution().maximalRectangle(
                new char[][]{{'1'}}
        ));
        System.out.println(new Solution().maximalRectangle(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }
        ));
    }

    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int height = matrix.length;
            int width = matrix[0].length;
            // left[y][x]表示该点左边最多1的个数
            int[][] left = new int[height][width];
            for (int y = 0; y < height; y++) {
                left[y][0] = matrix[y][0] == '0' ? 0 : 1;
                for (int x = 1; x < width; x++) {
                    if (matrix[y][x] == '1') {
                        left[y][x] = left[y][x - 1] + 1;
                    }
                }
            }
            // 遍历每一个点，当其作为右下角时看和上方的点组成的面积是多少
            int res = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix[y][x] == '0') {
                        continue;
                    }
                    int wid = left[y][x];
                    int hei = 1;
                    res = Math.max(res, wid * hei);
                    for (int up = y - 1; up >= 0; up--) {
                        hei++;
                        wid = Math.min(wid, left[up][x]);
                        res = Math.max(res, wid * hei);
                    }
                }
            }
            return res;
        }
    }

}
