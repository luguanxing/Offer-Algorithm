package leetcode.contest.week337;

import java.util.*;

public class Test6321_执行操作后的最大MEX {

    public static void main(String[] args) {
        System.out.println(new Solution().findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));
        System.out.println(new Solution().findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7));
    }

    static class Solution {
        public int findSmallestInteger(int[] nums, int value) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int mod = num % value;
                if (mod < 0) {
                    mod += value;
                }
                map.put(mod, map.getOrDefault(mod, 0) + 1);
            }

            int idx = 0;
            while (map.containsKey(idx % value)) {
                map.put(idx % value, map.get(idx % value) - 1);
                if (map.get(idx % value) == 0) {
                    map.remove(idx % value);
                }
                idx++;
            }

            return idx;
        }
    }

}
