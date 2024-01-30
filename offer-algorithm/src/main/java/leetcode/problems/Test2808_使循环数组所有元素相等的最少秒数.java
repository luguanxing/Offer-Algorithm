package leetcode.problems;

import java.util.*;

public class Test2808_使循环数组所有元素相等的最少秒数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSeconds(Arrays.asList(1, 2, 1, 2)));
        System.out.println(new Solution().minimumSeconds(Arrays.asList(2, 1, 3, 3, 2)));
        System.out.println(new Solution().minimumSeconds(Arrays.asList(5, 5, 5, 5)));
        System.out.println(new Solution().minimumSeconds(Arrays.asList(8, 8, 9, 10, 9)));
        System.out.println(new Solution().minimumSeconds(Arrays.asList(1, 11, 11, 11, 19, 12, 8, 7, 19)));
    }

    static class Solution {
        public int minimumSeconds(List<Integer> nums) {
            int len = nums.size();
            // 记录每个数的序号
            Map<Integer, List<Integer>> indexMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int num = nums.get(i);
                List<Integer> indexList = indexMap.getOrDefault(num, new ArrayList<>());
                indexList.add(i);
                indexMap.put(num, indexList);
            }
            // 求出最大间隔
            int minTime = Integer.MAX_VALUE;
            for (int num : indexMap.keySet()) {
                List<Integer> list = indexMap.get(num);
                // 头尾相连的时间
                int time = (len - list.get(list.size() - 1) + list.get(0) - 0) / 2;
                // 中间相连的时间
                for (int i = 0; i < list.size() - 1; i++) {
                    int nextIndex = list.get(i + 1);
                    int curIndex = list.get(i);
                    time = Math.max(time, (nextIndex - curIndex) / 2);
                }
                minTime = Math.min(minTime, time);
            }
            return minTime;
        }
    }

}
