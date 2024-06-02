package leetcode.contest.week400;

import java.util.*;

public class Test100311_无需开会的工作日 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1
        int days1 = 10;
        int[][] meetings1 = {{5, 7}, {1, 3}, {9, 10}};
        System.out.println(solution.countDays(days1, meetings1)); // 输出: 2

        // 示例 2
        int days2 = 5;
        int[][] meetings2 = {{2, 4}, {1, 3}};
        System.out.println(solution.countDays(days2, meetings2)); // 输出: 1

        // 示例 3
        int days3 = 6;
        int[][] meetings3 = {{1, 6}};
        System.out.println(solution.countDays(days3, meetings3)); // 输出: 0
    }

    static class Solution {
        public int countDays(int days, int[][] meetings) {
            if (meetings.length == 0) {
                return days;
            }
            // 按会议开始时间排序
            Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
            int[][] mergedMeetings = new int[meetings.length][2];
            int mergedIndex = 0;
            mergedMeetings[0] = meetings[0];
            // 合并会议时间段
            for (int i = 1; i < meetings.length; i++) {
                int[] lastMergedMeeting = mergedMeetings[mergedIndex];
                if (meetings[i][0] <= lastMergedMeeting[1]) {
                    lastMergedMeeting[1] = Math.max(lastMergedMeeting[1], meetings[i][1]);
                } else {
                    mergedIndex++;
                    mergedMeetings[mergedIndex] = meetings[i];
                }
            }
            // 计算总的会议时间天数
            int meetingDays = 0;
            for (int i = 0; i <= mergedIndex; i++) {
                meetingDays += mergedMeetings[i][1] - mergedMeetings[i][0] + 1;
            }
            return days - meetingDays;
        }
    }

}
