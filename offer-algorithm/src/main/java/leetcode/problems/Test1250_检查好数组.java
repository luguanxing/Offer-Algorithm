package leetcode.problems;

public class Test1250_检查好数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().isGoodArray(new int[]{12, 5, 7, 23}));
        System.out.println(new Solution().isGoodArray(new int[]{29, 6, 10}));
        System.out.println(new Solution().isGoodArray(new int[]{3, 6}));
    }

    static class Solution {
        public boolean isGoodArray(int[] nums) {
            int div = nums[0];
            for (int i = 1; i < nums.length; i++) {
                div = gcd(div, nums[i]);
            }
            return div == 1;
        }

        private int gcd(int num1, int num2) {
            while (num2 != 0) {
                int tmp = num1;
                num1 = num2;
                num2 = tmp % num2;
            }
            return num1;
        }
    }

}
