package leetcode.contest.week328;

import java.util.Arrays;

public class Test6291_数组元素和与数字和的绝对差 {

    public static void main(String[] args) {
        System.out.println(new Solution().differenceOfSum(new int[]{1, 15, 6, 3}));
        System.out.println(new Solution().differenceOfSum(new int[]{1, 2, 3, 4}));
    }

    static class Solution {
        public int differenceOfSum(int[] nums) {
            int sum1 = Arrays.stream(nums).sum();
            int sum2 = 0;
            for (int num : nums) {
                while (num > 0) {
                    sum2 += num % 10;
                    num /= 10;
                }
            }
            return Math.abs(sum1 - sum2);
        }
    }

}
