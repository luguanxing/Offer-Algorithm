package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test3719_最长平衡子数组I {

    public static void main(String[] args) {
        // nums = [2,5,4,3]
        System.out.println(new Solution().longestBalanced(new int[]{2, 5, 4, 3}));
        // nums = [3,2,2,5,4]
        System.out.println(new Solution().longestBalanced(new int[]{3, 2, 2, 5, 4}));
        // nums = [1,2,3,2]
        System.out.println(new Solution().longestBalanced(new int[]{1, 2, 3, 2}));
        // nums = [10,6,10,7]
        System.out.println(new Solution().longestBalanced(new int[]{10, 6, 10, 7}));
    }

    static class Solution {
        public int longestBalanced(int[] nums) {
            int len = nums.length;
            // 循环找前缀和差相同的最长的子数组
            int maxLen = 0;
            for (int i = 0; i < len; i++) {
                int countEven = 0;
                int countOdd = 0;
                Set<Integer> evenSet = new HashSet<>();
                Set<Integer> oddSet = new HashSet<>();
                for (int j = i; j < len; j++) {
                    if (nums[j] % 2 == 0 && !evenSet.contains(nums[j])) {
                        countEven++;
                        evenSet.add(nums[j]);
                    } else if (nums[j] % 2 != 0 && !oddSet.contains(nums[j])) {
                        countOdd++;
                        oddSet.add(nums[j]);
                    }
                    if (countEven == countOdd) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }
            return  maxLen;
        }
    }

}
