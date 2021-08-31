package leetcode.problems;

import java.util.Arrays;

public class Test1109_航班预订统计 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().corpFlightBookings(
                new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}},
                5
        )));
        System.out.println(Arrays.toString(new Solution().corpFlightBookings(
                new int[][]{{1, 2, 10}, {2, 2, 15}},
                2
        )));
    }

    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            // 构建差分数组
            int[] diff = new int[n + 2];
            for (int[] booking : bookings) {
                int from = booking[0];
                int to = booking[1];
                int add = booking[2];
                diff[from] += add;
                diff[to + 1] -= add;
            }
            // 对查分数组做前缀和即为目标累计值
            int[] prefixSum = new int[n + 2];
            for (int i = 1; i < n + 2; i++) {
                prefixSum[i] = prefixSum[i - 1] + diff[i];
            }
            return Arrays.copyOfRange(prefixSum, 1, n + 1);
        }
    }

}
