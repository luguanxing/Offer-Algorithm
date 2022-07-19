package leetcode.problems;

import java.util.Map;
import java.util.TreeMap;

public class Test0731_我的日程安排表II {

    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(47, 50));
        System.out.println(myCalendar.book(1, 10));
        System.out.println(myCalendar.book(27, 36));
        System.out.println(myCalendar.book(40, 47));
        System.out.println(myCalendar.book(20, 27));
        System.out.println(myCalendar.book(15, 23));
        System.out.println(myCalendar.book(10, 18));
        System.out.println(myCalendar.book(27, 36));
        System.out.println(myCalendar.book(11, 17));
    }

    static class MyCalendarTwo {
        TreeMap<Integer, Integer> treeMap;

        public MyCalendarTwo() {
            treeMap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            // 直接尝试遍历差分数组，发现不符合条件则回溯
            treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
            treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
            int currentCnt = 0;
            for (int cnt : treeMap.values()) {
                currentCnt += cnt;
                if (currentCnt > 2) {
                    treeMap.put(start, treeMap.get(start) - 1);
                    treeMap.put(end, treeMap.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }

    static class MyCalendarTwo_细节有误 {
        TreeMap<Integer, Integer> endStartMap;
        TreeMap<Integer, Integer> duplicateMap;

        public MyCalendarTwo_细节有误() {
            endStartMap = new TreeMap<>();
            duplicateMap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if (!noDuplication(start, end)) {
                return false;
            }
            // 找出end和当前start最接近的下个区间，并比较这个区间start和当前end是否重叠即可
            Map.Entry<Integer, Integer> cloestEntry = endStartMap.higherEntry(start);
            if (cloestEntry == null) {
                endStartMap.put(end, start);
                return true;
            }
            int cloestEnd = cloestEntry.getKey();
            int cloestStart = cloestEntry.getValue();
            // 判断是否会重复
            if (cloestEnd <= start || end <= cloestStart) {
                // 没有相交重复的情况
                endStartMap.put(end, start);
            } else {
                // 有相交重复的情况
                int minEnd = Math.min(end, cloestEnd);
                int maxStart = Math.max(start, cloestStart);
                duplicateMap.put(minEnd, maxStart);
                endStartMap.put(end, start);
            }
            return true;
        }

        private boolean noDuplication(int start, int end) {
            for (Map.Entry<Integer, Integer> entry : duplicateMap.entrySet()) {
                int currentEnd = entry.getKey();
                int currentStart = entry.getValue();
                if (currentEnd <= start || end <= currentStart) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
