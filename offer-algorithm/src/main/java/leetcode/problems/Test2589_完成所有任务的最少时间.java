package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test2589_完成所有任务的最少时间 {

    public static void main(String[] args) {
        // tasks = [[2,3,1],[4,5,1],[1,5,2]]
        System.out.println(new Solution().findMinimumTime(new int[][]{{2, 3, 1}, {4, 5, 1}, {1, 5, 2}}));
        // tasks = [[1,3,2],[2,5,3],[5,6,2]]
        System.out.println(new Solution().findMinimumTime(new int[][]{{1, 3, 2}, {2, 5, 3}, {5, 6, 2}}));
    }

    static class Solution {
        public int findMinimumTime(int[][] tasks) {
            // 按结束时间从小到大排序，尽量靠后
            Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
            // 贪心，每次不够时从后往前补上
            boolean[] run = new boolean[2005];
            int res = 0;
            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];
                int duration = task[2];
                for (int i = start; i <= end; i++) {
                    if (run[i]) {
                        duration--;
                    }
                }
                for (int i = end; duration > 0; i--) {
                    if (!run[i]) {
                        run[i] = true;
                        duration--;
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
