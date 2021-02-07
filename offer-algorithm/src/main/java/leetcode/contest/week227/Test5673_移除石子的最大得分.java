package leetcode.contest.week227;

import java.util.Arrays;

public class Test5673_移除石子的最大得分 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumScore(2, 4, 6));
        System.out.println(new Solution().maximumScore(4, 4, 6));
        System.out.println(new Solution().maximumScore(1, 8, 8));
    }

    static class Solution {
        public int maximumScore(int a, int b, int c) {
            int res = 0;
            int[] nums = new int[3];
            nums[0] = a;
            nums[1] = b;
            nums[2] = c;
            Arrays.sort(nums);
            while (nums[0] > 0 || nums[1] > 0) {
                nums[1]--;
                nums[2]--;
                Arrays.sort(nums);
                res++;
            }
            return res;
        }
    }

}
