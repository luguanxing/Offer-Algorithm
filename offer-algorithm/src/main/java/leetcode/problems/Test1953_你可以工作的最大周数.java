package leetcode.problems;

public class Test1953_你可以工作的最大周数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWeeks(new int[]{1, 2, 3}));
        System.out.println(new Solution().numberOfWeeks(new int[]{5, 2, 1}));
        System.out.println(new Solution().numberOfWeeks(new int[]{5, 7, 5, 7, 9, 7}));
    }

    static class Solution {
        public long numberOfWeeks(int[] milestones) {
            // 计算任务总数和最大任务数量
            long taskSum = 0;
            long taskMax = 0;
            for (int milestone : milestones) {
                taskSum += milestone;
                taskMax = Math.max(taskMax, milestone);
            }
            // 对数量最多的任务，只要其数量小于等于剩下其它任务数量+1，就可以完成全部任务
            // 否则，只能完成剩下任务*2+1
            if (taskMax <= taskSum - taskMax + 1) {
                return taskSum;
            } else {
                return 2L * (taskSum - taskMax) + 1;
            }
        }
    }

}
