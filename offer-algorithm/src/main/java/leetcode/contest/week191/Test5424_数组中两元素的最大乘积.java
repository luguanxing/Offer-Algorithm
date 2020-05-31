package leetcode.contest.week191;

public class Test5424_数组中两元素的最大乘积 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{3, 4, 5, 2}));
        System.out.println(new Solution().maxProduct(new int[]{1, 5, 4, 5}));
        System.out.println(new Solution().maxProduct(new int[]{3, 7}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
                }
            }
            return max;
        }
    }

}
