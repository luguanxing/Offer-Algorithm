package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test0077_组合 {

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(5, 3));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return result;
        }

        private void dfs(int index, int n, int k) {
            if (current.size() == k) {
                result.add(new ArrayList<>(current));
                return;
            }
            if (index > n) {
                return;
            }
            // 选择nums[index]
            current.add(index);
            dfs(index + 1, n, k);
            current.remove(current.size() - 1);
            // 不选择nums[index]
            dfs(index + 1, n, k);
        }
    }

}
