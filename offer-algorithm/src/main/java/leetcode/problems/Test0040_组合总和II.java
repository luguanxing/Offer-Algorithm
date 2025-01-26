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
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, 0, target, new ArrayList<>());
            return res;
        }

        private void dfs(int[] candidates, int idx, int target, List<Integer> current) {
            if (target == 0) {
                List<Integer> ans = new ArrayList<>(current);
                res.add(ans);
                return;
            }
            if (idx >= candidates.length || target < 0) {
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                // 减枝，当i>idx且candidates[i]==candidates[i-1]时，说明枚举的数和循环的上一个相同，应该跳过重复
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                // 必须要candidates[i]，因为上面有循环
                current.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], current);
                current.remove(current.size() - 1);
            }
        }
    }

    static class Solution_DFS {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            dfs(candidates, 0, target, new ArrayList<>());
            return res;
        }

        private void dfs(int[] candidates, int idx, int target, List<Integer> current) {
            if (target == 0) {
                List<Integer> ans = new ArrayList<>(current);
                Collections.sort(ans);
                if (!set.contains(ans.toString())) {
                    res.add(ans);
                    set.add(ans.toString());
                }
                return;
            }
            if (idx >= candidates.length || target < 0) {
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                // 不要candidates[i]
                dfs(candidates, i + 1, target, current);
                // candidates[i]
                current.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], current);
                current.remove(current.size() - 1);
            }
        }
    }

}
