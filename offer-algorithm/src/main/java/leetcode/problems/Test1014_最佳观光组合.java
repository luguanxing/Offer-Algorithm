package leetcode.problems;

import java.util.*;

public class Test1014_最佳观光组合 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(new Solution().maxScoreSightseeingPair(new int[]{1, 2}));
    }

    static class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            // 枚举j，记录最大的values[j]-j + 前面保存最大的(values[i] + i)
            int max = 0;
            int last = values[0] + 0;
            for (int j = 1; j < values.length; j++) {
                int current = values[j] - j;
                max = Math.max(max, current + last);
                last = Math.max(last, values[j] + j);
            }
            return max;
        }
    }

    static class Solution_OLD {
        public int maxScoreSightseeingPair(int[] A) {
            // 保留上个最佳观光点的状态
            int lastPoint = A[0];
            int max = 0;
            for (int i = 1; i < A.length; i++) {
                // 每往后一步开销加一
                lastPoint--;
                int point = A[i] + lastPoint;
                max = Math.max(max, point);
                // 更新最佳观光点
                if (lastPoint < A[i]) {
                    lastPoint = A[i];
                }
            }
            return max;
        }
    }

    static class Solution_超时 {
        public int maxScoreSightseeingPair(int[] A) {
            int max = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    int score = A[i] + A[j] + i - j;
                    max = Math.max(max, score);
                }
            }
            return max;
        }
    }

}
