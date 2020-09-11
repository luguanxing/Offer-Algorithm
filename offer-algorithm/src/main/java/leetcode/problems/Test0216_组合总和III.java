package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0216_组合总和III {

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
        System.out.println(new Solution().combinationSum3(3, 9));
    }

    static class Solution {
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
