package leetcode.contest.week304;

import java.util.Arrays;

public class Test6132_使数组中所有元素都等于零 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(new int[]{1, 5, 0, 3, 5}));
        System.out.println(new Solution().minimumOperations(new int[]{0}));
    }

    static class Solution {
        public int minimumOperations(int[] nums) {
            int res = 0;
            while (Arrays.stream(nums).sum() > 0) {
                Arrays.sort(nums);
                int current = 0;
                for (int num : nums) {
                    if (num != 0) {
                        current = num;
                        break;
                    }
                }
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        nums[i] -= current;
                    }
                }
                res++;
            }
            return res;
        }
    }

}
