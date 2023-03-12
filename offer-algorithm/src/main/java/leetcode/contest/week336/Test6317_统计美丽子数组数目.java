package leetcode.contest.week336;

import java.util.HashMap;
import java.util.Map;

public class Test6317_统计美丽子数组数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulSubarrays(new int[]{4, 3, 1, 2, 4}));
        System.out.println(new Solution().beautifulSubarrays(new int[]{1, 10, 4}));
    }

    static class Solution {
        public long beautifulSubarrays(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            long res = 0;
            int xor = 0;
            for (int i = 0; i < n; i++) {
                xor ^= nums[i];
                res += map.getOrDefault(xor, 0);
                map.put(xor, map.getOrDefault(xor, 0) + 1);
            }
            return res;
        }
    }

}
