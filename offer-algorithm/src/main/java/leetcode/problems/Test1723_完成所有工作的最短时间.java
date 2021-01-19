package leetcode.problems;

import java.util.Arrays;

public class Test1723_完成所有工作的最短时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTimeRequired(
                new int[]{3, 2, 3}, 3
        ));
        System.out.println(new Solution().minimumTimeRequired(
                new int[]{1, 2, 4, 7, 8}, 2
        ));
        System.out.println(new Solution().minimumTimeRequired(
                new int[]{4, 4, 4, 5, 5}, 2
        ));
    }

    static class Solution {
        int[] time;
        int res = Integer.MAX_VALUE;

        public int minimumTimeRequired(int[] jobs, int k) {
            Arrays.sort(jobs);
            time = new int[k];
            dfs(jobs, 0);
            return res;
        }

        private void dfs(int[] jobs, int jobIndex) {
            if (jobIndex == jobs.length) {
                int currentMax = Arrays.stream(time).max().orElse(Integer.MAX_VALUE);
                res = Math.min(res, currentMax);
                return;
            }
            int job = jobs[jobIndex];
            for (int i = 0; i < time.length; i++) {
                // 尝试将第jobIndex项工作分配给某个工人，需要剪枝
                if (time[i] + job >= res) {
                    continue;
                } else {
                    time[i] += job;
                    dfs(jobs, jobIndex + 1);
                    time[i] -= job;
                }
                if (time[i] == 0) {
                    // 工作已分配完，可退出
                    break;
                }
            }
        }
    }

}
