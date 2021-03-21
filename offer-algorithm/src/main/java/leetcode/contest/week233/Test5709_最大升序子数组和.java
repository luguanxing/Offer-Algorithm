package leetcode.contest.week233;

public class Test5709_最大升序子数组和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(new Solution().maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(new Solution().maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
        System.out.println(new Solution().maxAscendingSum(new int[]{100, 10, 1}));
    }

    static class Solution {
        public int maxAscendingSum(int[] nums) {
            int last = nums[0];
            int sum = last;
            int res = sum;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > last) {
                    last = nums[i];
                    sum += last;
                    res = Math.max(res, sum);
                } else {
                    last = nums[i];
                    sum = last;
                }
            }
            return res;
        }
    }

}
