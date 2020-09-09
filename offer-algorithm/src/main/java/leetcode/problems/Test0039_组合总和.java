package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0039_组合总和 {

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 5}, 8));
    }

    static class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        private List<Integer> current = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates, target, 0);
            return result;
        }

        public void dfs(int[] nums, int target, int index) {
            if (target < 0 || index >= nums.length) {
                return;
            }
            if (target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            // 不要当前数
            dfs(nums, target, index + 1);
            // 要了当前数
            current.add(nums[index]);
            dfs(nums, target - nums[index], index);
            current.remove(current.size() - 1);
        }
    }

}
