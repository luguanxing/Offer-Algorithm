package leetcode.contest.week294;

import java.util.Arrays;
import java.util.Comparator;

public class Test6076_表示一个折线图的最少线段数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}}));
        System.out.println(new Solution().minimumLines(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}}));
        System.out.println(new Solution().minimumLines(new int[][]{{1, 1}}));
    }

    static class Solution {
        public int minimumLines(int[][] stockPrices) {
            if (stockPrices.length == 1) {
                return 0;
            }
            Arrays.sort(stockPrices, Comparator.comparingInt(p -> p[0]));
            int res = 1;
            int dx = stockPrices[1][0] - stockPrices[0][0];
            int dy = stockPrices[1][1] - stockPrices[0][1];
            for (int i = 2; i < stockPrices.length; i++) {
                int currentDx = stockPrices[i][0] - stockPrices[i - 1][0];
                int currentDy = stockPrices[i][1] - stockPrices[i - 1][1];
                long c1 = currentDy * dx;
                long c2 = dy * currentDx;
                if (c1 == c2) {
                    continue;
                }
                dx = currentDx;
                dy = currentDy;
                res++;
            }
            return res;
        }
    }

}
