package leetcode.contest.week327;

import java.util.TreeMap;

public class Test6285_执行K次操作后的最大分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println(new Solution().maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }

    static class Solution {
        public long maxKelements(int[] nums, int k) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            long res = 0;
            for (int i = 1; i <= k; i++) {
                int maxKey = map.lastKey();
                res += maxKey;
                map.put(maxKey, map.get(maxKey) - 1);
                if (map.get(maxKey) == 0) {
                    map.remove(maxKey);
                }
                int newKey = (int) Math.ceil(maxKey * 1.0 / 3);
                map.put(newKey, map.getOrDefault(newKey, 0) + 1);
            }
            return res;
        }
    }

}
