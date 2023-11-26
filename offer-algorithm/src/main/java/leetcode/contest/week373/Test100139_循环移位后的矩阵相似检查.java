package leetcode.contest.week373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test100139_循环移位后的矩阵相似检查 {

    public static void main(String[] args) {
        // mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
        System.out.println(new Solution().areSimilar(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}}, 2));
        // mat = [[2,2],[2,2]], k = 3
        System.out.println(new Solution().areSimilar(new int[][]{{2, 2}, {2, 2}}, 3));
        // mat = [[1,2]], k = 1
        System.out.println(new Solution().areSimilar(new int[][]{{1, 2}}, 1));
    }

    // 给你一个大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
    //如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
    static class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            int width = mat[0].length;
            for (int y = 0; y < mat.length; y++) {
                List<Integer> row = Arrays.stream(mat[y]).boxed().collect(Collectors.toList());
                List<Integer> fullRow = new ArrayList<>(row);
                fullRow.addAll(row);
                if (y % 2 == 0) {
                    // 偶数行，左移
                    for (int x = 0; x < width; x++) {
                        if (mat[y][x] != fullRow.get(x + k % width)) {
                            return false;
                        }
                    }
                } else {
                    // 奇数行，右移
                    for (int x = width; x < width * 2; x++) {
                        if ((int) fullRow.get(x) != fullRow.get(x - k % width)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

}
