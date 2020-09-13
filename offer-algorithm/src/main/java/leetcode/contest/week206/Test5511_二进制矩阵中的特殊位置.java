package leetcode.contest.week206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5511_二进制矩阵中的特殊位置 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSpecial(
                new int[][]{
                        {1, 0, 0},
                        {0, 0, 1},
                        {1, 0, 0},
                }
        ));
        System.out.println(new Solution().numSpecial(
                new int[][]{
                        {1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1},
                }
        ));
        System.out.println(new Solution().numSpecial(
                new int[][]{
                        {0, 0, 0, 1},
                        {1, 0, 0, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0},
                }
        ));
        System.out.println(new Solution().numSpecial(
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1},
                }
        ));
        System.out.println(new Solution().numSpecial(
                new int[][]{
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0},
                }
        ));
    }

    static class Solution {
        public int numSpecial(int[][] mat) {
            int height = mat.length;
            int width = mat[0].length;
            // 统计只有1个行
            List<Integer> rows = new ArrayList<>();
            for (int y = 0; y < height; y++) {
                int count1 = 0;
                for (int x = 0; x < width; x++) {
                    if (mat[y][x] == 1) {
                        count1++;
                    }
                }
                if (count1 == 1) {
                    rows.add(y);
                }
            }
            // 判断这些只有1个1的行有1的那一列是不是列也只有1个1
            int res = 0;
            for (int row : rows) {
                int count1 = 0;
                int rowIndex = Arrays.stream(mat[row]).boxed().collect(Collectors.toList()).indexOf(1);
                for (int y = 0; y < height; y++) {
                    if (mat[y][rowIndex] == 1) {
                        count1++;
                    }
                }
                if (count1 == 1) {
                    res++;
                }
            }
            return res;
        }
    }

}
