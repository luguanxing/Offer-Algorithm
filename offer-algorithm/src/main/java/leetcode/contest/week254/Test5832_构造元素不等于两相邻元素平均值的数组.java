package leetcode.contest.week254;

import java.util.Arrays;

public class Test5832_构造元素不等于两相邻元素平均值的数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rearrangeArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(new Solution().rearrangeArray(new int[]{6, 2, 0, 9, 7})));
        System.out.println(Arrays.toString(new Solution().rearrangeArray(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new Solution().rearrangeArray(new int[]{0, 4, 1, 5, 3})));
    }

    static class Solution {
        public int[] rearrangeArray(int[] nums) {
            int len = nums.length;
            boolean isOk = false;
            while (!isOk) {
                for (int i = 1; i < len - 1; i++) {
                    int prev = nums[i - 1];
                    int mid = nums[i];
                    int next = nums[i + 1];
                    if (mid * 2 == prev + next) {
                        int tmp = nums[len - 1];
                        nums[len - 1] = mid;
                        nums[i] = tmp;
                    }
                }
                isOk = true;
            }
            return nums;
        }
    }

}
