package leetcode.contest.week336;

import java.util.Arrays;
import java.util.Comparator;

public class Test6318_完成所有任务的最少时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMinimumTime(new int[][]{{2, 3, 1}, {4, 5, 1}, {1, 5, 2}}));
        System.out.println(new Solution().findMinimumTime(new int[][]{{1, 3, 2}, {2, 5, 3}, {5, 6, 2}}));
    }

    static class Solution {
        public int findMinimumTime(int[][] tasks) {
            // 对于 tasks[i] 来说，它右侧的任务要么和它没有交集，要么包含它的区间后缀
            // 使用贪心，遍历排序后的任务，先统计区间内的电脑运行时间点，如果时间不足优先安排到后面
            Arrays.sort(tasks, Comparator.comparingInt(o -> o[1]));
            int len = tasks.length;
            int res = 0;
            boolean[] runTime = new boolean[2005];
            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];
                int cost = task[2];
                for (int i = start; i <= end; i++) {
                    if (runTime[i]) {
                        cost--;
                    }
                }
                for (int i = end; cost > 0; i--) {
                    if (!runTime[i]) {
                        runTime[i] = true;
                        cost--;
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
