package leetcode.contest.week356;

public class Test6917_满足目标工作时长的员工数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfEmployeesWhoMetTarget(new int[]{0, 1, 2, 3, 4}, 2));
        System.out.println(new Solution().numberOfEmployeesWhoMetTarget(new int[]{5, 1, 4, 2, 2}, 6));
    }

    static class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            int cnt = 0;
            for (int hour : hours) {
                if (hour >= target) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
