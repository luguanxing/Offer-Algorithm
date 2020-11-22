package leetcode.contest.week216;

import java.util.Arrays;

public class Test5608_完成所有任务的最少初始能量 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumEffort(
                new int[][]{{1, 2}, {2, 4}, {4, 8}}
        ));
        System.out.println(new Solution().minimumEffort(
                new int[][]{{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}}
        ));
        System.out.println(new Solution().minimumEffort(
                new int[][]{{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}}
        ));
    }

    static class Solution {
        public int minimumEffort(int[][] tasks) {
            int sumActual = 0;
            int sumMin = 0;
            for (int[] actualMin : tasks) {
                sumActual += actualMin[0];
                sumMin += actualMin[1];
            }
            Arrays.sort(tasks, (o1, o2) -> (o2[1] - o2[0]) - (o1[1] - o1[0]));
            int res = binarySearch(tasks, Math.min(sumActual, sumMin), Math.max(sumActual, sumMin));
            return res;
        }

        private int binarySearch(int[][] tasks, int left, int right) {
            while (left < right) {
                int mid = left + (right - left) / 2;
                int sum = mid;
                boolean isOk = true;
                for (int[] actualMin : tasks) {
                    if (sum >= actualMin[1]) {
                        sum -= actualMin[0];
                    } else {
                        isOk = false;
                        break;
                    }
                }
                if (isOk && mid >= 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
