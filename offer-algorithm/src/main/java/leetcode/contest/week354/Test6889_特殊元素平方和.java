package leetcode.contest.week354;

public class Test6889_特殊元素平方和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfSquares(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().sumOfSquares(new int[]{2, 7, 1, 19, 18, 3}));
    }

    static class Solution {
        public int sumOfSquares(int[] nums) {
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (n % (i + 1) == 0) {
                    res += nums[i] * nums[i];
                }
            }
            return res;
        }
    }

}
