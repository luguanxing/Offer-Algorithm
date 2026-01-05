package leetcode.problems;

import java.util.*;

public class Test1975_最大方阵和 {

    public static void main(String[] args) {
        // matrix = [[1,-1],[-1,1]]
        System.out.println(new Solution().maxMatrixSum(new int[][]{
                {1, -1},
                {-1, 1}
        }));
        // matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
        System.out.println(new Solution().maxMatrixSum(new int[][]{
                {1, 2, 3},
                {-1, -2, -3},
                {1, 2, 3}
        }));
        // matrix = [[-1,0,-1],[-2,1,3],[3,2,2]]
        System.out.println(new Solution().maxMatrixSum(new int[][]{
                {-1, 0, -1},
                {-2, 1, 3},
                {3, 2, 2}
        }));
        // matrix = [[2,9,3],[5,4,-4],[1,7,1]]
        System.out.println(new Solution().maxMatrixSum(new int[][]{
                {2, 9, 3},
                {5, 4, -4},
                {1, 7, 1}
        }));
    }

    static class Solution {
        public long maxMatrixSum(int[][] matrix) {
            // 统计负数个数，取绝对值排序
            List<Integer> list = new ArrayList<>();
            int negativeCnt = 0;
            for (int[] row : matrix) {
                for (int num : row) {
                    if (num < 0) {
                        negativeCnt++;
                    }
                    list.add(Math.abs(num));
                }
            }
            Collections.sort(list);
            // 负数个数为奇数时，将绝对值最小的数取反
            if (negativeCnt % 2 == 1) {
                list.set(0, -list.get(0));
            }
            // 贪心计算最大总和
            long sum = 0;
            for (int num : list) {
                sum += num;
            }
            return sum;
        }
    }

}
