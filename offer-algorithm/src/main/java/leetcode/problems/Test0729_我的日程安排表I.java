package leetcode.problems;

import java.util.Map;
import java.util.TreeMap;

public class Test0729_我的日程安排表I {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
        System.out.println(myCalendar.book(20, 30)); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
    }

    static class MyCalendar {
        TreeMap<Integer, Integer> endStartMap;

        public MyCalendar() {
            endStartMap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            // 找出end和当前start最接近的下个区间，并比较这个区间start和当前end是否重叠即可
            Map.Entry<Integer, Integer> cloestEntry = endStartMap.higherEntry(start);
            if (cloestEntry == null) {
                endStartMap.put(end, start);
                return true;
            }
            int cloestEnd = cloestEntry.getKey();
            int cloestStart = cloestEntry.getValue();
            if (end <= cloestStart) {
                endStartMap.put(end, start);
                return true;
            }
            return false;
        }
    }

}
