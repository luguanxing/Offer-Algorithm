package leetcode.problems;

import java.util.*;

public class Test0826_安排工作以达到最大收益 {

    public static void main(String[] args) {
        // difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
        System.out.println(new Solution().maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}));
        // difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
        System.out.println(new Solution().maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25}));
    }

    static class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            // 先将难度从小到大排序
            int[][] jobs = new int[difficulty.length][2];
            for (int i = 0; i < difficulty.length; i++) {
                jobs[i][0] = difficulty[i];
                jobs[i][1] = profit[i];
            }
            Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
            // 使用Map存储某个难度下的最大盈利
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int maxDifficulty = 0;
            int maxProfit = 0;
            treeMap.put(maxDifficulty, maxProfit);
            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][1] > maxProfit) {
                    maxProfit = jobs[i][1];
                }
                treeMap.put(jobs[i][0], maxProfit);
            }
            // 遍历工人，找到最大盈利
            int res = 0;
            for (int w : worker) {
                Integer key = treeMap.floorKey(w);
                if (key != null) {
                    res += treeMap.get(key);
                }
            }
            return res;
        }
    }

}
