package leetcode.contest.week359;

import java.util.HashSet;
import java.util.Set;

public class Test6450_k_avoiding数组的最小总和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSum(5, 4));
        System.out.println(new Solution().minimumSum(2, 6));
    }

    static class Solution {
        public int minimumSum(int n, int k) {
            Set<Integer> set = new HashSet<>();
            int idx = 1;
            while (set.size() < n) {
                if (set.contains(k - idx)) {
                    idx++;
                    continue;
                }
                set.add(idx++);
            }
            return set.stream().reduce(Integer::sum).get();
        }
    }

}
