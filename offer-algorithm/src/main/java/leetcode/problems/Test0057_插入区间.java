package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test0057_插入区间 {

    public static void main(String[] args) {
        for (int[] nums : new Solution2().insert(
                new int[][]{{1, 3}, {6, 9}},
                new int[]{2, 5}
        )) {
            System.out.println(Arrays.toString(nums));
        }
        System.out.println();
        for (int[] nums : new Solution2().insert(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                new int[]{4, 8}
        )) {
            System.out.println(Arrays.toString(nums));
        }
    }

    static class Solution2 {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int len = intervals.length;
            int[][] intervalsFull = new int[len + 1][];
            for (int i = 0; i < len; i++) {
                intervalsFull[i] = intervals[i];
            }
            intervalsFull[len] = newInterval;
            // 排序:先按start小的在前，再end小的在前排序（否则后面包含前面可能没合并）
            Arrays.sort(intervalsFull, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            // 逐段合并
            List<int[]> resList = new ArrayList<>();
            int currentStart = intervalsFull[0][0];
            int currentEnd = intervalsFull[0][1];
            for (int i = 1; i <= len; i++) {
                int[] interval = intervalsFull[i];
                int start = interval[0];
                int end = interval[1];
                if (start <= currentEnd) {
                    // 合成一块
                    currentEnd = Math.max(currentEnd, end);
                } else {
                    // 不能合成一块
                    resList.add(new int[]{currentStart, currentEnd});
                    currentStart = start;
                    currentEnd = end;
                }
            }
            resList.add(new int[]{currentStart, currentEnd});
            // 返回结果
            int[][] res = new int[resList.size()][2];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<List<Integer>> intervalList = Arrays.stream(intervals)
                    .map(Arrays::stream)
                    .map(IntStream::boxed)
                    .map(stream -> stream.collect(Collectors.toList()))
                    .collect(Collectors.toList());
            List<Integer> newIntervalList = new ArrayList<>();
            newIntervalList.add(newInterval[0]);
            newIntervalList.add(newInterval[1]);
            intervalList.add(newIntervalList);
            while (true) {
                boolean noMoreCanMerge = true;
                for (int i = 0; i < intervalList.size() && noMoreCanMerge; i++) {
                    for (int j = i + 1; j < intervalList.size() && noMoreCanMerge; j++) {
                        List<Integer> interval1 = intervalList.get(i);
                        List<Integer> interval2 = intervalList.get(j);
                        int s1 = interval1.get(0);
                        int e1 = interval1.get(1);
                        int s2 = interval2.get(0);
                        int e2 = interval2.get(1);
                        if ((s2 <= e1 && e1 <= e2) || (s1 <= e2 && e2 <= e1)) {
                            noMoreCanMerge = false;
                            int s = Math.min(s1, s2);
                            int e = Math.max(e1, e2);
                            List<Integer> interval = new ArrayList<>();
                            interval.add(s);
                            interval.add(e);
                            intervalList.remove(interval1);
                            intervalList.remove(interval2);
                            intervalList.add(interval);
                            break;
                        }
                    }
                }
                if (noMoreCanMerge) {
                    break;
                }
            }
            intervalList.sort(Comparator.comparingInt(o -> o.get(0)));
            int[][] res = new int[intervalList.size()][2];
            for (int i = 0; i < intervalList.size(); i++) {
                res[i][0] = intervalList.get(i).get(0);
                res[i][1] = intervalList.get(i).get(1);
            }
            return res;
        }
    }

}
