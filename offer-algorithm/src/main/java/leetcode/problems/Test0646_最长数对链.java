package leetcode.problems;

import java.util.Arrays;

public class Test0646_最长数对链 {

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    static class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (pair1, pair2) -> {
                int s1 = pair1[0];
                int e1 = pair1[1];
                int s2 = pair2[0];
                int e2 = pair2[1];
                // 优先按end升序排序
                if (e1 != e2) {
                    return Integer.compare(e1, e2);
                }
                return Integer.compare(s1, s2);
            });
            // dp[i]表示以以第i对结尾的数链长
            int len = pairs.length;
            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }

}
