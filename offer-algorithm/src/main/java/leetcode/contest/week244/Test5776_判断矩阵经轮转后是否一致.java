package leetcode.contest.week244;

public class Test5776_判断矩阵经轮转后是否一致 {

    public static void main(String[] args) {
        System.out.println(new Solution().findRotation(
                new int[][]{{0, 1}, {1, 0}},
                new int[][]{{1, 0}, {0, 1}}
        ));
        System.out.println(new Solution().findRotation(
                new int[][]{{0, 1}, {1, 1}},
                new int[][]{{1, 0}, {0, 1}}
        ));
        System.out.println(new Solution().findRotation(
                new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}
        ));
    }

    static class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            for (int i = 0; i < 4; i++) {
                if (checkEquals(mat, target)) {
                    return true;
                } else {
                    rotate(mat);
                }
            }
            return false;
        }

        private void rotate(int[][] matrix) {
            int height = matrix.length;
            for (int y = 0; y < height / 2; y++) {
                for (int x = y; x < height - y - 1; x++) {
                    int temp = matrix[y][x];
                    matrix[y][x] = matrix[height - x - 1][y];
                    matrix[height - x - 1][y] = matrix[height - y - 1][height - x - 1];
                    matrix[height - y - 1][height - x - 1] = matrix[x][height - y - 1];
                    matrix[x][height - y - 1] = temp;
                }
            }
        }

        private boolean checkEquals(int[][] mat, int[][] target) {
            if (mat.length != target.length || mat[0].length != target[0].length) {
                return false;
            }
            int height = mat.length;
            int width = mat[0].length;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (mat[y][x] != target[y][x]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
