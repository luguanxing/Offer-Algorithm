package leetcode.problems;

import java.util.*;

public class Test3439_重新安排会议得到最多空余时间I {

    public static void main(String[] args) {
        // eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
        System.out.println(new Solution().maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5}));
        // eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
        System.out.println(new Solution().maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10}));
        // eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
        System.out.println(new Solution().maxFreeTime(5, 2, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().maxFreeTime(34, 2, new int[]{0, 17}, new int[]{14, 19}));
        System.out.println(new Solution().maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10}));
    }

    static class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            // 先统计出空隙
            List<Integer> buffers = new ArrayList<>();
            buffers.add(startTime[0]);
            for (int i = 0; i < startTime.length - 1; i++) {
                buffers.add(startTime[i + 1] - endTime[i]);
            }
            buffers.add(eventTime - endTime[endTime.length - 1]);
            // 使用滑动窗口统计k个空隙的最大值
            int sum = 0;
            for (int i = 0; i <= k; i++) {
                sum += buffers.get(i);
            }
            int max = sum;
            for (int i = k + 1; i < buffers.size(); i++) {
                sum += buffers.get(i) - buffers.get(i - k - 1);
                max = Math.max(max, sum);
            }
            return max;
        }
    }

}
