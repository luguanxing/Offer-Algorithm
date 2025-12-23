package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Test2054_两个最好的不重叠活动 {

    public static void main(String[] args) {
        // events = [[1,3,2],[4,5,2],[2,4,3]]
        System.out.println(new Solution().maxTwoEvents(new int[][]{
                {1, 3, 2},
                {4, 5, 2},
                {2, 4, 3}
        }));
        // events = [[1,3,2],[4,5,2],[1,5,5]]
        System.out.println(new Solution().maxTwoEvents(new int[][]{
                {1, 3, 2},
                {4, 5, 2},
                {1, 5, 5}
        }));
        // events = [[1,5,3],[1,5,1],[6,6,5]]
        System.out.println(new Solution().maxTwoEvents(new int[][]{
                {1, 5, 3},
                {1, 5, 1},
                {6, 6, 5}
        }));
        // events = [[10,83,53],[63,87,45],[97,100,32],[51,61,16]]
        System.out.println(new Solution().maxTwoEvents(new int[][]{
                {10, 83, 53},
                {63, 87, 45},
                {97, 100, 32},
                {51, 61, 16}
        }));
        // events = [[66,97,90],[98,98,68],[38,49,63],[91,100,42],[92,100,22],[1,77,50],[64,72,97]]
        System.out.println(new Solution().maxTwoEvents(new int[][]{
                {66, 97, 90},
                {98, 98, 68},
                {38, 49, 63},
                {91, 100, 42},
                {92, 100, 22},
                {1, 77, 50},
                {64, 72, 97}
        }));
    }

    static class Solution {
        public int maxTwoEvents(int[][] events) {
            // 按结束时间排序
            Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
            // 先保留每个节点结束最大价值
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0);
            for (int[] event : events) {
                int end = event[1];
                int value = event[2];
                int lastValue = map.floorEntry(end).getValue();
                map.put(end, Math.max(lastValue, value));
            }
            // 遍历一遍，计算取前面节点的最大值加上当前节点的最大价值
            int maxValue = 0;
            for (int[] event : events) {
                int start = event[0];
                int value = event[2];
                int preValue = map.get(map.floorKey(start - 1));
                maxValue = Math.max(maxValue, preValue + value);
            }
            return maxValue;
        }
    }

}
