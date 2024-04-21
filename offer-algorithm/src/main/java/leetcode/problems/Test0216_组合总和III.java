package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0216_组合总和III {

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
        System.out.println(new Solution().combinationSum3(3, 9));
        System.out.println(new Solution().combinationSum3(4, 1));
        System.out.println(new Solution().combinationSum3(1, 3));
    }

    static class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(k, n, 1, new ArrayList<>());
            return result;
        }

        private void dfs(int leftCnt, int target, int index, List<Integer> currents) {
            if (leftCnt == 0 && target == 0) {
                result.add(new ArrayList<>(currents));
                return;
            }
            if (index > target || index > 9 || leftCnt == 0) {
                return;
            }
            // 选择当前数
            currents.add(index);
            dfs(leftCnt - 1, target - index, index + 1, currents);
            currents.remove(currents.size() - 1);
            // 不选当前数
            dfs(leftCnt, target, index + 1, currents);
        }
    }

    static class Solution_OLD {
        private List<List<Integer>> result = new ArrayList<>();
        private List<Integer> current = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            check(k, n, 1);
            return result;
        }

        private void check(int k, int n, int index) {
            if (n == 0 && current.size() == k) {
                result.add(new ArrayList<>(current));
                return;
            }
            for (int i = index; i <= 9; i++) {
                if (i <= n) {
                    current.add(i);
                    check(k, n - i, i + 1);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

}
