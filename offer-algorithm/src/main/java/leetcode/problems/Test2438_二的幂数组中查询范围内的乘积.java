package leetcode.problems;

import java.util.*;

public class Test2438_二的幂数组中查询范围内的乘积 {

    public static void main(String[] args) {
        // n = 15, queries = [[0,1],[2,2],[0,3]]
        System.out.println(Arrays.toString(new Solution().productQueries(15, new int[][]{{1, 1}, {2, 2}, {0, 3}})));
        // n = 2, queries = [[0,0]]
        System.out.println(Arrays.toString(new Solution().productQueries(2, new int[][]{{0, 0}})));
    }

    static class Solution {
        public int[] productQueries(int n, int[][] queries) {
            // 分解 n 为二的幂的和
            List<Integer> list = new ArrayList<>();
            while (n > 0) {
                int cur = 1;
                for (int pow = 0; pow < 31; pow++) {
                    if (cur * 2 > n) {
                        break;
                    }
                    cur *= 2;
                }
                list.add(0, cur);
                n -= cur;
            }
            // 计算每个查询范围内的乘积
            int[] res = new int[queries.length];
            int MOD = (int) 1e9 + 7;
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                long cur = 1;
                for (int j = query[0]; j <= query[1]; j++) {
                    cur = cur * list.get(j);
                    cur = cur % MOD;
                }
                res[i] = (int) cur;
            }
            return res;
        }
    }

}
