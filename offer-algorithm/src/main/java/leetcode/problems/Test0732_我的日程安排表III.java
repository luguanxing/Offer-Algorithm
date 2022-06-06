package leetcode.problems;

import java.util.TreeMap;
import java.util.TreeSet;

public class Test0732_我的日程安排表III {

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(10, 20)); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        System.out.println(myCalendarThree.book(50, 60)); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        System.out.println(myCalendarThree.book(10, 40)); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        System.out.println(myCalendarThree.book(5, 15)); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        System.out.println(myCalendarThree.book(5, 10)); // 返回 3
        System.out.println(myCalendarThree.book(25, 55)); // 返回 3
    }

    static class MyCalendarThree {
        TreeMap<Integer, Integer> treeMap;

        public MyCalendarThree() {
            treeMap = new TreeMap<>();
        }

        public int book(int start, int end) {
            // 差分数组
            treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
            treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
            int max = 0;
            int currentCnt = 0;
            for (int cnt : treeMap.values()) {
                currentCnt += cnt;
                max = Math.max(max, currentCnt);
            }
            return max;
        }
    }

}
