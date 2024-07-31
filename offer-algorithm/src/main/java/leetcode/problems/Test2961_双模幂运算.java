package leetcode.problems;

import java.util.*;

public class Test2961_双模幂运算 {

    public static void main(String[] args) {
        // variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
        System.out.println(new Solution().getGoodIndices(new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2));
        // variables = [[39,3,1000,1000]], target = 17
        System.out.println(new Solution().getGoodIndices(new int[][]{{39, 3, 1000, 1000}}, 17));
        // variables = [[2,2,3,2],[1,3,3,2],[3,2,2,3],[3,1,2,3],[1,2,3,1],[2,2,2,2],[2,1,3,1],[3,2,2,2],[2,1,3,1],[3,3,1,3]], target = 0
        System.out.println(new Solution().getGoodIndices(new int[][]{{2, 2, 3, 2}, {1, 3, 3, 2}, {3, 2, 2, 3}, {3, 1, 2, 3}, {1, 2, 3, 1}, {2, 2, 2, 2}, {2, 1, 3, 1}, {3, 2, 2, 2}, {2, 1, 3, 1}, {3, 3, 1, 3}}, 0));
    }

    static class Solution {
        public List<Integer> getGoodIndices(int[][] variables, int target) {
            // 使用快速幂计算
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < variables.length; i++) {
                int[] variable = variables[i];
                int a = variable[0];
                int b = variable[1];
                int c = variable[2];
                int m = variable[3];
                if (powMod(powMod(a, b, 10), c, m) == target) {
                    res.add(i);
                }
            }
            return res;
        }

        private int powMod(int num, int pow, int mod) {
            // 快速幂的实现
            int res = 1;
            while (pow > 0) {
                // pow为奇数时res要补乘上一个num
                if (pow % 2 == 1) {
                    res = res * num % mod;
                }
                // 对累乘凑num^2
                num = num * num % mod;
                pow /= 2;
            }
            return res;
        }
    }

}
