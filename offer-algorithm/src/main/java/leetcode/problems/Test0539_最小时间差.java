package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test0539_最小时间差 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMinDifference(Arrays.asList("23:59", "00:00")));
        System.out.println(new Solution().findMinDifference(Arrays.asList("00:00", "23:59", "00:00")));
    }

    static class Solution {
        public int findMinDifference(List<String> timePoints) {
            List<Integer> list = new ArrayList<>();
            for (String timePoint : timePoints) {
                list.add(parse(timePoint));
                list.add(parse(timePoint) + 24 * 60);
            }
            Collections.sort(list);
            int min = 24 * 60;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min, list.get(i) - list.get(i - 1));
            }
            return min;
        }

        private int parse(String timePoint) {
            int hour = Integer.parseInt(timePoint.split(":")[0]);
            int minute = Integer.parseInt(timePoint.split(":")[1]);
            return hour * 60 + minute;
        }
    }

}
