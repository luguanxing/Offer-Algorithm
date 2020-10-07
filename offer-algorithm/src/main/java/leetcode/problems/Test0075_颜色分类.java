package leetcode.problems;

import java.util.Arrays;

public class Test0075_颜色分类 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(nums));
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void sortColors(int[] nums) {
            int red = 0;
            int white = 0;
            int blue = 0;
            for (int num : nums) {
                switch (num) {
                    case 0:
                        red++;
                        break;
                    case 1:
                        white++;
                        break;
                    case 2:
                        blue++;
                        break;
                    default:
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (red > 0) {
                    nums[i] = 0;
                    red--;
                } else if (white > 0) {
                    nums[i] = 1;
                    white--;
                } else if (blue > 0) {
                    nums[i] = 2;
                    blue--;
                }
            }
        }
    }

}
