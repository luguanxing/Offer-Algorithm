package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test2488_统计中位数为K的子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(new int[]{1}, 1));
        System.out.println(new Solution().countSubarrays(new int[]{1, 2, 3}, 1));
        System.out.println(new Solution().countSubarrays(new int[]{1, 2, 3}, 2));
        System.out.println(new Solution().countSubarrays(new int[]{3, 2, 1, 4, 5}, 4));
        System.out.println(new Solution().countSubarrays(new int[]{2, 3, 1}, 3));
        System.out.println(new Solution().countSubarrays(new int[]{5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14}, 6));
    }

    static class Solution {
        public int countSubarrays(int[] nums, int k) {
            // 找出k的下标
            int kIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == k) {
                    kIndex = i;
                }
            }
            // 计算大于k个数的前缀和，只存kIndex前的
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int cnt = 0;
            for (int i = 0; i < kIndex; i++) {
                int num = nums[i];
                if (num > k) {
                    cnt++;
                } else if (num < k) {
                    cnt--;
                }
                map.put(cnt, map.getOrDefault(cnt, 0) + 1);
            }
            // 计算kIndex后的结果，跨过kIndex后计数相同，或者多一个大于k的个数
            int res = 0;
            for (int i = kIndex; i < nums.length; i++) {
                int num = nums[i];
                if (num > k) {
                    cnt++;
                } else if (num < k) {
                    cnt--;
                }
                res += map.getOrDefault(cnt - 1, 0);
                res += map.getOrDefault(cnt, 0);
            }
            return res;
        }
    }

}
