package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Test0436_寻找右区间 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRightInterval(new int[][]{{1, 2}})));
        System.out.println(Arrays.toString(new Solution().findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
        System.out.println(Arrays.toString(new Solution().findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
    }

    static class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int len = intervals.length;
            TreeMap<Integer, int[]> intervalMap = new TreeMap<>();
            HashMap<int[], Integer> indexMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int[] interval = intervals[i];
                int start = interval[0];
                int end = interval[1];
                intervalMap.put(start, interval);
                indexMap.put(interval, i);
            }
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                int[] interval = intervals[i];
                int start = interval[0];
                int end = interval[1];
                if (intervalMap.containsKey(end)) {
                    int[] rightInterval = intervalMap.get(end);
                    int index = indexMap.get(rightInterval);
                    res[i] = index;
                } else if (intervalMap.higherKey(end) != null) {
                    int[] rightInterval = intervalMap.higherEntry(end).getValue();
                    int index = indexMap.get(rightInterval);
                    res[i] = index;
                } else {
                    res[i] = -1;
                }
            }
            return res;
        }
    }

}
