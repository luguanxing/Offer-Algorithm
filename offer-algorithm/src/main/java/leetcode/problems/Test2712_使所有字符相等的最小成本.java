package leetcode.problems;

import java.util.Arrays;

public class Test2712_使所有字符相等的最小成本 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCost("0011"));
        System.out.println(new Solution().minimumCost("010101"));
    }

    static class Solution {
        public long minimumCost(String s) {
            int len = s.length();
            if (len <= 1) {
                return 0;
            }
            // 计算前后顺序改成0和1的代价
            long[][] prefix = getDp(s);
            long[][] suffix = getDp(new StringBuilder(s).reverse().toString());
            long res = Math.min(prefix[0][0] + suffix[0][len - 2], prefix[1][0] + suffix[1][len - 2]);
            for (int i = 0; i < len - 1; i++) {
                // 全部改成0最小代价
                res = Math.min(res, prefix[0][i] + suffix[0][len - 2 - i]);
                // 全部改成1最小代价
                res = Math.min(res, prefix[1][i] + suffix[1][len - 2 - i]);
            }
            return res;
        }

        public long[][] getDp(String s) {
            int len = s.length();
            // dp0[i] dp1[i]表示将前i个字符变成0或1字符的最小成本
            long[] dp0 = new long[len];
            long[] dp1 = new long[len];
            Arrays.fill(dp0, Integer.MAX_VALUE);
            Arrays.fill(dp1, Integer.MAX_VALUE);
            char[] chars = s.toCharArray();
            dp0[0] = chars[0] == '0' ? 0 : 1;
            dp1[0] = chars[0] == '1' ? 0 : 1;
            for (int i = 1; i < len; i++) {
                char c = chars[i];
                if (c == '0') {
                    // 当前是0，改成全都是0，只需要改前面
                    dp0[i] = Math.min(dp0[i - 1], dp1[i - 1] + i);
                    // 当前是0，改成全都是1，需要改全部
                    dp1[i] = Math.min(dp0[i - 1] + i + 1, dp1[i - 1] + i + 1 + i);
                } else {
                    // 当前是1，改成全都是1，只需要改前面
                    dp1[i] = Math.min(dp1[i - 1], dp0[i - 1] + i);
                    // 当前是1，改成全都是0，需要改全部
                    dp0[i] = Math.min(dp1[i - 1] + i + 1, dp0[i - 1] + i + 1 + i);
                }
            }
            return new long[][]{dp0, dp1};
        }
    }

}
