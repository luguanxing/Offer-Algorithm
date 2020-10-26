package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1365_有多少小于当前数字的数字 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(
                new int[]{8, 1, 2, 2, 3}
        )));
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(
                new int[]{6, 5, 4, 8}
        )));
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(
                new int[]{7, 7, 7, 7}
        )));
    }

    static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] sortNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sortNums);
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < sortNums.length; i++) {
                int num = sortNums[i];
                if (!indexMap.containsKey(num)) {
                    indexMap.put(num, i);
                }
            }
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = indexMap.getOrDefault(nums[i], 0);
            }
            return res;
        }
    }

    static class Solution_暴力 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int cnt = 0;
                for (int n : nums) {
                    if (n < num) {
                        cnt++;
                    }
                }
                res[i] = cnt;
            }
            return res;
        }
    }

}
