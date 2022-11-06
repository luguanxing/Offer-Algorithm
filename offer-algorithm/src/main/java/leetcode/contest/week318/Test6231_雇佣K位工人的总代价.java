package leetcode.contest.week318;

import java.util.TreeMap;

public class Test6231_雇佣K位工人的总代价 {

    public static void main(String[] args) {
        System.out.println(new Solution().totalCost(
                new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8},
                3, 4
        ));
        System.out.println(new Solution().totalCost(
                new int[]{1, 2, 4, 1},
                3, 3
        ));
    }

    static class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            long totalCost = 0;
            TreeMap<Integer, Integer> leftMap = new TreeMap<>();
            TreeMap<Integer, Integer> rightMap = new TreeMap<>();
            int len = costs.length;
            // init left & right map
            int leftIdx, rightIdx;
            for (leftIdx = 0; leftIdx < candidates; leftIdx++) {
                int cost = costs[leftIdx];
                leftMap.put(cost, leftMap.getOrDefault(cost, 0) + 1);
            }
            for (rightIdx = len - 1; rightIdx >= leftIdx && len - rightIdx <= candidates; rightIdx--) {
                int cost = costs[rightIdx];
                rightMap.put(cost, rightMap.getOrDefault(cost, 0) + 1);
            }
            // greedy choice
            for (int i = 1; i <= k; i++) {
                int leftMin = Integer.MAX_VALUE;
                if (!leftMap.isEmpty() && leftMap.firstKey() != null) {
                    leftMin = leftMap.firstKey();
                }
                int rightMin = Integer.MAX_VALUE;
                if (!rightMap.isEmpty() && rightMap.firstKey() != null) {
                    rightMin = rightMap.firstKey();
                }
                if (leftMin <= rightMin) {
                    totalCost += leftMin;
                    leftMap.put(leftMin, leftMap.get(leftMin) - 1);
                    if (leftMap.get(leftMin) == 0) {
                        leftMap.remove(leftMin);
                    }
                    if (leftIdx <= rightIdx) {
                        int cost = costs[leftIdx];
                        leftMap.put(cost, leftMap.getOrDefault(cost, 0) + 1);
                        leftIdx++;
                    }
                } else {
                    totalCost += rightMin;
                    rightMap.put(rightMin, rightMap.get(rightMin) - 1);
                    if (rightMap.get(rightMin) == 0) {
                        rightMap.remove(rightMin);
                    }
                    if (rightIdx >= leftIdx) {
                        int cost = costs[rightIdx];
                        rightMap.put(cost, rightMap.getOrDefault(cost, 0) + 1);
                        rightIdx--;
                    }
                }
            }
            return totalCost;
        }
    }

}
