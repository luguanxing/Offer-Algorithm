package leetcode.contest.week368;

public class Test100106_元素和最小的山形三元组I {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSum(new int[]{8, 6, 1, 5, 3}));
        System.out.println(new Solution().minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
        System.out.println(new Solution().minimumSum(new int[]{6, 5, 4, 3, 4, 5}));

    }

    static class Solution {
        public int minimumSum(int[] nums) {
            int len = nums.length;
            int sum = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        if (nums[i] < nums[j] && nums[j] > nums[k]) {
                            sum = Math.min(sum, nums[i] + nums[j] + nums[k]);
                        }
                    }
                }
            }
            return sum == Integer.MAX_VALUE ? -1 : sum;
        }
    }

}
