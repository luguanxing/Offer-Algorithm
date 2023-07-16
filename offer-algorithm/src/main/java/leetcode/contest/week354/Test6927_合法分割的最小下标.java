package leetcode.contest.week354;

import java.util.*;

public class Test6927_合法分割的最小下标 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumIndex(Arrays.asList(1, 2, 2, 2)));
        System.out.println(new Solution().minimumIndex(Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));
        System.out.println(new Solution().minimumIndex(Arrays.asList(3, 3, 3, 3, 7, 2, 2)));
    }

    static class Solution {
        public int minimumIndex(List<Integer> nums) {
            int n = nums.size();
            Map<Integer, Integer> cntMap = new HashMap<>();
            // 先统计总频率
            int maxCount = 0;
            int dominant = -1;
            for (int num : nums) {
                cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
                if (cntMap.get(num) > maxCount) {
                    maxCount = cntMap.get(num);
                    dominant = num;
                }
            }
            // 对当前dominant的位置情况逐个判断
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                if (nums.get(i) == dominant) {
                    count++;
                }
                if (count * 2 > i + 1 && (maxCount - count) * 2 > n - i - 1) {
                    return i;
                }
            }
            return -1;
        }
    }

}
