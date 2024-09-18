package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test2332_坐上公交的最晚时间 {

    public static void main(String[] args) {
        // buses = [10,20], passengers = [2,17,18,19], capacity = 2
        System.out.println(new Solution().latestTimeCatchTheBus(new int[]{10, 20}, new int[]{2, 17, 18, 19}, 2));
        // buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
        System.out.println(new Solution().latestTimeCatchTheBus(new int[]{20, 30, 10}, new int[]{19, 13, 26, 4, 25, 11, 21}, 2));
        System.out.println(new Solution().latestTimeCatchTheBus(new int[]{3}, new int[]{2, 4}, 2));
        System.out.println(new Solution().latestTimeCatchTheBus(new int[]{2}, new int[]{2}, 2));
        System.out.println(new Solution().latestTimeCatchTheBus(new int[]{2, 3}, new int[]{3, 2}, 2));
    }

    static class Solution {
        public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
            // 先排序
            Arrays.sort(buses);
            Arrays.sort(passengers);
            // 按贪心匹配公车和乘客
            TreeMap<Integer, TreeSet<Integer>> busPassengerMap = new TreeMap<>();
            int passengerIndex = 0;
            for (int bus = 0; bus < buses.length; bus++) {
                int leaveTime = buses[bus];
                TreeSet<Integer> busPassengers = new TreeSet<>();
                for (int i = 0; i < capacity; i++) {
                    if (passengerIndex < passengers.length && passengers[passengerIndex] <= leaveTime) {
                        busPassengers.add(passengers[passengerIndex]);
                        passengerIndex++;
                    } else {
                        break;
                    }
                }
                busPassengerMap.put(bus, busPassengers);
            }
            // 从最后一个公车开始找位置
            TreeSet<Integer> lastPassengers = busPassengerMap.lastEntry().getValue();
            Set<Integer> allPassenegers = Arrays.stream(passengers).boxed().collect(Collectors.toSet());
            int res;
            if (lastPassengers.size() < capacity) {
                // 未满员，找最大位置
                res = buses[buses.length - 1];
            } else {
                // 已满员，要抢位
                res = lastPassengers.last() - 1;
            }
            while (allPassenegers.contains(res)) {
                res = res - 1;
            }
            return res;
        }
    }

}
