package leetcode.contest.week368;

public class Test100114_元素和最小的山形三元组II {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSum(new int[]{8, 6, 1, 5, 3}));
        System.out.println(new Solution().minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
        System.out.println(new Solution().minimumSum(new int[]{6, 5, 4, 3, 4, 5}));

    }

    static class Solution {
        public int minimumSum(int[] nums) {
            int len = nums.length;
            int[] left = new int[len];
            left[0] = Integer.MAX_VALUE;
            for (int i = 1; i < len; i++) {
                left[i] = Math.min(left[i - 1], nums[i - 1]);
            }
            int[] right = new int[len];
            right[len - 1] = Integer.MAX_VALUE;
            for (int i = len - 2; i >= 0; i--) {
                right[i] = Math.min(right[i + 1], nums[i + 1]);
            }
            int sum = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (left[i] < nums[i] && nums[i] > right[i]) {
                    sum = Math.min(sum, nums[i] + left[i] + right[i]);
                }
            }
            return sum == Integer.MAX_VALUE ? -1 : sum;
        }
    }

}
