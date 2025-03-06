package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test2588_统计美丽子数组数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulSubarrays(new int[]{4, 3, 1, 2, 4}));
        System.out.println(new Solution().beautifulSubarrays(new int[]{1, 10, 4}));
    }

    static class Solution {
        public long beautifulSubarrays(int[] nums) {
            Map<Integer, Integer> xorMap = new HashMap<>();
            xorMap.put(0, 1);
            long res = 0;
            int current = 0;
            for (int num : nums) {
                current ^= num;
                int cnt = xorMap.getOrDefault(current, 0);
                res += cnt;
                xorMap.put(current, cnt + 1);
            }
            return res;
        }
    }

}
