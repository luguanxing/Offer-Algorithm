package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0078_子集 {

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
        System.out.println(new Solution().subsets(new int[]{0}));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0);
            return result;
        }

        private void dfs(int[] nums, int index) {
            if (index == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }
            // 选择nums[index]
            current.add(nums[index]);
            dfs(nums, index + 1);
            current.remove(current.size() - 1);
            // 不选择nums[index]
            dfs(nums, index + 1);
        }
    }

}
