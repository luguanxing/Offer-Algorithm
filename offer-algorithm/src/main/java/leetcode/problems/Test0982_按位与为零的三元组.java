package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0982_按位与为零的三元组 {

    public static void main(String[] args) {
        System.out.println(new Solution().countTriplets(new int[]{2, 1, 3}));
        System.out.println(new Solution().countTriplets(new int[]{0, 0, 0}));
    }

    static class Solution {
        public int countTriplets(int[] nums) {
            // 先计算两两与结果和对应的计数，两两长度不超过2^16，结果数也不会超过2^16
            Map<Integer, Integer> andCntMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    int and = nums[i] & nums[j];
                    andCntMap.put(and, andCntMap.getOrDefault(and, 0) + 1);
                }
            }
            // 枚举两两与的结果和数组，不会超过2^16 * N
            int res = 0;
            for (int and : andCntMap.keySet()) {
                int cnt = andCntMap.get(and);
                for (int num : nums) {
                    if ((and & num) == 0) {
                        res += cnt;
                    }
                }
            }
            return res;
        }
    }

}
