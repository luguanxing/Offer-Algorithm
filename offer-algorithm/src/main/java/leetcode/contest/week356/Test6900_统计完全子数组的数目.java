package leetcode.contest.week356;

import java.util.HashMap;
import java.util.Map;

public class Test6900_统计完全子数组的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));
        System.out.println(new Solution().countCompleteSubarrays(new int[]{5, 5, 5, 5}));
    }

    static class Solution {
        public int countCompleteSubarrays(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // 滑动窗口
            int len = nums.length;
            int l = 0, r = 0;
            int res = 0;
            Map<Integer, Integer> currentMap = new HashMap<>();
            while (r < len) {
                currentMap.put(nums[r], currentMap.getOrDefault(nums[r], 0) + 1);
                while (currentMap.size() == map.size()) {
                    res += len - r;
                    currentMap.put(nums[l], currentMap.get(nums[l]) - 1);
                    if (currentMap.get(nums[l]) == 0) {
                        currentMap.remove(nums[l]);
                    }
                    l++;
                }
                r++;
            }
            return res;
        }
    }

}
