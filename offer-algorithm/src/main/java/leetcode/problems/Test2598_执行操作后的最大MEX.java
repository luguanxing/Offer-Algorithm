package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test2598_执行操作后的最大MEX {

    public static void main(String[] args) {
        // nums = [1,-10,7,13,6,8], value = 5
        System.out.println(new Solution().findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));
        // nums = [1,-10,7,13,6,8], value = 7
        System.out.println(new Solution().findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7));
        // nums = [[3,0,3,2,4,2,1,1,0,4]], value = 5
        System.out.println(new Solution().findSmallestInteger(new int[]{3, 0, 3, 2, 4, 2, 1, 1, 0, 4}, 5));
    }

    static class Solution {
        public int findSmallestInteger(int[] nums, int value) {
            // 统计每个mod出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int mod = ((num % value) + value) % value;
                map.put(mod, map.getOrDefault(mod, 0) + 1);
            }
            // 找出最小趟数和断点
            int res = 0;
            int times = map.values().stream().min(Integer::compareTo).get();
            if (map.size() != value) {
                times = 0;
            } else {
                res = times * value;
            }
            for (int i = 0; i < value; i++) {
                if (!map.containsKey(i) || map.get(i) == times) {
                    break;
                } else {
                    res++;
                }
            }
            return res;
        }
    }

}
