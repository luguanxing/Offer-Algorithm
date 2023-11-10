package leetcode.problems;

import java.util.Arrays;

public class Test2300_咒语和药水的成功对数 {

    public static void main(String[] args) {
        // spells = [5,1,3], potions = [1,2,3,4,5], success = 7
        System.out.println(Arrays.toString(new Solution().successfulPairs(
                new int[]{5, 1, 3},
                new int[]{1, 2, 3, 4, 5},
                7
        )));
        // spells = [3,1,2], potions = [8,5,8], success = 16
        System.out.println(Arrays.toString(new Solution().successfulPairs(
                new int[]{3, 1, 2},
                new int[]{8, 5, 8},
                16
        )));
    }

    static class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int len = spells.length;
            Arrays.sort(potions);
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                int spell = spells[i];
                int needPotion = (int) Math.ceil(success * 1.0 / spell);
                int idx = leftBound(potions, needPotion);
                res[i] = potions.length - idx;
            }
            return res;
        }

        private int leftBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
