package leetcode.contest.week256;

public class Test5856_完成任务的最少工作时间段 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSessions(
                new int[]{1, 2, 3},
                3
        ));
        System.out.println(new Solution().minSessions(
                new int[]{3, 1, 3, 1, 1},
                8
        ));
        System.out.println(new Solution().minSessions(
                new int[]{1, 2, 3, 4, 5},
                15
        ));
        System.out.println(new Solution().minSessions(
                new int[]{1, 5, 7, 10, 3, 8, 4, 2, 6, 2},
                10
        ));
        System.out.println(new Solution().minSessions(
                new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                10
        ));
        System.out.println(new Solution().minSessions(
                new int[]{3, 6, 5, 5, 10, 7},
                10
        ));
        System.out.println(new Solution().minSessions(
                new int[]{2, 3, 3, 4, 4, 4, 5, 6, 7, 10},
                12
        ));
    }

    static class Solution {
        public int minSessions(int[] tasks, int sessionTime) {
            // 枚举所有可能的时段个数
            for (int cnt = 1; cnt <= tasks.length; cnt++) {
                if (trySessionTime(tasks, sessionTime, cnt)) {
                    return cnt;
                }
            }
            return tasks.length;
        }

        boolean isOk;

        private boolean trySessionTime(int[] tasks, int sessionTime, int cnt) {
            // 判断cnt个sessionTime是否可以装下所有的tasks
            int[] sessions = new int[cnt];
            isOk = false;
            check(tasks, sessionTime, 0, sessions);
            return isOk;
        }

        private void check(int[] tasks, int sessionTime, int index, int[] sessions) {
            if (index == tasks.length) {
                isOk = true;
                return;
            }
            // 把第index个任务放到不同sessions中进行枚举
            int task = tasks[index];
            for (int i = 0; i < Math.min(index + 1, sessions.length); i++) { // 任务数比session少的时候不去枚举后面的session
                if (sessions[i] + task <= sessionTime) {
                    sessions[i] += task;
                    check(tasks, sessionTime, index + 1, sessions);
                    sessions[i] -= task;
                }
            }
        }
    }

}
