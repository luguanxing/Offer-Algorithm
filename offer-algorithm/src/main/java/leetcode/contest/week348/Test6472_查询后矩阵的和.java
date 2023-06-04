package leetcode.contest.week348;

import java.util.HashSet;
import java.util.Set;

public class Test6472_查询后矩阵的和 {

    public static void main(String[] args) {
        System.out.println(new Solution().matrixSumQueries(
                3, new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}}
        ));
        System.out.println(new Solution().matrixSumQueries(
                3, new int[][]{{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}}
        ));
    }

    static class Solution {
        public long matrixSumQueries(int n, int[][] queries) {
            // 从后往前倒序计算，因为后面的会影响前面的填补
            Set<Integer> visitedCols = new HashSet<>();
            Set<Integer> visitedRows = new HashSet<>();
            long sum = 0;
            for (int i = queries.length - 1; i >= 0; i--) {
                int type = queries[i][0];
                int index = queries[i][1];
                int val = queries[i][2];
                if (type == 0) {
                    if (!visitedRows.contains(index)) {
                        sum += (long) (n - visitedCols.size()) * val;
                        visitedRows.add(index);
                    }
                } else {
                    if (!visitedCols.contains(index)) {
                        sum += (long) (n - visitedRows.size()) * val;
                        visitedCols.add(index);
                    }
                }
            }
            return sum;
        }
    }

}
