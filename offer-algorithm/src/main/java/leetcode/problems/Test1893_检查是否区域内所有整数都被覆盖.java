package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test1893_检查是否区域内所有整数都被覆盖 {

    public static void main(String[] args) {
        System.out.println(new Solution().isCovered(
                new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5
        ));
        System.out.println(new Solution().isCovered(
                new int[][]{{1, 10}, {10, 20}}, 21, 21
        ));
        System.out.println(new Solution().isCovered(
                new int[][]{{36, 50}, {14, 28}, {4, 31}, {24, 37}, {13, 36}, {27, 33}, {23, 32}, {23, 27}, {1, 35}}, 35, 40
        ));
    }

    static class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            // 先排序，后遍历从左到右缩小范围
            int curLeft = left;
            Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
            for (int[] range : ranges) {
                int rangeLeft = range[0];
                int rangeRight = range[1];
                if (rangeLeft <= curLeft && curLeft <= rangeRight) {
                    curLeft = rangeRight + 1;
                }
            }
            return curLeft > right;
        }
    }

}
