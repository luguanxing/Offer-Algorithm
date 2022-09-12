package leetcode.problems;

import java.util.Arrays;

public class Test1608_特殊数组的特征值 {

    public static void main(String[] args) {
        System.out.println(new Solution().specialArray(new int[]{3, 5}));
        System.out.println(new Solution().specialArray(new int[]{0, 0}));
        System.out.println(new Solution().specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(new Solution().specialArray(new int[]{3, 6, 7, 7, 0}));
    }

    static class Solution {
        public int specialArray(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);
            for (int x = 0; x <= len; x++) {
                // nums[len-x]及之后的数要大于等于x，之前的要小于x
                if (len - x - 1 >= 0 && nums[len - x - 1] >= x) {
                    continue;
                }
                if (len - x >= 0 && nums[len - x] >= x) {
                    return x;
                }
            }
            return -1;
        }
    }

}
