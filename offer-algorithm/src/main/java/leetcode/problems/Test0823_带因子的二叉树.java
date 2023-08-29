package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0823_带因子的二叉树 {

    public static void main(String[] args) {
        System.out.println(new Solution().numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(new Solution().numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
        System.out.println(new Solution().numFactoredBinaryTrees(new int[]{15, 13, 22, 7, 11}));
        System.out.println(new Solution().numFactoredBinaryTrees(new int[]{18, 3, 6, 2}));
    }

    static class Solution {
        Map<Integer, Long> map = new HashMap<>();
        Set<Integer> set;

        public int numFactoredBinaryTrees(int[] arr) {
            set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            int MOD = 1000000007;
            long res = 0;
            for (int num : arr) {
                res += getRootCnt(num, arr);
                res %= MOD;
            }
            return (int) res;
        }

        // 计算出构成以num为根节点的方法数，记忆化搜索
        private long getRootCnt(int num, int[] arr) {
            if (map.containsKey(num)) {
                return map.get(num);
            }
            long cnt = 1;
            for (int n : arr) {
                if (num % n == 0 && set.contains(num / n)) {
                    cnt += getRootCnt(n, arr) * getRootCnt(num / n, arr);
                }
            }
            map.put(num, cnt);
            return cnt;
        }
    }

}
