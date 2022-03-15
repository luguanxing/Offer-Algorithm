package leetcode.problems;

public class Test2044_统计按位或能得到最大值的子集数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(new Solution().countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(new Solution().countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

    static class Solution {
        private int res = 0;

        public int countMaxOrSubsets(int[] nums) {
            int max = 0;
            for (int num : nums) {
                max |= num;
            }
            dfs(nums, 0, 0, max);
            return res;
        }

        private void dfs(int[] nums, int index, int current, int max) {
            if (index == nums.length) {
                if (current == max) {
                    res++;
                }
                return;
            }
            // 选择nums[index]
            dfs(nums, index + 1, current | nums[index], max);
            // 不选择nums[index]
            dfs(nums, index + 1, current, max);
        }
    }

}
