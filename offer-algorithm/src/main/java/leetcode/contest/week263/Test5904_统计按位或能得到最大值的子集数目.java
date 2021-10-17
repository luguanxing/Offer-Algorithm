package leetcode.contest.week263;

public class Test5904_统计按位或能得到最大值的子集数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(new Solution().countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(new Solution().countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

    static class Solution {
        int max = 0;
        int res = 0;

        public int countMaxOrSubsets(int[] nums) {
            for (int num : nums) {
                max |= num;
            }
            check(0, nums, 0);
            return res;
        }

        private void check(int curRes, int[] nums, int index) {
            if (index == nums.length ) {
                if (curRes == max) {
                    res++;
                }
                return;
            }
            check(curRes | nums[index], nums, index + 1);
            check(curRes, nums, index + 1);
        }
    }

}
