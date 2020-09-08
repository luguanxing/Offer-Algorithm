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
        private List<List<Integer>> result = new ArrayList<>();
        private List<Integer> current = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            comb(1, n, k);
            return result;
        }

        private void comb(int startIndex, int n, int k) {
            if (current.size() == k) {
                result.add(new ArrayList<>(current));
                return;
            }
            for (int i = startIndex; i <= n; i++) {
                current.add(i);
                comb(i + 1, n, k);
                current.remove(current.size() - 1);
            }
        }
    }
}
