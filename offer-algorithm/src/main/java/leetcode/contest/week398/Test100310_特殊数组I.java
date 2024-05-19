package leetcode.contest.week398;

public class Test100310_特殊数组I {

    public static void main(String[] args) {
        System.out.println(new Solution().isArraySpecial(new int[]{1}));
        System.out.println(new Solution().isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(new Solution().isArraySpecial(new int[]{4, 3, 1, 6}));
    }

    static class Solution {
        public boolean isArraySpecial(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if ((nums[i] % 2 == 1 && nums[i - 1] % 2 == 1) || (nums[i] % 2 == 0 && nums[i - 1] % 2 == 0)) {
                    return false;
                }
            }
            return true;
        }
    }

}
