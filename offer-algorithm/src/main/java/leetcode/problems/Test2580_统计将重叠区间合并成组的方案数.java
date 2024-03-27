package leetcode.problems;

import java.util.Arrays;

public class Test2580_统计将重叠区间合并成组的方案数 {

    public static void main(String[] args) {
        // ranges = [[6,10],[5,15]]
        System.out.println(new Solution().countWays(new int[][]{{6, 10}, {5, 15}}));
        // ranges = [[1,3],[10,20],[2,5],[4,8]]
        System.out.println(new Solution().countWays(new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}}));
    }

    static class Solution {
        public int countWays(int[][] ranges) {
            // 先合并组，看有几个组
            Arrays.sort(ranges, (r1, r2) -> {
                if (r1[0] == r2[0]) {
                    return r2[1] - r1[1];
                }
                return r1[0] - r2[0];
            });
            int block = 1;
            int blockEnd = ranges[0][1];
            for (int i = 1; i < ranges.length; i++) {
                if (ranges[i][0] > blockEnd) {
                    blockEnd = ranges[i][1];
                    block++;
                } else {
                    blockEnd = Math.max(blockEnd, ranges[i][1]);
                }
            }
            // 然后计算每个组的方案数
            int MOD = 1000000007;
            int res = 1;
            for (int i = 0; i < block; i++) {
                res = res * 2 % MOD;
            }
            return res;
        }
    }

}
