package leetcode.problems;

import java.util.Arrays;

public class Test0283_移动零 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution_优化().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution_优化 {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
            }
        }
    }

}
