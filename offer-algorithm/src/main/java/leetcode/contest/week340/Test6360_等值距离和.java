package leetcode.contest.week340;

import java.util.*;

public class Test6360_等值距离和 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().distance(new int[]{1, 3, 1, 1, 2})));
        System.out.println(Arrays.toString(new Solution().distance(new int[]{0, 5, 3})));
    }

    static class Solution {
        public long[] distance(int[] nums) {
            int len = nums.length;
            Map<Integer, List<Integer>> indexMap = new HashMap<>();
            Map<Integer, List<Long>> sumMap = new HashMap<>();
            Map<Integer, Integer> indexOfNumMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                List<Integer> list = indexMap.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                indexMap.put(nums[i], list);
                indexOfNumMap.put(nums[i], 0);
            }
            for (int k : indexMap.keySet()) {
                List<Integer> indexs = indexMap.get(k);
                List<Long> indexSum = new ArrayList<>();
                indexSum.add(0L);
                for (int i = 0; i < indexs.size(); i++) {
                    indexSum.add(indexs.get(i) + indexSum.get(i));
                }
                sumMap.put(k, indexSum);
            }
            long[] res = new long[len];
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                List<Integer> indexs = indexMap.get(num);
                if (indexs.size() == 1) {
                    res[i] = 0;
                    continue;
                }
                int cntOfNum = indexOfNumMap.get(num);
                indexOfNumMap.put(num, cntOfNum + 1);
                List<Long> sums = sumMap.get(num);
                int index = indexs.get(cntOfNum);
                long r = 0;
                // 前部分
                r += (long) index * cntOfNum - sums.get(cntOfNum);
                // 后部分
                r += sums.get(sums.size()-1) - sums.get(cntOfNum) - (long) index * (indexs.size()-cntOfNum);
                res[i] = r;
            }
            return res;
        }
    }

}
