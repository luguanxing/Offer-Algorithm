package leetcode.interview;

import java.util.HashSet;
import java.util.Set;

public class Test01_08_零矩阵 {

    public static void main(String[] args) {

    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            int height = matrix.length;
            int width = matrix[0].length;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix[y][x] == 0) {
                        rows.add(y);
                        cols.add(x);
                    }
                }
            }
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (rows.contains(y) || cols.contains(x)) {
                        matrix[y][x] = 0;
                    }
                }
            }
        }
    }

}
