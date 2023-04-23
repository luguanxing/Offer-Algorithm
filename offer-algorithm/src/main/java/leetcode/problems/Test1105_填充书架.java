package leetcode.problems;

import java.util.Arrays;

public class Test1105_填充书架 {

    public static void main(String[] args) {
        System.out.println(new Solution().minHeightShelves(
                new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4
        ));
        System.out.println(new Solution().minHeightShelves(
                new int[][]{{1, 3}, {2, 4}, {3, 2}}, 6
        ));
    }

    static class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            int len = books.length;
            // dp[i]表示放第i本书最小高度
            int[] dp = new int[len];
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            // 枚举前面的书，在满足限制条件的情况下找出dp[i]最小值
            // dp[i] = min(dp[j-1] + max(books[j-i][1]))，其中0<j<=i并且sum(books[j-i][1])<=shelfWidth
            dp[0] = books[0][1];
            for (int i = 1; i < len; i++) {
                int maxH = 0;
                int sumW = 0;
                for (int j = i; j >= 0; j--) {
                    maxH = Math.max(maxH, books[j][1]);
                    sumW += books[j][0];
                    if (sumW > shelfWidth) {
                        break;
                    }
                    dp[i] = Math.min(dp[i], maxH + (j - 1 >= 0 ? dp[j - 1] : 0));
                }
            }
            return dp[len - 1];
        }
    }

}
