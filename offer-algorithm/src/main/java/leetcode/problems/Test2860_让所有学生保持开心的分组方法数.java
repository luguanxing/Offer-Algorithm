package leetcode.problems;

import java.util.*;

public class Test2860_让所有学生保持开心的分组方法数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countWays(Arrays.asList(1, 1)));
        System.out.println(new Solution().countWays(Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7)));
    }

    static class Solution {
        public int countWays(List<Integer> nums) {
            Collections.sort(nums);
            int res = 0;
            for (int i = 0; i <= nums.size(); i++) {
                if (isOk(nums, i)) {
                    System.out.println("->" + i);
                    res++;
                }
            }
            return res;
        }

        private boolean isOk(List<Integer> nums, int k) {
            // 选前k个，要求对于前k个数有k>nums[i]，对于后面的数有k<nums[i]
            if (k == 0) {
                if (k < nums.get(k)) {
                    return true;
                } else {
                    return false;
                }
            }
            if (k == nums.size()) {
                if (k > nums.get(k - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            if (k > nums.get(k - 1) && k < nums.get(k)) {
                return true;
            }
            return false;
        }
    }

}
