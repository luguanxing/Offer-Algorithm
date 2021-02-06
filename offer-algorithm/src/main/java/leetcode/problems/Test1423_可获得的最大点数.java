package leetcode.problems;

import java.util.Arrays;

public class Test1423_可获得的最大点数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(
                new int[]{1, 2, 3, 4, 5, 6, 1}, 3
        ));
        System.out.println(new Solution().maxScore(
                new int[]{2, 2, 2}, 2
        ));
        System.out.println(new Solution().maxScore(
                new int[]{9, 7, 7, 9, 7, 7, 9}, 7
        ));
        System.out.println(new Solution().maxScore(
                new int[]{1, 1000, 1}, 1
        ));
        System.out.println(new Solution().maxScore(
                new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3
        ));
    }

    static class Solution {
        public int maxScore(int[] cardPoints, int k) {
            // 计算窗口内的最小值
            int windowLen = cardPoints.length - k;
            int sum = 0;
            for (int i = 0; i < windowLen; i++) {
                sum += cardPoints[i];
            }
            int min = sum;
            for (int i = windowLen; i < cardPoints.length; i++) {
                sum += cardPoints[i];
                sum -= cardPoints[i - windowLen];
                min = Math.min(min, sum);
            }
            return Arrays.stream(cardPoints).sum() - min;
        }
    }

}
