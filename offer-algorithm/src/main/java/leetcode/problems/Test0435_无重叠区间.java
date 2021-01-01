package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test0435_无重叠区间 {

    public static void main(String[] args) {
        System.out.println(new Solution().eraseOverlapIntervals(
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}
        ));
        System.out.println(new Solution().eraseOverlapIntervals(
                new int[][]{{1, 2}, {1, 2}, {1, 2}}
        ));
        System.out.println(new Solution().eraseOverlapIntervals(
                new int[][]{{1, 2}, {2, 3}}
        ));
    }

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            // 排序:先start小的在前，再按end小的在前排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            // 每次选择和上一个不重合的结尾最短的段放入，计算能合并成多少段
            int max = 1;
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int start = intervals[i][0];
                if (end <= start) {
                    end = intervals[i][1];
                    max++;
                }
            }
            return intervals.length - max;
        }
    }

}
