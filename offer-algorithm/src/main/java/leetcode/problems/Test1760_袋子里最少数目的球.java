package leetcode.problems;

import java.util.Arrays;

public class Test1760_袋子里最少数目的球 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSize(new int[]{9}, 2));
        System.out.println(new Solution().minimumSize(new int[]{2, 4, 8, 2}, 4));
        System.out.println(new Solution().minimumSize(new int[]{7, 17}, 2));
    }

    static class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            // 使用二分不断试探出判断袋子球的最多数量的最小值
            int left = 1;
            int right = Arrays.stream(nums).max().getAsInt();
            while (left <= right) {
                int mid = (left + right) / 2;
                int currentOperations = 0;
                for (int num : nums) {
                    currentOperations += (num - 1) / mid;
                }
                if (currentOperations > maxOperations) {
                    // 需要步骤太多，说明每个袋子的球数太少，需要增加
                    left = mid + 1;
                } else {
                    // 需要步骤少一些或相等，尝试再减少每个袋子的球数
                    right = mid - 1;
                }
            }
            return left;
        }
    }

}
