package leetcode.contest.week296;

import java.util.Arrays;

public class Test6091_划分数组使最大差为K {

    public static void main(String[] args) {
        System.out.println(new Solution().partitionArray(new int[]{3, 6, 1, 2, 5}, 2));
        System.out.println(new Solution().partitionArray(new int[]{1, 2, 3}, 1));
        System.out.println(new Solution().partitionArray(new int[]{2, 2, 4, 5}, 0));
    }

    static class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);
            int res = 1;
            int currentMin = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int current = nums[i];
                if (current - currentMin > k) {
                    res++;
                    currentMin = current;
                }
            }
            return res;
        }
    }

}
