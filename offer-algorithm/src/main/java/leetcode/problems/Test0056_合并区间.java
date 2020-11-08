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
    }

    static class Solution {
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
