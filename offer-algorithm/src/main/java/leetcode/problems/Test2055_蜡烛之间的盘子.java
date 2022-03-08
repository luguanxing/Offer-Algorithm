package leetcode.problems;

import java.util.Arrays;

public class Test2055_蜡烛之间的盘子 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().platesBetweenCandles("**|**|***|", new int[][]{
                {2, 5}, {5, 9}
        })));
        System.out.println(Arrays.toString(new Solution().platesBetweenCandles("***|**|*****|**||**|*", new int[][]{
                {1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}
        })));
        System.out.println(Arrays.toString(new Solution().platesBetweenCandles("||*", new int[][]{
                {2, 2}
        })));
    }

    static class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int len = s.length();
            // 记录每个位置左侧最近的蜡烛和右侧最近的蜡烛
            int[] cloestLeft = new int[len];
            int[] cloestRight = new int[len];
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '|') {
                    cloestLeft[i] = i;
                } else {
                    if (i == 0) {
                        cloestLeft[i] = Integer.MIN_VALUE;
                    } else {
                        cloestLeft[i] = cloestLeft[i - 1];
                    }
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '|') {
                    cloestRight[i] = i;
                } else {
                    if (i == len - 1) {
                        cloestRight[i] = Integer.MAX_VALUE;
                    } else {
                        cloestRight[i] = cloestRight[i + 1];
                    }
                }
            }
            // 记录每个位置蜡烛的累积个数
            int[] sum = new int[len];
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '|') {
                    if (i == 0) {
                        sum[i] = 1;
                    } else {
                        sum[i] = sum[i - 1] + 1;
                    }
                } else {
                    if (i == 0) {
                        sum[i] = 0;
                    } else {
                        sum[i] = sum[i - 1];
                    }
                }
            }
            // 计算查询的区间，范围 = [左边界的最近右蜡烛，右边界的最近左蜡烛] - 中间累积的蜡烛
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int leftBound = query[0];
                int rightBound = query[1];
                int left = cloestRight[leftBound];
                int right = cloestLeft[rightBound];
                if (left == Integer.MAX_VALUE || right == Integer.MIN_VALUE) {
                    res[i] = 0;
                    continue;
                }
                res[i] = Math.max(right - left - (sum[right] - sum[left]), 0);
            }
            return res;
        }
    }

}
