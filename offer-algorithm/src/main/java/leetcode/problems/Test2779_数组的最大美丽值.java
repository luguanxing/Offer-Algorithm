package leetcode.problems;

import java.util.*;

public class Test2779_数组的最大美丽值 {

    public static void main(String[] args) {
        // nums = [4,6,1,2], k = 2
        System.out.println(new Solution().maximumBeauty(new int[]{4, 6, 1, 2}, 2));
        // nums = [1,1,1,1], k = 10
        System.out.println(new Solution().maximumBeauty(new int[]{1, 1, 1, 1}, 10));
        System.out.println(new Solution().maximumBeauty(new int[]{48, 93, 96, 19}, 24));
    }

    static class Solution {
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);
            // 生成大小的范围的差分
            int len = nums.length;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < len; i++) {
                map.put(nums[i] - k, map.getOrDefault(nums[i] - k, 0) + 1);
                map.put(nums[i] + k + 1, map.getOrDefault(nums[i] + k + 1, 0) - 1);
            }
            // 统计最多重叠的个数
            int res = 0;
            int currentCnt = 0;
            for (int cnt : map.values()) {
                currentCnt += cnt;
                res = Math.max(res, currentCnt);
            }
            return res;
        }
    }


}
