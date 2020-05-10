package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test0001_两数之和 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 5, 7, 11, 15}, 9)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) {
                return null;
            }
            // Map记录对应数值和序号
            Map<Integer, Integer> numIndex = new HashMap<>();
            for (int index = 0; index < nums.length; index++) {
                int num = nums[index];
                if (numIndex.containsKey(target - num)) {
                    return new int[]{numIndex.get(target - num), index};
                } else {
                    numIndex.put(nums[index], index);
                }
            }
            return null;
        }
    }

    static class Solution_暴力 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) {
                return null;
            }
            // 暴力搜索
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

}
