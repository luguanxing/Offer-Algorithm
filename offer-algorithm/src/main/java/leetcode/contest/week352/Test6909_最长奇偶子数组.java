package leetcode.contest.week352;

public class Test6909_最长奇偶子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{3, 2, 5, 4}, 5));
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{1, 2}, 2));
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{2, 3, 4, 5}, 4));
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{1}, 1));
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{4}, 1));
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{4}, 5));
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{1, 3}, 16));
        System.out.println(new Solution().longestAlternatingSubarray(new int[]{1, 6}, 2));
    }

    static class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            if (nums.length == 1) {
                if (nums[0] % 2 == 1) {
                    return 0;
                } else {
                    return nums[0] <= threshold ? 1 : 0;
                }
            }
            int len = nums.length;
            int max = 0;
            for (int num : nums) {
                if (num % 2 == 0 && num <= threshold) {
                    max = 1;
                }
            }
            for (int l = 0; l < len; l++) {
                for (int r = l + 1; r < len; r++) {
                    if (isOk(nums, l, r, threshold)) {
                        max = Math.max(max, r - l + 1);
                    }
                }
            }
            return max;
        }

        private boolean isOk(int[] nums, int l, int r, int threshold) {
            if (nums[l] % 2 != 0) {
                return false;
            }
            for (int i = l; i <= r; i++) {
                if (nums[i] > threshold) {
                    return false;
                }
            }
            for (int i = l; i <= r - 1; i++) {
                if (nums[i] % 2 == nums[i + 1] % 2) {
                    return false;
                }
            }
            return true;
        }
    }

}
