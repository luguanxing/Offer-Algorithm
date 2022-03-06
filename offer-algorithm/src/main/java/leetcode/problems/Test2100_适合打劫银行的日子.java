package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test2100_适合打劫银行的日子 {

    public static void main(String[] args) {
        System.out.println(new Solution().goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        System.out.println(new Solution().goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(new Solution().goodDaysToRobBank(new int[]{1, 2, 3, 4, 5, 6}, 2));
        System.out.println(new Solution().goodDaysToRobBank(new int[]{1, 2, 3, 4}, 1));
        System.out.println(new Solution().goodDaysToRobBank(new int[]{4, 3, 2, 1}, 1));
        System.out.println(new Solution().goodDaysToRobBank(new int[]{1, 2, 3, 4}, 0));
        System.out.println(new Solution().goodDaysToRobBank(new int[]{1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8}, 2));
    }

    static class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            int len = security.length;
            // 使用动态规划先保存连续递增和递减的个数
            int[] increaseCnt = new int[len];
            int[] decreaseCnt = new int[len];
            for (int i = 1; i < len; i++) {
                if (security[i] >= security[i - 1]) {
                    increaseCnt[i] = increaseCnt[i - 1] + 1;
                }
                if (security[i] <= security[i - 1]) {
                    decreaseCnt[i] = decreaseCnt[i - 1] + 1;
                }
            }
            // 看每个数是否满足前面递减后面递增
            List<Integer> res = new ArrayList<>();
            for (int i = time; i + time < len; i++) {
                if (decreaseCnt[i] >= time && increaseCnt[i + time] >= time) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
