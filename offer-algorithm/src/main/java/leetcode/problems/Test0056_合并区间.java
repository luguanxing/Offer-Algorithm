package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test0056_合并区间 {

    public static void main(String[] args) {
        for (int[] nums : new Solution().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})) {
            System.out.println(Arrays.toString(nums));
        }
        System.out.println();
        for (int[] nums : new Solution().merge(new int[][]{{1, 4}, {4, 5}})) {
            System.out.println(Arrays.toString(nums));
        }
        System.out.println();
        for (int[] nums : new Solution().merge(new int[][]{{1, 4}, {2, 3}})) {
            System.out.println(Arrays.toString(nums));
        }
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            // 排序:先按start小的在前，再end小的在前排序（否则后面包含前面可能没合并）
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            // 逐段合并
            List<int[]> resList = new ArrayList<>();
            int currentStart = intervals[0][0];
            int currentEnd = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
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

    static class Solution2 {
        public int[][] merge(int[][] intervals) {
            // 排序:先start小的在前，再按end小的在前排序
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            // 逐段合并
            List<int[]> resList = new ArrayList<>();
            int currentStart = intervals[0][0];
            int currentEnd = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                int start = interval[0];
                int end = interval[1];
                if (currentEnd < start) {
                    // 另起一段
                    int[] part = new int[2];
                    part[0] = currentStart;
                    part[1] = currentEnd;
                    resList.add(part);
                    currentStart = start;
                    currentEnd = end;
                } else {
                    // 可以合并
                    currentEnd = Math.max(currentEnd, end);
                }
            }
            // 保存最后一段
            int[] endPart = new int[2];
            endPart[0] = currentStart;
            endPart[1] = currentEnd;
            resList.add(endPart);
            // 返回结果
            int[][] res = new int[resList.size()][2];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }

    static class Solution_暴力 {
        public int[][] merge(int[][] intervals) {
            List<List<Integer>> intervalList = Arrays.stream(intervals)
                    .map(Arrays::stream)
                    .map(IntStream::boxed)
                    .map(stream -> stream.collect(Collectors.toList()))
                    .collect(Collectors.toList());
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
            int[][] res = new int[intervalList.size()][2];
            for (int i = 0; i < intervalList.size(); i++) {
                res[i][0] = intervalList.get(i).get(0);
                res[i][1] = intervalList.get(i).get(1);
            }
            return res;
        }
    }

}
