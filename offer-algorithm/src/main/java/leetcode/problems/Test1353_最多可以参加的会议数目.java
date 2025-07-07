package leetcode.problems;

import java.util.*;

public class Test1353_最多可以参加的会议数目 {

    public static void main(String[] args) {
        // events = [[1,2],[2,3],[3,4]]
        System.out.println(new Solution().maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        // events= [[1,2],[2,3],[3,4],[1,2]]
        System.out.println(new Solution().maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
        // [[1,5],[1,5],[1,5],[2,3],[2,3]]
        System.out.println(new Solution().maxEvents(new int[][]{{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}}));
    }

    static class Solution {
        public int maxEvents(int[][] events) {
            // 按开始时间、结束时间小到大排序
            TreeMap<Integer, List<int[]>> eventMap = new TreeMap<>();
            int lastDay = 0;
            for (int[] event : events) {
                int start = event[0];
                int end = event[1];
                eventMap.putIfAbsent(start, new ArrayList<>());
                eventMap.get(start).add(event);
                lastDay = Math.max(lastDay, end);
            }
            for (List<int[]> eventList : eventMap.values()) {
                eventList.sort(Comparator.comparingInt(event -> event[1]));
            }
            // 贪心获取最大
            int res = 0;
            PriorityQueue<int[]> currentEvents = new PriorityQueue<>(Comparator.comparingInt(event -> event[1]));
            for (int t = 1; t <= lastDay; t++) {
                // 添加当天开始的会议
                if (eventMap.containsKey(t)) {
                    currentEvents.addAll(eventMap.get(t));
                }
                // 判断是否能参加会议
                while (!currentEvents.isEmpty()) {
                    int[] event = currentEvents.poll();
                    int eventStart = event[0];
                    int eventEnd = event[1];
                    // 参加会议
                    if (t <= eventEnd) {
                        res++;
                        break; // 参加一个会议后，跳出循环，继续下一个时间点
                    }
                }
            }
            return res;
        }
    }

    static class Solution_贪心错误 {
        public int maxEvents(int[][] events) {
            // 按结束时间、开始时间小到大排序
            Arrays.sort(events, (event1, event2) -> {
                int event1Start = event1[0];
                int event1End = event1[1];
                int event2Start = event2[0];
                int event2End = event2[1];
                if (event1End != event2End) {
                    return Integer.compare(event1End, event2End);
                } else {
                    return Integer.compare(event1Start, event2Start);
                }
            });
            // 贪心获取最大
            int res = 0;
            int currentTime = 0;
            for (int[] event : events) {
                int eventStart = event[0];
                int eventEnd = event[1];
                // 参加会议
                if (currentTime <= eventEnd) {
                    res++;
                    currentTime = Math.max(currentTime, eventStart) + 1;
                }
            }
            return res;
        }
    }

}
