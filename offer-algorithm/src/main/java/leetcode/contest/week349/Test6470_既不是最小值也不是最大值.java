package leetcode.contest.week349;

import java.util.Arrays;

public class Test6470_既不是最小值也不是最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().findNonMinOrMax(new int[]{3, 2, 1, 4}));
        System.out.println(new Solution().findNonMinOrMax(new int[]{1, 1}));
        System.out.println(new Solution().findNonMinOrMax(new int[]{2, 1, 3}));
    }

    static class Solution {
        public int findNonMinOrMax(int[] nums) {
            int max = Arrays.stream(nums).max().getAsInt();
            int min = Arrays.stream(nums).min().getAsInt();
            for (int num : nums) {
                if (num != max && num != min) {
                    return num;
                }
            }
            return -1;
        }
    }

}
