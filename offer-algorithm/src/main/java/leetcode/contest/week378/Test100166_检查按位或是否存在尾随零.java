package leetcode.contest.week378;

public class Test100166_检查按位或是否存在尾随零 {

    public static void main(String[] args) {
        System.out.println(new Solution().hasTrailingZeros(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().hasTrailingZeros(new int[]{2, 4, 8, 16}));
        System.out.println(new Solution().hasTrailingZeros(new int[]{1, 3, 5, 7, 9}));
    }

    static class Solution {
        public boolean hasTrailingZeros(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (Integer.toBinaryString(nums[i] | nums[j]).endsWith("0")) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
