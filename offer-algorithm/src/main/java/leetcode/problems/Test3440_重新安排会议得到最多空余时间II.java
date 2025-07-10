package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Test3440_重新安排会议得到最多空余时间II {

    public static void main(String[] args) {
        // eventTime = 5, startTime = [1,3], endTime = [2,5]
        System.out.println(new Solution().maxFreeTime(5, new int[]{1, 3}, new int[]{2, 5}));
        // eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]
        System.out.println(new Solution().maxFreeTime(10, new int[]{0, 7, 9}, new int[]{1, 8, 10}));
        // eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
        System.out.println(new Solution().maxFreeTime(10, new int[]{0, 3, 7, 9}, new int[]{1, 4, 8, 10}));
        // eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
        System.out.println(new Solution().maxFreeTime(5, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5}));
    }

    static class Solution {
        public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
            // 先统计出空隙
            TreeMap<Integer, Integer> buffersMap = new TreeMap<>();
            List<Integer> buffers = new ArrayList<>();
            buffers.add(startTime[0]);
            buffersMap.put(startTime[0], 1);
            for (int i = 0; i < startTime.length - 1; i++) {
                int buffer = startTime[i + 1] - endTime[i];
                buffers.add(buffer);
                buffersMap.put(buffer, buffersMap.getOrDefault(buffer, 0) + 1);
            }
            int lastBuffer = eventTime - endTime[endTime.length - 1];
            buffers.add(lastBuffer);
            buffersMap.put(lastBuffer, buffersMap.getOrDefault(lastBuffer, 0) + 1);
            // 见缝插针，计算会议相邻空隙的可能的最大值
            int max = 0;
            for (int i = 1; i < buffers.size(); i++) {
                int buffer1 = buffers.get(i - 1);
                int buffer2 = buffers.get(i);
                int meeting = endTime[i - 1] - startTime[i - 1];
                int sum = buffer1 + buffer2;
                // 看看是否有其它地方的空隙可以塞入meeting，可以的话算上会议本身的时间
                buffersMap.put(buffer1, buffersMap.get(buffer1) - 1);
                if (buffersMap.get(buffer1) == 0) {
                    buffersMap.remove(buffer1);
                }
                buffersMap.put(buffer2, buffersMap.get(buffer2) - 1);
                if (buffersMap.get(buffer2) == 0) {
                    buffersMap.remove(buffer2);
                }
                if (buffersMap.containsKey(meeting) || buffersMap.higherKey(meeting) != null) {
                    sum += meeting;
                }
                max = Math.max(max, sum);
                // 恢复空隙
                buffersMap.put(buffer1, buffersMap.getOrDefault(buffer1, 0) + 1);
                buffersMap.put(buffer2, buffersMap.getOrDefault(buffer2, 0) + 1);
            }
            return max;
        }
    }

}
