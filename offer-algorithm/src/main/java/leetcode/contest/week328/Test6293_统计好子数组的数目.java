package leetcode.contest.week328;

import java.util.HashMap;
import java.util.Map;

public class Test6293_统计好子数组的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countGood(new int[]{1, 1, 1, 1, 1}, 10));
        System.out.println(new Solution().countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
        System.out.println(new Solution().countGood(new int[]{3, 4, 4, 3, 2, 2, 4}, 2));
        System.out.println(new Solution().countGood(new int[]{3, 1, 4, 4, 2, 2, 4}, 2));
        System.out.println(new Solution().countGood(new int[]{2, 3, 1, 3, 2, 3, 3, 3, 1, 1, 3, 2, 2, 2}, 18));
    }

    static class Solution {
        public long countGood(int[] nums, int k) {
            int len = nums.length;
            long res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int l = 0, r = 0, cnt = 0;
            // 滑动窗口左右指针维护计数的同时，还通过右侧计算了子数组的长度
            // 扩展右边界，计数多map[nums[r]]组
            while (r < len) {
                cnt += map.getOrDefault(nums[r], 0);
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                r++;
                // 如果满足条件，则从[l,r]至[l,len]的均符合条件，答案加上len - r + 1
                // 同时尝试收缩左边界，计数少map[nums[l]]组，
                while (cnt >= k) {
                    res += len - r + 1;
                    map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                    cnt -= map.get(nums[l]);
                    l++;
                }
            }
            return res;
        }
    }

}
