package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0077_组合 {

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(5, 3));
    }

    static class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            // 初始化
            result.clear();
            // 遍历
            dfs(1, new ArrayList<>(), n, k);
            return result;
        }

        private void dfs(int index, ArrayList<Integer> currentNums, int n, int k) {
            if (currentNums.size() == k) {
                result.add(new ArrayList<>(currentNums));
                return;
            }
            for (int i = index; i <= n; i++) {
                // 遍历index后面的数字，注意要回溯
                currentNums.add(i);
                dfs(i + 1, currentNums, n, k);
                currentNums.remove(currentNums.size() - 1);
            }
        }
    }

}
