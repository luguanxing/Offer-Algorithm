package leetcode.contest.week376;

import java.util.*;

public class Test100151_使数组成为等数数组的最小代价 {

    public static void main(String[] args) {
        // nums = [1,2,3,4,5]
        System.out.println(new Solution().minimumCost(new int[]{1, 2, 3, 4, 5}));
        // nums = [10,12,13,14,15]
        System.out.println(new Solution().minimumCost(new int[]{10, 12, 13, 14, 15}));
        // nums = [22,33,22,33,22]
        System.out.println(new Solution().minimumCost(new int[]{22, 33, 22, 33, 22}));
        // nums = [101,115,116,120,122]
        System.out.println(new Solution().minimumCost(new int[]{101, 115, 116, 120, 122}));
    }

    static class Solution {
        public long minimumCost(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int median = n % 2 == 0 ? (nums[n / 2 - 1] + nums[n / 2]) / 2 : nums[n / 2];
            // 生成附近的回文数
            TreeSet<Integer> palindromes = generateNearbyPalindromes(median, 10);
            long minCost = Long.MAX_VALUE;
            for (int palindrome : palindromes) {
                long cost = 0;
                for (int num : nums) {
                    cost += Math.abs(num - palindrome);
                }
                minCost = Math.min(minCost, cost);
            }
            return minCost;
        }

        private TreeSet<Integer> generateNearbyPalindromes(int num, int count) {
            // 首先将中位数分解成两部分，然后根据这两部分构造回文数
            TreeSet<Integer> palindromes = new TreeSet<>();
            String numStr = Integer.toString(num);
            int len = numStr.length();
            int halfLen = len / 2;
            long start = Long.parseLong(numStr.substring(0, len - halfLen));
            for (long i = start - count; i <= start + count; i++) {
                try {
                    palindromes.add(createPalindrome(i, len % 2 != 0));
                } catch (NumberFormatException e) {
                    // 忽略数字溢出的回文数
                }
            }

            return palindromes;
        }

        private int createPalindrome(long half, boolean isOdd) {
            String halfStr = Long.toString(half);
            String reverse = new StringBuilder(halfStr).reverse().toString();
            if (isOdd) {
                halfStr = halfStr.substring(0, halfStr.length() - 1);
            }
            return Integer.parseInt(halfStr + reverse);
        }
    }
}
