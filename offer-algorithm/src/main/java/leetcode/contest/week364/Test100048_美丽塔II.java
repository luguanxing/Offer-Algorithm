package leetcode.contest.week364;

import java.util.*;

public class Test100048_美丽塔II {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7)));
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3)));
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(1000000000, 1000000000, 1000000000)));
    }

    static class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int n = maxHeights.size();
            long[] leftSum = new long[n];
            long[] rightSum = new long[n];

            TreeMap<Long, Long> treeMap = new TreeMap<>();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                long num = maxHeights.get(i);
                int popCnt = 0;
                while (!treeMap.isEmpty() && num < treeMap.lastKey()) {
                    sum -= treeMap.lastKey() * treeMap.get(treeMap.lastKey());
                    popCnt += treeMap.get(treeMap.lastKey());
                    treeMap.remove(treeMap.lastKey());
                }
                treeMap.put(num, treeMap.getOrDefault(num, 0L) + 1 + popCnt);
                sum += num * (1 + popCnt);
                leftSum[i] = sum;
            }

            treeMap.clear();
            sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                long num = maxHeights.get(i);
                int popCnt = 0;
                while (!treeMap.isEmpty() && num < treeMap.lastKey()) {
                    sum -= treeMap.lastKey() * treeMap.get(treeMap.lastKey());
                    popCnt += treeMap.get(treeMap.lastKey());
                    treeMap.remove(treeMap.lastKey());
                }
                treeMap.put(num, treeMap.getOrDefault(num, 0L) + 1 + popCnt);
                sum += num * (1 + popCnt);
                rightSum[i] = sum;
            }

            long maxSum = 0;
            for (int i = 0; i < n; i++) {
                sum = leftSum[i];
                if (i < n - 1) {
                    sum += rightSum[i + 1];
                }
                maxSum = Math.max(maxSum, sum);
            }

            return maxSum;
        }
    }


}
