package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test1814_统计一个数组中好对子的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println(new Solution().countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }

    static class Solution {
        public int countNicePairs(int[] nums) {
            int MOD = 1000000007;
            int len = nums.length;
            int[] rNums = new int[len];
            for (int i = 0; i < len; i++) {
                rNums[i] = reverse(nums[i]);
            }
            // 由原等式nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
            // 转换为相同下标等式nums[i] - rev(nums[i]) ==  nums[j] - rev(nums[j])
            // 则可变成求相同差的对数和
            Map<Integer, Integer> diffMap = new HashMap<>();
            long res = 0;
            for (int i = 0; i < len; i++) {
                int diff = nums[i] - rNums[i];
                diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
            }
            for (int cnt : diffMap.values()) {
                res += (long) cnt * (cnt - 1) / 2;
                res %= MOD;
            }
            return (int) res;
        }

        private int reverse(int num) {
            String rNumStr = new StringBuilder(String.valueOf(num)).reverse().toString();
            return Integer.parseInt(rNumStr);
        }
    }

}
