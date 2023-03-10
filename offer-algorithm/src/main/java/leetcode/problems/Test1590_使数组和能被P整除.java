package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test1590_使数组和能被P整除 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSubarray(
                new int[]{3, 1, 4, 2}, 6
        ));
        System.out.println(new Solution().minSubarray(
                new int[]{6, 3, 5, 2}, 9
        ));
        System.out.println(new Solution().minSubarray(
                new int[]{1, 2, 3}, 3
        ));
        System.out.println(new Solution().minSubarray(
                new int[]{1, 2, 3}, 7
        ));
        System.out.println(new Solution().minSubarray(
                new int[]{1000000000, 1000000000, 1000000000}, 3
        ));
        System.out.println(new Solution().minSubarray(
                new int[]{4, 4, 2}, 7
        ));
        System.out.println(new Solution().minSubarray(
                new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148
        ));
    }

    static class Solution {
        public int minSubarray(int[] nums, int p) {
            int remainder = 0;
            for (int num : nums) {
                remainder = (remainder + num) % p;
            }
            if (remainder == 0) {
                return 0;
            }
            int len = nums.length;
            Map<Integer, Integer> index = new HashMap<>();
            int res = len;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                index.put(sum, i);
                sum = sum + nums[i];
                sum %= p;
                int check = (sum - remainder + p) % p;
                if (index.containsKey(check)) {
                    res = Math.min(res, i - index.get(check) + 1);
                }
            }
            return res == len ? -1 : res;
        }
    }

    static class Solution_两遍 {
        public int minSubarray(int[] nums, int p) {
            int r1 = check(nums, p);
            int[] nums2 = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nums2[i] = nums[nums.length - 1 - i];
            }
            int r2 = check(nums2, p);
            return Math.min(r1, r2) == Integer.MAX_VALUE ? -1 : Math.min(r1, r2);
        }

        private int check(int[] nums, int p) {
            long total = 0;
            for (int num : nums) {
                total += num;
            }
            int remainder = (int) (total % p);
            if (remainder == 0) {
                return 0;
            }
            Map<Long, Integer> remainderIndexMap = new TreeMap<>();
            int len = nums.length;
            long sum = 0;
            int res = len;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                sum %= p;

                long check = sum - remainder;
                check = check < 0 ? check + p : check;
                if (remainderIndexMap.containsKey(check)) {
                    res = Math.min(res, i - remainderIndexMap.get(check));
                }
                remainderIndexMap.put(sum, i);
            }
            return res == len ? Integer.MAX_VALUE : res;
        }
    }

}
