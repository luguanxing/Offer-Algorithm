package leetcode.leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1439_有序矩阵中的第k个最小数组和 {

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 5));
        System.out.println(new Solution().kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 9));
        System.out.println(new Solution().kthSmallest(new int[][]{{1, 10, 10}, {1, 4, 5}, {2, 3, 6}}, 7));
        System.out.println(new Solution().kthSmallest(new int[][]{{1, 1, 10}, {2, 2, 9}}, 7));
    }

    static class Solution {
        public int kthSmallest(int[][] mat, int k) {
            // 暴力枚举所有情况
            int height = mat.length;
            int width = mat[0].length;
            // 加到当前行的最小K个和
            List<Integer> currentKSum = new ArrayList<>();
            currentKSum.add(0);
            for (int y = 0; y < height; y++) {
                // 在当前行的最小K个和的基础上加入下一行，排序找出前K个剪枝
                List<Integer> nextKSum = new ArrayList<>();
                for (int sum : currentKSum) {
                    for (int x = 0; x < width; x++) {
                        nextKSum.add(sum + mat[y][x]);
                    }
                    Collections.sort(nextKSum);
                    currentKSum = nextKSum.subList(0, Math.min(nextKSum.size(), k));
                }
            }
            return currentKSum.get(k - 1);
        }
    }

}