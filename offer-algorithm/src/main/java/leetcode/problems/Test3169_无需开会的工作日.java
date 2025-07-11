package leetcode.problems;

import java.util.*;

public class Test3169_无需开会的工作日 {

    public static void main(String[] args) {
        // days = 10, meetings = [[5,7],[1,3],[9,10]]
        System.out.println(new Solution().countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
        // days = 5, meetings = [[2,4],[1,3]]
        System.out.println(new Solution().countDays(5, new int[][]{{2, 4}, {1, 3}}));
        // days = 6, meetings = [[1,6]]
        System.out.println(new Solution().countDays(6, new int[][]{{1, 6}}));
    }

    static class Solution {
        public int countDays(int days, int[][] meetings) {
            // 按开始时间小到大排序
            Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
            // 合并会议后统计
            int res = 0;
            int maxEnd = 0;
            for (int[] meeting : meetings) {
                int meetingStart = meeting[0];
                int meetingEnd = meeting[1];
                if (meetingStart > maxEnd) {
                    res += (meetingStart - 1) - maxEnd;
                }
                // 更新最大结束时间
                maxEnd = Math.max(maxEnd, meetingEnd);
            }
            res += days - maxEnd;
            return res;
        }
    }

}
