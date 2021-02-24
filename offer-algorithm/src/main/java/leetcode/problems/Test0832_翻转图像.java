package leetcode.problems;

import java.util.Arrays;

public class Test0832_翻转图像 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().flipAndInvertImage(new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0},
        })));
    }

    static class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int height = A.length;
            int width = A[0].length;
            int[][] res = new int[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x <= width / 2; x++) {
                    res[y][x] = A[y][width - 1 - x];
                    res[y][width - 1 - x] = A[y][x];
                }
                for (int x = 0; x < width; x++) {
                    res[y][x] = res[y][x] == 1 ? 0 : 1;
                }
            }
            return res;
        }
    }

}
