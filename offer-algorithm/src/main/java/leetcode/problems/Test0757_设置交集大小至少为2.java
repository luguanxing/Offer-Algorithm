package leetcode.problems;

import java.util.Arrays;
import java.util.TreeSet;

public class Test0757_设置交集大小至少为2 {

    public static void main(String[] args) {
        System.out.println(new Solution().intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        System.out.println(new Solution().intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}}));
        System.out.println(new Solution().intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {5, 7}, {7, 8}}));
        System.out.println(new Solution().intersectionSizeTwo(new int[][]{{3, 13}, {2, 8}, {5, 10}}));
    }

    static class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            // 按起始点排序
            Arrays.sort(intervals, (interval1, interval2) -> {
                int start1 = interval1[0];
                int end1 = interval1[1];
                int start2 = interval2[0];
                int end2 = interval2[1];
                if (end1 != end2) {
                    return Integer.compare(end1, end2);
                }
                return Integer.compare(start2, start1);
            });
            // 看最后两个点能否覆盖该区间，不能就至少加上区间后两个点
            TreeSet<Integer> set = new TreeSet<>();
            set.add(intervals[0][intervals[0].length - 1]);
            set.add(intervals[0][intervals[0].length - 1] - 1);
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                int last1 = set.pollLast();
                int last2 = set.pollLast();
                set.add(last1);
                set.add(last2);
                if (start <= last2 && last2 <= end) {
                    continue;
                }
                if (start <= last1 && last1 <= end) {
                    if (set.contains(end)) {
                        set.add(end - 1);
                    } else {
                        set.add(end);
                    }
                    continue;
                }
                set.add(end - 1);
                set.add(end);
            }
            return set.size();
        }
    }

}
