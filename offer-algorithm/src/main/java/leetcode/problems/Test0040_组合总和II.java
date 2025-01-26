package leetcode.problems;

import java.util.*;

public class Test0040_组合总和II {

    public static void main(String[] args) {
        // candidates = [10,1,2,7,6,1,5], target = 8
        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        // candidates = [2,5,2,1,2], target = 5
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // 先排序
            Arrays.sort(candidates);
            // 再递归
            dfs(candidates, 0, target, new ArrayList<>());
            return res;
        }

        private void dfs(int[] candidates, int idx, int target, List<Integer> current) {
            if (target == 0) {
                res.add(new ArrayList<>(current));
                return;
            }
            if (idx >= candidates.length || target < 0) {
                return;
            }
            // 要candidates[idx]
            current.add(candidates[idx]);
            dfs(candidates, idx + 1, target - candidates[idx], current);
            current.remove(current.size() - 1);
            // 不要candidates[idx]，这时应该跳到下一个不相同的数，避免遇到和当前数相同数的情况
            while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
                idx++;
            }
            dfs(candidates, idx + 1, target, current);
        }
    }

}
