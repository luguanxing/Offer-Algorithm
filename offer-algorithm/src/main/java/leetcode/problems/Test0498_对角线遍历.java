package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test0498_对角线遍历 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        })));
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(new int[][]{
                {1, 2}, {3, 4}
        })));
    }

    static class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            List<Integer> list = new ArrayList<>();
            int height = mat.length;
            int width = mat[0].length;
            int index = 0;
            // 全部往右上角遍历，偶数趟反转即可
            for (int y = 0; y < height; y++) {
                addDiagonal(mat, y, 0, index++, list);
            }
            for (int x = 1; x < width; x++) {
                addDiagonal(mat, height - 1, x, index++, list);
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        private void addDiagonal(int[][] mat, int y, int x, int index, List<Integer> list) {
            List<Integer> currentList = new ArrayList<>();
            while (0 <= y && x < mat[0].length) {
                currentList.add(mat[y][x]);
                y--;
                x++;
            }
            if (index % 2 == 1) {
                Collections.reverse(currentList);
            }
            list.addAll(currentList);
        }
    }

}
