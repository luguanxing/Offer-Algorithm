package leetcode.problems;

public class Test1277_统计全为1的正方形子矩阵 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));
        System.out.println(new Solution().countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }

    static class Solution {
        public int countSquares(int[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;
            // 用cnt[y][x]表示包括(y,x)在内的左上角和
            int[][] cnt = new int[height][width];
            cnt[0][0] = matrix[0][0];
            for (int x = 1; x < width; x++) {
                cnt[0][x] = cnt[0][x - 1] + matrix[0][x];
            }
            for (int y = 1; y < height; y++) {
                cnt[y][0] = cnt[y - 1][0] + matrix[y][0];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    cnt[y][x] = cnt[y - 1][x] + cnt[y][x - 1] - cnt[y - 1][x - 1] + matrix[y][x];
                }
            }
            // 放到eCnt里，补上左侧和上方的0
            int[][] eCnt = new int[height + 1][width + 1];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    eCnt[y + 1][x + 1] = cnt[y][x];
                }
            }
            // 遍历每个点，看看能组成多少个正方形
            int res = 0;
            for (int y = 1; y <= height; y++) {
                for (int x = 1; x <= width; x++) {
                    for (int len = 0; y + len <= height && x + len <= width; len++) {
                        if (eCnt[y + len][x + len] - eCnt[y + len][x - 1] - eCnt[y - 1][x + len] + eCnt[y - 1][x - 1] == (len + 1) * (len + 1)) {
                            res++;
                            // System.out.println("Found square at (" + (y - 1) + "," + (x - 1) + ") with length " + (len + 1));
                        }
                    }
                }
            }
            return res;
        }
    }

}
