package leetcode.contest.week192;

import java.util.Arrays;

public class Test5428_重新排列数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(new Solution().shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(new Solution().shuffle(new int[]{1, 1, 2, 2}, 2)));
    }

    static class Solution {
        public int[] shuffle(int[] nums, int n) {
            if (nums == null) {
                return null;
            }
            int[] result = new int[2 * n];
            for (int i = 0; i < n; i++) {
                result[2 * i] = nums[i];
                result[2 * i + 1] = nums[i + n];
            }
            return result;
        }
    }

}
