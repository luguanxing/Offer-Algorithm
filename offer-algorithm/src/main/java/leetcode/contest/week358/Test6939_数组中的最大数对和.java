package leetcode.contest.week358;

public class Test6939_数组中的最大数对和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSum(new int[]{51,71,17,24,42}));
        System.out.println(new Solution().maxSum(new int[]{1, 2, 3, 4}));
    }

    static class Solution {
        public int maxSum(int[] nums) {
            int ans = -1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (maxNum(nums[i]) == maxNum(nums[j])) {
                        ans = Math.max(ans, nums[i] + nums[j]);
                    }
                }
            }
            return ans;
        }

        private int maxNum(int num) {
            int max = 0;
            while (num > 0) {
                max = Math.max(max, num % 10);
                num /= 10;
            }
            return max;
        }
    }

}
