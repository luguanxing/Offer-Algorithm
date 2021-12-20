package leetcode.contest.week272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5958_股票平滑下跌阶段的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().getDescentPeriods(new int[]{3, 2, 1, 4}));
        System.out.println(new Solution().getDescentPeriods(new int[]{8, 6, 7, 7}));
        System.out.println(new Solution().getDescentPeriods(new int[]{1}));
        System.out.println(new Solution().getDescentPeriods(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3}));
        System.out.println(new Solution().getDescentPeriods(new int[]{4, 3}));
        System.out.println(new Solution().getDescentPeriods(new int[]{10, 9, 8, 7}));
        System.out.println(new Solution().getDescentPeriods(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7}));
        System.out.println(new Solution().getDescentPeriods(new int[]{3, 7, 4}));
        System.out.println(new Solution().getDescentPeriods(new int[]{7, 5, 4, 2}));
        System.out.println(new Solution().getDescentPeriods(new int[]{3, 7, 4, 2, 4, 8, 2, 8, 6, 5, 7, 5, 4, 2, 2, 4, 7, 7, 7, 2, 3, 5, 4, 6, 3, 8, 5, 8, 3, 6, 6, 4, 7, 2, 3, 5, 3, 3, 5, 8, 4, 4, 7, 6, 2, 8, 6, 8, 8, 5, 3, 3, 4, 4, 4, 2, 8, 3, 6, 3, 8, 6, 3, 3, 3, 7, 5, 5, 5, 2, 8, 8, 7, 7, 6, 5, 7, 3, 8, 2, 5, 5, 3, 5, 3, 7, 3, 4, 7, 5, 6, 4, 3, 6, 4, 4, 8, 7, 5, 4, 3, 7, 3, 5, 5, 2, 4, 8, 8, 8, 7, 5, 6, 8, 3, 6, 2, 5, 3, 2, 7, 7, 3, 6, 3, 4, 3, 6, 4, 7, 2, 5, 6, 3, 8, 3, 7, 4, 5, 7, 3, 7, 7, 5, 6, 2, 7, 3, 2, 8, 4, 2, 6, 2, 6, 2, 7, 5, 5, 7, 5, 4, 5, 8, 3, 2, 2, 2, 7, 2, 4, 6, 3, 8, 3, 8, 6, 7, 5, 3, 8, 3, 7, 3, 6, 2, 6, 4}));
    }

    static class Solution {
        public long getDescentPeriods(int[] prices) {
            long res=0;
            long cnt=1;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] == prices[i-1]-1) {
                    cnt++;
                } else {
                    res += cnt * (cnt+1) / 2;
                    cnt = 1;
                }
            }
            res += cnt * (cnt+1) / 2;
            return res;
        }
    }

}
